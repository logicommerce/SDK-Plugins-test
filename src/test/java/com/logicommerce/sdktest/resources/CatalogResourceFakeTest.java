package com.logicommerce.sdktest.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.builders.catalog.CatalogContextBuilder;
import com.logicommerce.sdk.builders.catalog.CatalogQueryBuilder;
import com.logicommerce.sdk.enums.StockStatus;
import com.logicommerce.sdk.models.catalog.CatalogContext;
import com.logicommerce.sdk.models.catalog.CatalogQuery;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.ProductPage;
import com.logicommerce.sdk.models.catalog.ProductView;
import com.logicommerce.sdk.models.catalog.implementations.CatalogQueryImpl;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdktest.models.catalog.ProductViewFake;
import com.logicommerce.sdktest.models.catalog.ProductViewFakeBuilder;

class CatalogResourceFakeTest {

	private final CatalogResourceFake catalogResource = new CatalogResourceFake();
	private final CatalogContext context = new CatalogContextBuilder().countryCode("ES").languageCode("es").build();

	@Test
	void testSearchFiltersByTextAndPages() throws PluginResourceException {
		catalogResource.addProduct(product(1, "Red shirt", "SKU-1"));
		catalogResource.addProduct(product(2, "Blue shirt", "SKU-2"));
		catalogResource.addProduct(product(3, "Shoes", "SKU-3"));

		ProductPage first = catalogResource.search(new CatalogQueryBuilder().search("shirt").perPage(1).build(), context);
		ProductPage second = catalogResource.search(new CatalogQueryBuilder().search("shirt").page(2).perPage(1).build(), context);
		ProductPage byBarcode = catalogResource.search(new CatalogQueryBuilder().search("EAN-SKU-3").build(), context);

		assertEquals(List.of(1), ids(first.getProducts()));
		assertTrue(first.hasNextPage());
		assertFalse(first.isPriceFilterIgnored());
		assertEquals(List.of(2), ids(second.getProducts()));
		assertFalse(second.hasNextPage());
		assertEquals(List.of(3), ids(byBarcode.getProducts()));
	}

	@Test
	void testSearchFiltersByCategoryNamePaths() throws PluginResourceException {
		catalogResource.addProduct(product(1, "Red shirt", "SKU-1", "Apparel > Shirts"));
		catalogResource.addProduct(product(2, "Boots", "SKU-2", "Apparel > Shoes > Boots"));
		catalogResource.addProduct(product(3, "Lamp", "SKU-3", "Home"));

		assertEquals(List.of(1), searchCategories("shirts"));
		assertEquals(List.of(1, 2), searchCategories("Apparel"));
		assertEquals(List.of(2), searchCategories("SHOES"));
		assertEquals(List.of(1), searchCategories(" apparel>shirts "));
		assertEquals(List.of(2, 3), searchCategories("Apparel > Shoes", "home"));
		assertEquals(List.of(), searchCategories("Shirts > Apparel"));
		assertEquals(List.of(), searchCategories("Apparel > "));
	}

	@Test
	void testSearchFiltersByPriceInTheProductsCurrency() throws PluginResourceException {
		catalogResource.addProduct(pricedProduct(1, 0));
		catalogResource.addProduct(pricedProduct(2, 1000));
		catalogResource.addProduct(pricedProduct(3, 2500));

		assertEquals(List.of(2, 3), searchPrices(1000L, null, "eur"));
		assertEquals(List.of(1, 2), searchPrices(0L, 1000L, "EUR"));
		assertEquals(List.of(1), searchPrices(null, 0L, "EUR"));
		ProductPage ignored = catalogResource.search(new CatalogQueryBuilder().fromPrice(1000L).build(), context);
		assertTrue(ignored.isPriceFilterIgnored());
		assertEquals(List.of(1, 2, 3), ids(ignored.getProducts()));
	}

	@Test
	void testPriceFilterTheFakeCannotApplyFailsLoudly() {
		catalogResource.addProduct(pricedProduct(1, 1000));
		CatalogQuery otherCurrency = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("USD").build();

		assertThrows(UnsupportedOperationException.class, () -> catalogResource.search(otherCurrency, context));

		catalogResource.addProduct(new ProductViewFakeBuilder<>().id(2).build());
		CatalogQuery sameCurrency = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("EUR").build();
		assertThrows(UnsupportedOperationException.class, () -> catalogResource.search(sameCurrency, context));
	}

