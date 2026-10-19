package com.logicommerce.sdktest.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import com.logicommerce.sdk.models.basket.BasketChanges;
import com.logicommerce.sdk.models.basket.BasketContext;
import com.logicommerce.sdk.models.basket.BasketView;
import com.logicommerce.sdk.models.basket.ClientInfo;
import com.logicommerce.sdk.models.basket.RowChange;
import com.logicommerce.sdk.resources.BasketResource;
import com.logicommerce.sdk.resources.PluginResourceException;

/**
 * <p>In-memory {@link BasketResource} for plugin tests. It stores {@link BasketView}s by token and does not compute
 * baskets: no pricing, recalculation, rejections or voucher code results.</p>
 *
 * <ul>
 * <li>{@link #addBasket(BasketView)} registers an existing basket.</li>
 * <li>{@link #create(BasketContext, BasketChanges) create} returns the basket given to
 * {@link #setCreateResult(BasketView)}, which it consumes, and throws an {@link IllegalStateException} when none was
 * given. It stores that basket under its token together with {@link BasketChanges#getStorage()}.</li>
 * <li>{@link #apply(String, BasketChanges, ClientInfo) apply} records the changes and returns the stored basket, or
 * the basket given to {@link #setApplyResult(BasketView)}, which then replaces the stored one.</li>
 * </ul>
 *
 * <p>Arguments are validated as production does, before anything else: a null or blank token, a null context or
 * changes, a null row, a row without a positive product id and quantity or with null option value ids, a null voucher
 * code, and storage entries or keys that are empty, contain {@code '.'} or NUL or start with {@code '$'} (also in
 * {@link #removeStorage(String, Set) removeStorage}) or have null values, throw an {@link IllegalArgumentException}.</p>
 *
 * <p>The one-basket-per-request rule is always enforced, as in production: once create, get, apply or delete has
 * loaded or created a basket, calling any of them for another token, whether or not that basket exists, throws an
 * {@link IllegalStateException}. A call that finds no basket, or a failed create, keeps none. A failed get, apply or
 * delete of an existing basket keeps it: production claims the slot as soon as it finds the basket, before
 * recalculating, mapping, updating or deleting it. The fake also keeps it for an injected failure that stands for one
 * production hits before claiming the slot (a failed basket read or request context rebuild), where production keeps
 * none, so plugin code must not rely on either outcome. Current core also keeps the slot when apply finds the basket
 * deleted concurrently and returns null; the fake follows the SDK wording, under which a call that finds no basket
 * keeps none. Call {@link #newRequest()} between simulated plugin requests, or {@link #newRequest(String)} to simulate
 * a request in which the platform already serves a basket.</p>
 *
 * <p>The fake simulates one request at a time and is not thread-safe: its served basket stands for the slot of the
 * single request being simulated, whereas production keeps one slot per request. Do not share an instance between
 * threads; a concurrent-request test needs its own synchronization around each simulated request.</p>
 *
 * <p>{@link #failWith(PluginResourceException)} makes every operation throw the given {@link PluginResourceException},
 * {@link #failWith(String, PluginResourceException)} every call of one method, and
 * {@link #failWith(String, PluginResourceException, int)} only the next calls of that method, which then succeed
 * again (to test retries); counted failures are thrown first, and the same exception instance every time. Failures
 * are thrown after the arguments and the one-basket rule are checked and after an existing basket is served, to test
 * infrastructure failures, and the fake applies nothing else on such a failure.</p>
 *
 * <p>Production gives no such guarantee: the basket and its plugin storage live in MongoDB, which the transaction does
 * not roll back, so a failed apply may already have saved the changes, and a failed delete may already have cleared the
 * basket's plugin storage while keeping the basket. Plugins must not assume either outcome. To test that their retries
 * are idempotent, {@link #failAfterApplyingWith(String, PluginResourceException)} makes every call of apply or delete,
 * and {@link #failAfterApplyingWith(String, PluginResourceException, int)} only the next ones, throw after the work
 * that production may have done: apply records and saves the changes, delete clears the plugin storage and keeps the
 * basket. A call that finds no basket does not consume them. {@link #clearFailures()} undoes every injected
 * failure.</p>
 */
