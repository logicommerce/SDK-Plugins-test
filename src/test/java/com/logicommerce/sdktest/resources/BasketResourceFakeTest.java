package com.logicommerce.sdktest.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.builders.basket.BasketChangesBuilder;
import com.logicommerce.sdk.builders.basket.BasketContextBuilder;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.basket.BasketChanges;
import com.logicommerce.sdk.models.basket.BasketContext;
import com.logicommerce.sdk.models.basket.BasketView;
import com.logicommerce.sdk.models.basket.implementations.BasketChangesImpl;
import com.logicommerce.sdk.models.basket.implementations.RowChangeImpl;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdktest.models.basket.BasketViewFakeBuilder;

class BasketResourceFakeTest {

	private static final String TOKEN = "token-1";
	private static final String OTHER_TOKEN = "token-2";
	private static final String UNKNOWN_TOKEN = "token-3";

	private final BasketResourceFake basketResource = new BasketResourceFake();
	private final BasketContext context = new BasketContextBuilder().countryCode("ES").build();

	@Test
	void testCreateStoresTheBasketAndItsStorage() throws PluginResourceException {
		// @formatter:off
		BasketView basket = new BasketViewFakeBuilder<>()
			.token(TOKEN)
			.row()
				.productId(7)
				.type(CartItemType.PRODUCT)
				.quantity(2)
				.total(2000)
				.done()
			.totals()
				.total(2000)
				.done()
			.build();
		// @formatter:on
		basketResource.setCreateResult(basket);
		BasketChanges changes = new BasketChangesBuilder().storage(Map.of("ucp_checkout_id", "chk_1")).build();

		BasketView created = basketResource.create(context, changes);

		assertSame(basket, created);
		assertSame(basket, basketResource.get(TOKEN, null));
		assertEquals(Map.of("ucp_checkout_id", "chk_1"), basketResource.getStorage(TOKEN));
		assertSame(changes, basketResource.getLastChanges());
		assertEquals("ES", basketResource.getLastContext().getCountryCode());
		assertEquals(2000, created.getTotals().getTotal());
		assertEquals(7, created.getRows().get(0).getProductId());
	}

	@Test
	void testCreateNeedsACreateResult() {
		assertThrows(IllegalStateException.class, () -> basketResource.create(context, new BasketChangesBuilder().build()));
	}

	@Test
	void testCreateValidatesItsStorageBeforeCreating() {
		basketResource.setCreateResult(new BasketViewFakeBuilder<>().token(TOKEN).build());
		BasketChanges changes = new BasketChangesBuilder().storage(Map.of("ucp.checkout_id", "chk_1")).build();

		assertThrows(IllegalArgumentException.class, () -> basketResource.create(context, changes));
		assertNull(basketResource.getBasket(TOKEN));
		assertNull(basketResource.getServedToken());
	}

	@Test
	void testFailedCreateKeepsNoBasket() throws PluginResourceException {
		BasketView basket = new BasketViewFakeBuilder<>().token(TOKEN).build();
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());
		basketResource.setCreateResult(basket);
		basketResource.failWith("create", new PluginResourceException("down"));

		assertThrows(PluginResourceException.class, () -> basketResource.create(context, new BasketChangesBuilder().build()));
		assertNull(basketResource.getBasket(TOKEN));
		assertNull(basketResource.getServedToken());
		assertSame(basketResource.getBasket(OTHER_TOKEN), basketResource.get(OTHER_TOKEN, null));