	@Test
	void testUnknownCurrencyIgnoresThePriceFilterWhateverTheResults() throws PluginResourceException {
		catalogResource.setCurrencies("eur", " USD ");
		CatalogQuery unknown = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("GBP").build();
		CatalogQuery known = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("EUR").build();

		assertTrue(catalogResource.search(unknown, context).isPriceFilterIgnored());
		assertFalse(catalogResource.search(known, context).isPriceFilterIgnored());

		catalogResource.addProduct(pricedProduct(1, 100));
		ProductPage ignored = catalogResource.search(unknown, context);
		assertTrue(ignored.isPriceFilterIgnored());
		assertEquals(List.of(1), ids(ignored.getProducts()));
		assertEquals(List.of(), searchPrices(500L, null, "EUR"));
		CatalogQuery otherKnownCurrency = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("USD").build();
		assertThrows(UnsupportedOperationException.class, () -> catalogResource.search(otherKnownCurrency, context));
	}

	@Test
	void testCurrencyTheFakeCannotClassifyFailsLoudlyEvenWithoutCandidates() {
		CatalogQuery query = new CatalogQueryBuilder().fromPrice(500L).priceCurrencyCode("EUR").build();

		assertThrows(UnsupportedOperationException.class, () -> catalogResource.search(query, context));
	}