public class BasketResourceFake implements BasketResource {

	private static final Set<String> FAIL_AFTER_APPLYING_METHODS = Set.of("apply", "delete");

	private final Map<String, BasketView> baskets = new LinkedHashMap<>();

	private final Map<String, Map<String, String>> storages = new LinkedHashMap<>();

	private final List<BasketChanges> changes = new ArrayList<>();

	private final ResourceFailures failures = new ResourceFailures(BasketResource.class);

	private final ResourceFailures failuresAfterApplying = new ResourceFailures(BasketResource.class);

	private BasketView createResult;

	private BasketView applyResult;

	private BasketContext lastContext;

	private ClientInfo lastClient;

	private String servedToken;

	@Override
	public BasketView create(BasketContext context, BasketChanges changes) throws PluginResourceException {
		requireArgument(context, "context");
		requireValidChanges(changes);
		Map<String, String> storage = changes.getStorage();
		if (storage != null) {
			requireValidEntries(storage);
		}
		if (createResult == null) {
			throw new IllegalStateException("Call setCreateResult before create");
		}
		if (servedToken != null) {
			throw new IllegalStateException("Another basket is already served in this request");
		}
		failures.check("create");
		String token = createResult.getToken();
		lastContext = context;
		lastClient = context.getClient();
		this.changes.add(changes);
		baskets.put(token, createResult);
		storages.put(token, storage == null ? new LinkedHashMap<>() : new LinkedHashMap<>(storage));
		servedToken = token;
		BasketView created = createResult;
		createResult = null;
		return created;
	}

	@Override
	public BasketView get(String token, ClientInfo client) throws PluginResourceException {
		requireToken(token);
		requireFreeSlotFor(token);
		BasketView basket = baskets.get(token);
		serveIfFound(token, basket != null);
		failures.check("get");
		lastClient = client;
		return basket;
	}

	@Override
	public BasketView apply(String token, BasketChanges changes, ClientInfo client) throws PluginResourceException {
		requireToken(token);
		requireValidChanges(changes);
		requireFreeSlotFor(token);
		boolean found = baskets.containsKey(token);
		serveIfFound(token, found);
		failures.check("apply");
		lastClient = client;
		if (!found) {
			return null;
		}
		this.changes.add(changes);
		if (applyResult != null) {
			baskets.put(token, applyResult);
			applyResult = null;
		}
		failuresAfterApplying.check("apply");
		return baskets.get(token);
	}

	@Override
	public boolean delete(String token) throws PluginResourceException {
		requireToken(token);
		requireFreeSlotFor(token);
		boolean found = baskets.containsKey(token);
		serveIfFound(token, found);
		failures.check("delete");
		if (!found) {
			return false;
		}
		storages.put(token, new LinkedHashMap<>());
		failuresAfterApplying.check("delete");
		baskets.remove(token);
		storages.remove(token);
		return true;
	}

	@Override
	public boolean putStorage(String token, Map<String, String> entries) throws PluginResourceException {
		requireToken(token);
		requireArgument(entries, "entries");
		requireValidEntries(entries);
		failures.check("putStorage");
		if (!baskets.containsKey(token)) {
			return false;
		}
		storages.computeIfAbsent(token, key -> new LinkedHashMap<>()).putAll(entries);
		return true;
	}

	@Override
	public boolean removeStorage(String token, Set<String> keys) throws PluginResourceException {
		requireToken(token);
		requireArgument(keys, "keys");
		requireValidKeys(keys);
		failures.check("removeStorage");
		if (!baskets.containsKey(token)) {
			return false;
		}
		storages.computeIfAbsent(token, key -> new LinkedHashMap<>()).keySet().removeAll(keys);
		return true;
	}

	public void addBasket(BasketView basket) {
		baskets.put(basket.getToken(), basket);
		storages.putIfAbsent(basket.getToken(), new LinkedHashMap<>());
	}

	public BasketView getBasket(String token) {
		return baskets.get(token);
	}