		basketResource.clearFailures();
		basketResource.newRequest();
		assertSame(basket, basketResource.create(context, new BasketChangesBuilder().build()));
	}

	@Test
	void testApplyReturnsTheConfiguredResult() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		BasketView applied = new BasketViewFakeBuilder<>().token(TOKEN).id(3).build();
		basketResource.setApplyResult(applied);

		assertNull(basketResource.apply(OTHER_TOKEN, new BasketChangesBuilder().build(), null));
		assertSame(applied, basketResource.apply(TOKEN, new BasketChangesBuilder().build(), null));
		assertSame(applied, basketResource.get(TOKEN, null));
	}

	@Test
	void testInvalidChangesAreRejected() {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		RowChangeImpl row = new RowChangeImpl();
		row.setProductId(7);
		row.setQuantity(0);
		row.setOptionValueIds(List.of());
		BasketChanges invalidRow = new BasketChangesBuilder().rows(List.of(row)).build();
		BasketChangesImpl nullVoucherCode = new BasketChangesImpl();
		nullVoucherCode.setVoucherCodes(Arrays.asList("CODE", null));

		assertThrows(IllegalArgumentException.class, () -> basketResource.apply(TOKEN, invalidRow, null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.apply(TOKEN, nullVoucherCode, null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.apply(TOKEN, null, null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.create(null, new BasketChangesBuilder().build()));
		assertTrue(basketResource.getChanges().isEmpty());
	}

	@Test
	void testBlankTokenIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> basketResource.get(" ", null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.get(null, null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.delete(""));
		assertThrows(IllegalArgumentException.class, () -> basketResource.putStorage(" ", Map.of("key", "value")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage("", Set.of("key")));
	}

	@Test
	void testStorageKeysFollowTheResourceRules() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());

		assertThrows(IllegalArgumentException.class, () -> basketResource.putStorage(TOKEN, Map.of("ucp.checkout_id", "chk_1")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage(TOKEN, Set.of("ucp.checkout_id")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage(TOKEN, Set.of("$key")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage(TOKEN, new HashSet<>(Arrays.asList("key", null))));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage(OTHER_TOKEN, Set.of("")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.removeStorage(TOKEN, null));
		assertFalse(basketResource.putStorage(OTHER_TOKEN, Map.of("ucp_checkout_id", "chk_1")));
		assertTrue(basketResource.putStorage(TOKEN, Map.of("ucp_checkout_id", "chk_1", "other", "value")));
		assertTrue(basketResource.removeStorage(TOKEN, Set.of("other", "missing")));
		assertEquals(Map.of("ucp_checkout_id", "chk_1"), basketResource.getStorage(TOKEN));
	}

	@Test
	void testOneBasketPerRequest() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());

		basketResource.get(TOKEN, null);
		assertThrows(IllegalStateException.class, () -> basketResource.get(OTHER_TOKEN, null));
		assertTrue(basketResource.putStorage(OTHER_TOKEN, Map.of("key", "value")));
		basketResource.newRequest();
		assertTrue(basketResource.delete(OTHER_TOKEN));
		assertNull(basketResource.get(OTHER_TOKEN, null));
		assertThrows(IllegalStateException.class, () -> basketResource.get(TOKEN, null));
	}

	@Test
	void testOneBasketPerRequestAlsoRejectsUnknownTokens() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.setCreateResult(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());

		basketResource.get(TOKEN, null);

		assertThrows(IllegalStateException.class, () -> basketResource.get(UNKNOWN_TOKEN, null));
		assertThrows(IllegalStateException.class, () -> basketResource.apply(UNKNOWN_TOKEN, new BasketChangesBuilder().build(), null));
		assertThrows(IllegalStateException.class, () -> basketResource.delete(UNKNOWN_TOKEN));
		assertThrows(IllegalStateException.class, () -> basketResource.create(context, new BasketChangesBuilder().build()));
		assertSame(basketResource.getBasket(TOKEN), basketResource.get(TOKEN, null));
	}

	@Test
	void testCreateAlwaysNeedsAFreeSlot() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.setCreateResult(new BasketViewFakeBuilder<>().token(TOKEN).build());

		basketResource.get(TOKEN, null);

		assertThrows(IllegalStateException.class, () -> basketResource.create(context, new BasketChangesBuilder().build()));
	}

	@Test
	void testAMissedLookupKeepsNoBasket() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());

		assertNull(basketResource.get(UNKNOWN_TOKEN, null));
		assertFalse(basketResource.delete(UNKNOWN_TOKEN));
		assertSame(basketResource.getBasket(TOKEN), basketResource.get(TOKEN, null));
	}

	@Test
	void testRequestThatAlreadyServesABasket() throws PluginResourceException {
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());

		basketResource.newRequest(OTHER_TOKEN);

		assertThrows(IllegalStateException.class, () -> basketResource.get(TOKEN, null));
		assertSame(basketResource.getBasket(OTHER_TOKEN), basketResource.get(OTHER_TOKEN, null));
	}

	@Test
	void testFailedCallsOfAnExistingBasketKeepIt() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());
		basketResource.failWith(failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.get(TOKEN, null)));
		assertEquals(TOKEN, basketResource.getServedToken());
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.putStorage(TOKEN, Map.of("key", "value"))));
		assertThrows(IllegalArgumentException.class, () -> basketResource.get(" ", null));
		basketResource.clearFailures();
		assertThrows(IllegalStateException.class, () -> basketResource.get(OTHER_TOKEN, null));

		basketResource.newRequest();
		basketResource.failWith("delete", failure);
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.delete(OTHER_TOKEN)));
		assertSame(basketResource.getBasket(OTHER_TOKEN), basketResource.get(OTHER_TOKEN, null));
		assertThrows(IllegalStateException.class, () -> basketResource.get(TOKEN, null));
		assertThrows(IllegalArgumentException.class, () -> basketResource.failWith("getStorage", failure));
	}

	@Test
	void testFailedApplyKeepsTheBasketAndChangesNothing() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		BasketView basket = new BasketViewFakeBuilder<>().token(TOKEN).build();
		basketResource.addBasket(basket);
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(OTHER_TOKEN).build());
		basketResource.setApplyResult(new BasketViewFakeBuilder<>().token(TOKEN).id(3).build());
		basketResource.setCreateResult(new BasketViewFakeBuilder<>().token(UNKNOWN_TOKEN).build());
		basketResource.failWith("apply", failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.apply(TOKEN, new BasketChangesBuilder().build(), null)));

		assertThrows(IllegalStateException.class, () -> basketResource.get(OTHER_TOKEN, null));
		assertThrows(IllegalStateException.class, () -> basketResource.create(context, new BasketChangesBuilder().build()));
		assertTrue(basketResource.getChanges().isEmpty());
		assertSame(basket, basketResource.getBasket(TOKEN));
	}

	@Test
	void testFailuresOnAMissingBasketKeepNoBasket() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.failWith(failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.get(UNKNOWN_TOKEN, null)));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.apply(UNKNOWN_TOKEN, new BasketChangesBuilder().build(), null)));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.delete(UNKNOWN_TOKEN)));

		assertNull(basketResource.getServedToken());
		basketResource.clearFailures();
		assertSame(basketResource.getBasket(TOKEN), basketResource.get(TOKEN, null));
	}

	@Test
	void testFailedApplyAfterApplyingKeepsTheChangesSoARetryAppliesThemAgain() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		BasketView applied = new BasketViewFakeBuilder<>().token(TOKEN).id(3).build();
		basketResource.setApplyResult(applied);
		basketResource.failAfterApplyingWith("apply", failure, 1);
		BasketChanges changes = new BasketChangesBuilder().build();

		assertNull(basketResource.apply(UNKNOWN_TOKEN, changes, null));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.apply(TOKEN, changes, null)));
		assertSame(applied, basketResource.getBasket(TOKEN));
		assertEquals(1, basketResource.getChanges().size());
		assertEquals(TOKEN, basketResource.getServedToken());

		assertSame(applied, basketResource.apply(TOKEN, changes, null));
		assertEquals(2, basketResource.getChanges().size());
	}

	@Test
	void testFailedDeleteAfterApplyingClearsTheStorageAndKeepsTheBasket() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.putStorage(TOKEN, Map.of("ucp_checkout_id", "chk_1"));
		basketResource.failAfterApplyingWith("delete", failure);

		assertFalse(basketResource.delete(UNKNOWN_TOKEN));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.delete(TOKEN)));
		assertTrue(basketResource.getStorage(TOKEN).isEmpty());
		assertSame(basketResource.getBasket(TOKEN), basketResource.get(TOKEN, null));

		basketResource.clearFailures();
		assertTrue(basketResource.delete(TOKEN));
		assertNull(basketResource.getBasket(TOKEN));
	}

	@Test
	void testOnlyApplyAndDeleteFailAfterApplying() {
		PluginResourceException failure = new PluginResourceException("down");

		assertThrows(IllegalArgumentException.class, () -> basketResource.failAfterApplyingWith("get", failure));
		assertThrows(IllegalArgumentException.class, () -> basketResource.failAfterApplyingWith("create", failure, 1));
		assertThrows(IllegalArgumentException.class, () -> basketResource.failAfterApplyingWith("apply", failure, 0));
		assertThrows(IllegalArgumentException.class, () -> basketResource.failAfterApplyingWith("delete", null));
	}

	@Test
	void testCountedFailuresThenSucceed() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		basketResource.addBasket(new BasketViewFakeBuilder<>().token(TOKEN).build());
		basketResource.failWith("putStorage", failure, 2);

		assertThrows(IllegalArgumentException.class, () -> basketResource.putStorage(TOKEN, Map.of("a.b", "value")));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.putStorage(TOKEN, Map.of("key", "value"))));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> basketResource.putStorage(TOKEN, Map.of("key", "value"))));
		assertTrue(basketResource.putStorage(TOKEN, Map.of("key", "value")));
		assertThrows(IllegalArgumentException.class, () -> basketResource.failWith("putStorage", failure, 0));
	}
}