	@Test
	void testCountedFailuresThenSucceed() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		catalogResource.addProduct(product(1, "Red shirt", "SKU-1"));
		catalogResource.failWith("getProduct", failure, 1);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> catalogResource.getProduct(1, null, context)));
		assertEquals(1, catalogResource.getProduct(1, null, context).getId());
	}

	@Test
	void testSearchCapsTheCombinations() throws PluginResourceException {
		ProductViewFakeBuilder<Object> builder = new ProductViewFakeBuilder<>().id(1);
		for (int i = 0; i < 12; i++) {
			builder.combination().sku("SKU-" + i);
		}
		catalogResource.addProduct(builder.build());

		ProductView found = catalogResource.search(new CatalogQueryBuilder().build(), context).getProducts().get(0);

		assertEquals(CatalogResourceFake.MAX_SEARCH_COMBINATIONS, found.getCombinations().size());
		assertEquals("SKU-0", found.getCombinations().get(0).getSku());
		assertEquals(12, catalogResource.getProduct(1, null, context).getCombinations().size());
	}

	@Test
	void testSearchRejectsAnOutOfRangePage() {
		CatalogQueryImpl pageZero = new CatalogQueryImpl();
		pageZero.setPage(0);
		CatalogQueryImpl pageTooLarge = new CatalogQueryImpl();
		pageTooLarge.setPerPage(CatalogQuery.MAX_PER_PAGE + 1);

		assertThrows(IllegalArgumentException.class, () -> catalogResource.search(pageZero, context));
		assertThrows(IllegalArgumentException.class, () -> catalogResource.search(pageTooLarge, context));
		assertThrows(IllegalArgumentException.class, () -> catalogResource.search(null, context));
		assertThrows(IllegalArgumentException.class, () -> catalogResource.search(new CatalogQueryImpl(), null));
	}

	@Test
	void testGetProductsByIdSkuAndBarcode() throws PluginResourceException {
		catalogResource.addProduct(product(1, "Red shirt", "SKU-1"));
		catalogResource.addProduct(product(2, "Blue shirt", "SKU-2"));
		catalogResource.addProduct(product(3, "Shoes", "SKU-3"));

		List<ProductView> products = catalogResource.getProducts(List.of(3, 1), List.of("SKU-2", "EAN-SKU-3", "SKU-1"), context);

		assertEquals(List.of(3, 1, 2), ids(products));
		assertEquals(List.of(), catalogResource.getProducts(null, null, context));
		assertEquals(2, catalogResource.getProduct(2, List.of(10), context).getId());
		assertNull(catalogResource.getProduct(4, null, context));
		assertNull(catalogResource.getProduct(0, null, context));
	}

	@Test
	void testGetProductPutsTheSelectedCombinationFirst() throws PluginResourceException {
		// @formatter:off
		catalogResource.addProduct(new ProductViewFakeBuilder<>()
			.id(1)
			.combination().sku("RED-S").optionValueIds(List.of(1, 3)).done()
			.combination().sku("BLUE-S").optionValueIds(List.of(2, 3)).done()
			.combination().sku("BLUE-M").optionValueIds(List.of(2, 4)).done()
			.build());
		// @formatter:on

		assertEquals(List.of("BLUE-S", "RED-S", "BLUE-M"), skus(catalogResource.getProduct(1, List.of(3, 2), context)));
		assertEquals(List.of("RED-S", "BLUE-S", "BLUE-M"), skus(catalogResource.getProduct(1, List.of(2), context)));
		assertEquals(List.of("RED-S", "BLUE-S", "BLUE-M"), skus(catalogResource.getProduct(1, null, context)));
		assertNull(catalogResource.getLastOptionValueIds());
	}

	@Test
	void testProductsWithoutCombinationsAreNotReturned() throws PluginResourceException {
		ProductViewFake product = (ProductViewFake) product(1, "Red shirt", "SKU-1");
		product.setCombinations(List.of());
		catalogResource.addProduct(product);

		assertNull(catalogResource.getProduct(1, null, context));
		assertEquals(List.of(), catalogResource.getProducts(List.of(1), null, context));
		assertEquals(List.of(), ids(catalogResource.search(new CatalogQueryBuilder().build(), context).getProducts()));
	}

	@Test
	void testEveryCallReturnsNewProducts() throws PluginResourceException {
		ProductView product = product(1, "Red shirt", "SKU-1");
		catalogResource.addProduct(product);

		ProductView first = catalogResource.getProduct(1, null, context);

		assertNotSame(product, first);
		assertNotSame(first, catalogResource.getProduct(1, null, context));
		assertEquals("Red shirt", first.getName());
		assertSame(product.getCombinations().get(0), first.getCombinations().get(0));
	}

	@Test
	void testFailures() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		catalogResource.addProduct(product(1, "Red shirt", "SKU-1"));
		catalogResource.failWith("search", failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> catalogResource.search(new CatalogQueryBuilder().build(), context)));
		assertEquals(1, catalogResource.getProduct(1, null, context).getId());
		catalogResource.failWith(failure);
		assertSame(failure, assertThrows(PluginResourceException.class, () -> catalogResource.getProduct(1, null, context)));
		assertThrows(IllegalArgumentException.class, () -> catalogResource.getProduct(1, null, null));
		catalogResource.clearFailures();
		assertEquals(List.of(1), ids(catalogResource.getProducts(List.of(1), null, context)));
	}

	private List<Integer> searchCategories(String... paths) throws PluginResourceException {
		return ids(catalogResource.search(new CatalogQueryBuilder().categoryNamePaths(List.of(paths)).build(), context).getProducts());
	}

	private List<Integer> searchPrices(Long fromPrice, Long toPrice, String currencyCode) throws PluginResourceException {
		CatalogQuery query = new CatalogQueryBuilder().fromPrice(fromPrice).toPrice(toPrice).priceCurrencyCode(currencyCode).build();
		ProductPage page = catalogResource.search(query, context);
		assertFalse(page.isPriceFilterIgnored());
		return ids(page.getProducts());
	}

	private static ProductView product(int id, String name, String sku, String... categoryNamePaths) {
		// @formatter:off
		return new ProductViewFakeBuilder<>()
			.id(id)
			.name(name)
			.categoryNamePaths(List.of(categoryNamePaths))
			.combination()
				.sku(sku)
				.barcodes(Map.of("ean", "EAN-" + sku))
				.stockStatus(StockStatus.IN_STOCK)
				.price()
					.amount(1000)
					.done()
				.done()
			.priceRange()
				.min().amount(1000).done()
				.max().amount(1000).done()
				.done()
			.build();
		// @formatter:on
	}

	private static ProductView pricedProduct(int id, long price) {
		// @formatter:off
		return new ProductViewFakeBuilder<>()
			.id(id)
			.priceRange()
				.min().amount(price).done()
				.max().amount(price + 500).done()
				.done()
			.build();
		// @formatter:on
	}

	private static List<Integer> ids(List<ProductView> products) {
		return products.stream().map(ProductView::getId).collect(Collectors.toList());
	}

	private static List<String> skus(ProductView product) {
		return product.getCombinations().stream().map(CombinationView::getSku).collect(Collectors.toList());
	}
}
