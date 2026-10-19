package com.logicommerce.sdktest.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.catalog.CatalogContext;
import com.logicommerce.sdk.models.catalog.CatalogQuery;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.ProductPage;
import com.logicommerce.sdk.models.catalog.ProductView;
import com.logicommerce.sdk.resources.CatalogResource;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdktest.models.catalog.ProductPageFake;
import com.logicommerce.sdktest.models.catalog.ProductViewFake;

/**
 * <p>In-memory {@link CatalogResource} for plugin tests over the products given to {@link #addProduct(ProductView)},
 * which are all visible to every context. Every call returns new {@link ProductView} instances.</p>
 *
 * <ul>
 * <li>{@link #search(CatalogQuery, CatalogContext) search} keeps the products in the order they were added. Category
 * name paths match as in production: case-insensitively, a single name matches every category with that name, and a
 * category includes its subcategories. Each product carries its first combination (the featured one) and at most
 * {@value #MAX_SEARCH_COMBINATIONS} combinations, as in production. A page or page size out of range throws an
 * {@link IllegalArgumentException}.</li>
 * <li>{@link #getProducts(List, List, CatalogContext) getProducts} returns the requested ids first, in the requested
 * order, then the products matched by code.</li>
 * <li>{@link #getProduct(int, List, CatalogContext) getProduct} puts the combination the option value ids identify first
 * and returns null for a product without combinations.</li>
 * </ul>
 *
 * <p><b>Text search is an approximation.</b> The fake matches a product whose name contains the trimmed text as a
 * substring, ignoring case, or one of whose combinations has the text as its exact SKU or barcode. Production runs the
 * text through the store's search engine, which tokenizes it and searches other fields (keywords, brand,
 * descriptions): it may match products the fake does not and miss products the fake matches (for example a fragment
 * inside a word, such as {@code "irt"} for {@code "Shirt"}). Tests must not rely on a match beyond a whole word of the
 * name or an exact SKU or barcode.</p>
 *
 * <p><b>Price filter.</b> When the query has a {@code fromPrice} or a {@code toPrice}, production converts them from
 * {@link CatalogQuery#getPriceCurrencyCode()} to the main currency before it searches; a null, blank, unknown or
 * unconvertible currency makes it ignore the filter and report {@link ProductPage#isPriceFilterIgnored()} true,
 * whatever the results. The fake decides the same way, before it looks at any product: the known currencies are those
 * given to {@link #setCurrencies(String...)}; until it is called, they are the currencies of the added products' price
 * ranges, and a currency outside them throws an {@link UnsupportedOperationException}, because the fake cannot know
 * whether the store would convert it. A known currency applies the filter: as in production, a {@code fromPrice <= 0}
 * sets no lower bound and a {@code toPrice <= 0} keeps only free products. Production filters on the stored price of the product converted to
 * the main currency, not on what a {@link ProductView} shows; the fake compares the lowest price of
 * {@link ProductView#getPriceRange()} instead, which depends on the combinations and the tax mode, so set the price
 * range to the price production stores. The fake cannot convert currencies or see a hidden price, so a product whose
 * price range is in another currency, or whose prices are hidden, throws an {@link UnsupportedOperationException} when
 * the filter has to evaluate it.</p>
 *
 * <p>{@link #failWith(PluginResourceException)} makes every call throw the given {@link PluginResourceException},
 * {@link #failWith(String, PluginResourceException)} every call of one method, and
 * {@link #failWith(String, PluginResourceException, int)} only the next calls of that method, which then succeed
 * again; counted failures are thrown first, and the same exception instance every time. Failures are thrown after the
 * arguments are validated, to test infrastructure failures; {@link #clearFailures()} undoes them.</p>
 */
public class CatalogResourceFake implements CatalogResource {

	public static final int MAX_SEARCH_COMBINATIONS = 10;

	private static final String CATEGORY_SEPARATOR = ">";

	private final List<ProductView> products = new ArrayList<>();

	private final List<CatalogQuery> queries = new ArrayList<>();

	private final ResourceFailures failures = new ResourceFailures(CatalogResource.class);

	private Set<String> currencies;

	private CatalogContext lastContext;

	private List<Integer> lastOptionValueIds;

