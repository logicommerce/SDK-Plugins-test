package com.logicommerce.sdktest.models.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.enums.StockStatus;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.ProductView;

class ProductViewFakeBuilderTest {

	@Test
	void testDefaultProductHasOneCombinationWithHiddenPrices() {
		ProductView product = new ProductViewFakeBuilder<>().build();

		assertEquals(1, product.getCombinations().size());
		assertNull(product.getPriceRange());
		assertNull(product.getCombinations().get(0).getPrice());
		assertEquals(StockStatus.NOT_ORDERABLE, product.getCombinations().get(0).getStockStatus());
	}

	@Test
	void testDefaultCombinationTakesTheLowestPrice() {
		// @formatter:off
		ProductView product = new ProductViewFakeBuilder<>()
			.priceRange()
				.min().amount(1200).currencyCode("USD").done()
				.max().amount(1500).currencyCode("USD").done()
				.done()
			.build();
		// @formatter:on

		CombinationView combination = product.getCombinations().get(0);
		assertEquals(1, product.getCombinations().size());
		assertEquals(1200, combination.getPrice().getAmount());
		assertEquals("USD", combination.getPrice().getCurrencyCode());
		assertEquals(StockStatus.IN_STOCK, combination.getStockStatus());
	}

	@Test
	void testExplicitCombinationsReplaceTheDefault() {
		ProductView product = new ProductViewFakeBuilder<>().combination().sku("A").done().combination().sku("B").done().build();

		assertEquals(2, product.getCombinations().size());
		assertEquals("A", product.getCombinations().get(0).getSku());
		assertNull(product.getPriceRange());
		assertEquals(StockStatus.NOT_ORDERABLE, product.getCombinations().get(1).getStockStatus());
	}

	@Test
	void testThePriceRangeIsDerivedFromTheCombinationPrices() {
		// @formatter:off
		ProductView product = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1500).done().done()
			.combination().sku("B").price().amount(900).done().done()
			.build();
		// @formatter:on

		assertEquals(900, product.getPriceRange().getMin().getAmount());
		assertEquals(1500, product.getPriceRange().getMax().getAmount());
		assertEquals("EUR", product.getPriceRange().getMax().getCurrencyCode());
		assertEquals(StockStatus.IN_STOCK, product.getCombinations().get(0).getStockStatus());
	}

	@Test
	void testVisiblePricesNeedAPriceInTheRangeOnEveryCombination() {
		// @formatter:off
		ProductViewFakeBuilder<Object> unpriced = new ProductViewFakeBuilder<>()
			.priceRange().min().amount(1000).done().max().amount(1000).done().done()
			.combination().sku("A").done();
		ProductViewFakeBuilder<Object> outsideTheRange = new ProductViewFakeBuilder<>()
			.priceRange().min().amount(1000).done().max().amount(1200).done().done()
			.combination().sku("A").price().amount(1300).done().done();
		ProductViewFakeBuilder<Object> otherCurrency = new ProductViewFakeBuilder<>()
			.priceRange().min().amount(1000).done().max().amount(1200).done().done()
			.combination().sku("A").price().amount(1100).currencyCode("USD").done().done();
		ProductViewFakeBuilder<Object> partlyPriced = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1100).done().done()
			.combination().sku("B").done();
		// @formatter:on

		assertThrows(IllegalStateException.class, unpriced::build);
		assertThrows(IllegalStateException.class, outsideTheRange::build);
		assertThrows(IllegalStateException.class, otherCurrency::build);
		assertThrows(IllegalStateException.class, partlyPriced::build);
	}

	@Test
	void testHiddenPricesNeedNotOrderableCombinations() {
		// @formatter:off
		ProductViewFakeBuilder<Object> orderable = new ProductViewFakeBuilder<>()
			.combination().sku("A").stockStatus(StockStatus.IN_STOCK).done();
		ProductViewFakeBuilder<Object> previousPrice = new ProductViewFakeBuilder<>()
			.combination().sku("A").previousPrice().amount(1000).done().done();
		ProductViewFakeBuilder<Object> previousRange = new ProductViewFakeBuilder<>()
			.previousPriceRange().min().amount(1000).done().max().amount(1000).done().done();
		// @formatter:on

		assertThrows(IllegalStateException.class, orderable::build);
		assertThrows(IllegalStateException.class, previousPrice::build);
		assertThrows(IllegalStateException.class, previousRange::build);
	}

	@Test
	void testThePreviousPriceRangeIsDerivedFromPreviousPricesOrPrices() {
		// @formatter:off
		ProductView product = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1500).done().done()
			.combination().sku("B").price().amount(900).done().done()
			.build();
		ProductView withoutPreviousPrices = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1000).done().done()
			.build();
		// @formatter:on

		assertEquals(900, product.getPreviousPriceRange().getMin().getAmount());
		assertEquals(1500, product.getPreviousPriceRange().getMax().getAmount());
		assertEquals("EUR", product.getPreviousPriceRange().getMin().getCurrencyCode());
		assertNull(withoutPreviousPrices.getPreviousPriceRange());
	}

	@Test
	void testAnExplicitPreviousPriceRangeMustCoverEveryPreviousPriceOrPrice() {
		// @formatter:off
		ProductView product = new ProductViewFakeBuilder<>()
			.previousPriceRange().min().amount(900).done().max().amount(2000).done().done()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1500).done().done()
			.combination().sku("B").price().amount(900).done().done()
			.build();
		ProductViewFakeBuilder<Object> tooNarrow = new ProductViewFakeBuilder<>()
			.previousPriceRange().min().amount(1000).done().max().amount(1500).done().done()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1500).done().done()
			.combination().sku("B").price().amount(900).done().done();
		ProductViewFakeBuilder<Object> otherCurrency = new ProductViewFakeBuilder<>()
			.previousPriceRange().min().amount(1500).currencyCode("USD").done().max().amount(1500).currencyCode("USD").done().done()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1500).done().done();
		ProductViewFakeBuilder<Object> withoutPreviousPrices = new ProductViewFakeBuilder<>()
			.previousPriceRange().min().amount(1000).done().max().amount(1000).done().done()
			.combination().sku("A").price().amount(1000).done().done();
		// @formatter:on

		assertEquals(2000, product.getPreviousPriceRange().getMax().getAmount());
		assertThrows(IllegalStateException.class, tooNarrow::build);
		assertThrows(IllegalStateException.class, otherCurrency::build);
		assertThrows(IllegalStateException.class, withoutPreviousPrices::build);
	}

	@Test
	void testAPreviousPriceMustBeHigherThanThePriceInItsCurrency() {
		// @formatter:off
		ProductViewFakeBuilder<Object> equal = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1000).done().done();
		ProductViewFakeBuilder<Object> lower = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(900).done().done();
		ProductViewFakeBuilder<Object> otherCurrency = new ProductViewFakeBuilder<>()
			.combination().sku("A").price().amount(1000).done().previousPrice().amount(1500).currencyCode("USD").done().done();
		// @formatter:on

		IllegalStateException failure = assertThrows(IllegalStateException.class, equal::build);
		assertTrue(failure.getMessage().contains("previous price of combination A"));
		assertThrows(IllegalStateException.class, lower::build);
		assertThrows(IllegalStateException.class, otherCurrency::build);
	}
}