	public void setCreateResult(BasketView createResult) {
		this.createResult = createResult;
	}

	public void setApplyResult(BasketView applyResult) {
		this.applyResult = applyResult;
	}

	public Map<String, String> getStorage(String token) {
		return storages.get(token);
	}

	public List<BasketChanges> getChanges() {
		return changes;
	}

	public BasketChanges getLastChanges() {
		return changes.isEmpty() ? null : changes.get(changes.size() - 1);
	}

	public BasketContext getLastContext() {
		return lastContext;
	}

	public ClientInfo getLastClient() {
		return lastClient;
	}

	public String getServedToken() {
		return servedToken;
	}

	public void newRequest() {
		servedToken = null;
	}

	public void newRequest(String alreadyServedToken) {
		servedToken = alreadyServedToken;
	}

	public void failWith(PluginResourceException exception) {
		failures.failWith(exception);
	}

	public void failWith(String methodName, PluginResourceException exception) {
		failures.failWith(methodName, exception);
	}

	public void failWith(String methodName, PluginResourceException exception, int times) {
		failures.failWith(methodName, exception, times);
	}

	public void failAfterApplyingWith(String methodName, PluginResourceException exception) {
		failuresAfterApplying.failWith(requireFailAfterApplyingMethod(methodName), exception);
	}

	public void failAfterApplyingWith(String methodName, PluginResourceException exception, int times) {
		failuresAfterApplying.failWith(requireFailAfterApplyingMethod(methodName), exception, times);
	}

	public void clearFailures() {
		failures.clear();
		failuresAfterApplying.clear();
	}

	private static String requireFailAfterApplyingMethod(String methodName) {
		if (!FAIL_AFTER_APPLYING_METHODS.contains(methodName)) {
			throw new IllegalArgumentException("Only apply and delete can fail after applying: " + methodName);
		}
		return methodName;
	}

	private void serveIfFound(String token, boolean found) {
		if (found) {
			servedToken = token;
		}
	}

	private void requireFreeSlotFor(String token) {
		if (servedToken != null && !servedToken.equals(token)) {
			throw new IllegalStateException("Another basket is already served in this request");
		}
	}

	private static void requireValidChanges(BasketChanges changes) {
		requireArgument(changes, "changes");
		if (changes.getRows() != null) {
			changes.getRows().forEach(BasketResourceFake::requireValidRow);
		}
		if (changes.getVoucherCodes() != null && changes.getVoucherCodes().stream().anyMatch(Objects::isNull)) {
			throw new IllegalArgumentException("Voucher codes must not be null");
		}
	}

	private static void requireValidRow(RowChange row) {
		if (row == null) {
			throw new IllegalArgumentException("Basket rows must not be null");
		}
		if (row.getProductId() <= 0 || row.getQuantity() <= 0) {
			throw new IllegalArgumentException("Basket rows need a positive product id and quantity");
		}
		if (row.getOptionValueIds() == null || row.getOptionValueIds().stream().anyMatch(Objects::isNull)) {
			throw new IllegalArgumentException("Basket row option value ids must not be null");
		}
	}

	private static void requireValidEntries(Map<String, String> entries) {
		entries.forEach((key, value) -> {
			requireValidKey(key);
			if (value == null) {
				throw new IllegalArgumentException("Storage values must not be null");
			}
		});
	}

	private static void requireValidKeys(Collection<String> keys) {
		keys.forEach(BasketResourceFake::requireValidKey);
	}

	private static void requireValidKey(String key) {
		if (key == null || key.isEmpty() || key.contains(".") || key.startsWith("$") || key.indexOf('\0') >= 0) {
			throw new IllegalArgumentException("Storage keys must be non-empty, without '.' or NUL and not starting with '$': " + key);
		}
	}

	private static void requireToken(String token) {
		if (token == null || token.isBlank()) {
			throw new IllegalArgumentException("The basket token must not be blank");
		}
	}

	private static void requireArgument(Object argument, String name) {
		if (argument == null) {
			throw new IllegalArgumentException(name + " must not be null");
		}
	}

}