	@Override
	public ProductPage search(CatalogQuery query, CatalogContext context) throws PluginResourceException {
		requireArgument(query, "query");
		requireArgument(context, "context");
		if (query.getPage() < 1 || query.getPerPage() < 1 || query.getPerPage() > CatalogQuery.MAX_PER_PAGE) {
			throw new IllegalArgumentException("The catalog query page must be at least 1 and its size from 1 to " + CatalogQuery.MAX_PER_PAGE);
		}
		failures.check("search");
		queries.add(query);
		lastContext = context;
		PriceFilter priceFilter = new PriceFilter(query, knownCurrencies(), currencies != null);
		List<List<String>> categoryPaths = query.getCategoryNamePaths() == null ? List.of()
			: query.getCategoryNamePaths().stream().map(CatalogResourceFake::segments).collect(Collectors.toList());
		List<ProductView> found = products.stream()
			.filter(product -> matchesText(product, query.getText()))
			.filter(product -> query.getCategoryNamePaths() == null || query.getCategoryNamePaths().isEmpty()
				|| matchesCategory(product, categoryPaths))
			.filter(priceFilter::matches)
			.collect(Collectors.toList());
		long from = (long) (query.getPage() - 1) * query.getPerPage();
		ProductPageFake page = new ProductPageFake();
		page.setProducts(found.stream()
			.skip(from)
			.limit(query.getPerPage())
			.filter(CatalogResourceFake::hasCombinations)
			.map(product -> copy(product, cap(product.getCombinations())))
			.collect(Collectors.toList()));
		page.setNextPage(found.size() > (long) query.getPage() * query.getPerPage());
		page.setPriceFilterIgnored(priceFilter.ignored);
		return page;
	}

	@Override
	public List<ProductView> getProducts(List<Integer> productIds, List<String> codes, CatalogContext context) throws PluginResourceException {
		requireArgument(context, "context");
		failures.check("getProducts");
		lastContext = context;
		Set<Integer> requestedIds = nonNull(productIds).stream().filter(id -> id > 0).collect(Collectors.toCollection(LinkedHashSet::new));
		List<String> requestedCodes = nonNull(codes).stream().filter(code -> !code.isBlank()).collect(Collectors.toList());
		List<ProductView> found = new ArrayList<>();
		for (Integer id : requestedIds) {
			products.stream().filter(product -> product.getId() == id).findFirst().ifPresent(found::add);
		}
		products.stream()
			.filter(product -> !found.contains(product) && matchesCode(product, requestedCodes))
			.forEach(found::add);
		return found.stream()
			.filter(CatalogResourceFake::hasCombinations)
			.map(product -> copy(product, product.getCombinations()))
			.collect(Collectors.toList());
	}

	@Override
	public ProductView getProduct(int productId, List<Integer> optionValueIds, CatalogContext context) throws PluginResourceException {
		requireArgument(context, "context");
		failures.check("getProduct");
		lastContext = context;
		lastOptionValueIds = optionValueIds;
		if (productId <= 0) {
			return null;
		}
		ProductView product = products.stream().filter(candidate -> candidate.getId() == productId).findFirst().orElse(null);
		if (product == null || !hasCombinations(product)) {
			return null;
		}
		return copy(product, selectedFirst(product.getCombinations(), nonNull(optionValueIds)));
	}

	public void addProduct(ProductView product) {
		products.add(product);
	}

	public void setCurrencies(String... currencyCodes) {
		currencies = Arrays.stream(currencyCodes).map(CatalogResourceFake::normalizeCurrency).filter(Objects::nonNull)
			.collect(Collectors.toCollection(HashSet::new));
	}

	public List<CatalogQuery> getQueries() {
		return queries;
	}

	public CatalogContext getLastContext() {
		return lastContext;
	}

	public List<Integer> getLastOptionValueIds() {
		return lastOptionValueIds;
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

	public void clearFailures() {
		failures.clear();
	}

	private Set<String> knownCurrencies() {
		if (currencies != null) {
			return currencies;
		}
		return products.stream()
			.map(ProductView::getPriceRange)
			.filter(Objects::nonNull)
			.map(range -> normalizeCurrency(range.getMin().getCurrencyCode()))
			.filter(Objects::nonNull)
			.collect(Collectors.toSet());
	}

	private static String normalizeCurrency(String currency) {
		return currency == null || currency.isBlank() ? null : currency.trim().toUpperCase(Locale.ROOT);
	}

	private static List<CombinationView> selectedFirst(List<CombinationView> combinations, List<Integer> optionValueIds) {
		if (optionValueIds.isEmpty()) {
			return combinations;
		}
		Set<Integer> selected = new HashSet<>(optionValueIds);
		CombinationView first = combinations.stream()
			.filter(combination -> new HashSet<>(combination.getOptionValueIds()).equals(selected))
			.findFirst()
			.orElse(combinations.get(0));
		List<CombinationView> ordered = new ArrayList<>();
		ordered.add(first);
		combinations.stream().filter(combination -> combination != first).forEach(ordered::add);
		return ordered;
	}

	private static List<CombinationView> cap(List<CombinationView> combinations) {
		return combinations.stream().limit(MAX_SEARCH_COMBINATIONS).collect(Collectors.toList());
	}

	private static ProductView copy(ProductView product, List<CombinationView> combinations) {
		ProductViewFake copy = new ProductViewFake();
		copy.setId(product.getId());
		copy.setName(product.getName());
		copy.setShortDescription(product.getShortDescription());
		copy.setLongDescription(product.getLongDescription());
		copy.setUrlSeo(product.getUrlSeo());
		copy.setUrl(product.getUrl());
		copy.setImages(product.getImages() == null ? null : new ArrayList<>(product.getImages()));
		copy.setCategoryNamePaths(product.getCategoryNamePaths() == null ? null : new ArrayList<>(product.getCategoryNamePaths()));
		copy.setOptions(product.getOptions() == null ? null : new ArrayList<>(product.getOptions()));
		copy.setCombinations(new ArrayList<>(combinations));
		copy.setPriceRange(product.getPriceRange());
		copy.setPreviousPriceRange(product.getPreviousPriceRange());
		copy.setTaxesIncluded(product.isTaxesIncluded());
		copy.setRequiresNonCombinableOption(product.requiresNonCombinableOption());
		return copy;
	}

	private static boolean hasCombinations(ProductView product) {
		return product.getCombinations() != null && !product.getCombinations().isEmpty();
	}

	private static boolean matchesText(ProductView product, String text) {
		if (text == null || text.isBlank()) {
			return true;
		}
		String trimmed = text.trim();
		return (product.getName() != null && product.getName().toLowerCase(Locale.ROOT).contains(trimmed.toLowerCase(Locale.ROOT)))
			|| matchesCode(product, List.of(trimmed));
	}

	private static boolean matchesCategory(ProductView product, List<List<String>> requestedPaths) {
		if (product.getCategoryNamePaths() == null) {
			return false;
		}
		return product.getCategoryNamePaths().stream()
			.map(CatalogResourceFake::segments)
			.anyMatch(productPath -> requestedPaths.stream().anyMatch(requested -> isInCategory(productPath, requested)));
	}

	private static boolean isInCategory(List<String> productPath, List<String> requestedPath) {
		if (requestedPath.isEmpty() || productPath.isEmpty()) {
			return false;
		}
		if (requestedPath.size() == 1) {
			return productPath.contains(requestedPath.get(0));
		}
		return productPath.size() >= requestedPath.size() && productPath.subList(0, requestedPath.size()).equals(requestedPath);
	}

	private static List<String> segments(String path) {
		if (path == null) {
			return List.of();
		}
		List<String> segments = Arrays.stream(path.split(CATEGORY_SEPARATOR, -1))
			.map(segment -> segment.trim().toLowerCase(Locale.ROOT))
			.collect(Collectors.toList());
		return segments.stream().anyMatch(String::isEmpty) ? List.of() : segments;
	}

	private static boolean matchesCode(ProductView product, List<String> codes) {
		if (codes.isEmpty() || product.getCombinations() == null) {
			return false;
		}
		return product.getCombinations().stream().anyMatch(combination -> codes.contains(combination.getSku())
			|| (combination.getBarcodes() != null && combination.getBarcodes().values().stream().anyMatch(codes::contains)));
	}

	private static <T> List<T> nonNull(List<T> values) {
		return values == null ? List.of() : values.stream().filter(Objects::nonNull).collect(Collectors.toList());
	}

	private static void requireArgument(Object argument, String name) {
		if (argument == null) {
			throw new IllegalArgumentException("The " + name + " must not be null");
		}
	}

	private static final class PriceFilter {

		private final boolean requested;

		private final boolean ignored;

		private final String currencyCode;

		private final Long fromPrice;

		private final Long toPrice;

		private PriceFilter(CatalogQuery query, Set<String> knownCurrencies, boolean currenciesSet) {
			this.requested = query.getFromPrice() != null || query.getToPrice() != null;
			this.currencyCode = normalizeCurrency(query.getPriceCurrencyCode());
			if (requested && currencyCode != null && !currenciesSet && !knownCurrencies.contains(currencyCode)) {
				throw new UnsupportedOperationException("CatalogResourceFake does not know whether the store converts the price filter currency "
					+ currencyCode + "; call setCurrencies with the store's currencies");
			}
			this.ignored = requested && (currencyCode == null || !knownCurrencies.contains(currencyCode));
			this.fromPrice = query.getFromPrice();
			this.toPrice = query.getToPrice();
		}

		private boolean matches(ProductView product) {
			if (!requested || ignored) {
				return true;
			}
			if (product.getPriceRange() == null) {
				throw new UnsupportedOperationException("CatalogResourceFake cannot apply a price filter to product " + product.getId()
					+ ", whose prices are hidden");
			}
			if (!currencyCode.equals(normalizeCurrency(product.getPriceRange().getMin().getCurrencyCode()))) {
				throw new UnsupportedOperationException("CatalogResourceFake cannot convert the price filter currency " + currencyCode
					+ " to " + product.getPriceRange().getMin().getCurrencyCode() + " (product " + product.getId() + ")");
			}
			long price = product.getPriceRange().getMin().getAmount();
			boolean aboveLowerBound = fromPrice == null || fromPrice <= 0 || price >= fromPrice;
			boolean belowUpperBound = toPrice == null || (toPrice > 0 ? price <= toPrice : price <= 0);
			return aboveLowerBound && belowUpperBound;
		}
	}

}
