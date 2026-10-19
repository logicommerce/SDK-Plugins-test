package com.logicommerce.sdktest.models.catalog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.StockStatus;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.PriceRange;
import com.logicommerce.sdk.models.catalog.PriceView;
import com.logicommerce.sdk.models.catalog.ProductView;

/**
 * <p>Builds {@link ProductView} fakes that keep the price contract of {@link ProductView}.</p>
 *
 * <ul>
 * <li>The prices are visible when a {@link #priceRange() price range} is set or a combination has a price. Then every
 * combination needs a price in the currency of the range and between its minimum and maximum. Without an explicit
 * price range, it is derived from the combination prices. A combination without an explicit stock status is
 * {@link StockStatus#IN_STOCK}. A combination's previous price must be in the currency of its price and higher than
 * it, as production returns none otherwise. The previous price range exists only when a combination has a previous
 * price; without an explicit one it is then derived, as in production, from each combination's previous price or,
 * when it has none, its price, and an explicit one needs one currency, a minimum not above its maximum, and every such
 * price between them.</li>
 * <li>Otherwise the prices are hidden: no combination may have a previous price, there is no previous price range,
 * and every combination is {@link StockStatus#NOT_ORDERABLE}, which is also the default of a combination without an
 * explicit stock status.</li>
 * <li>Without any {@link #combination() combination}, one default combination is added: with the lowest price of the
 * range and {@link StockStatus#IN_STOCK}, or {@link StockStatus#NOT_ORDERABLE} without prices.</li>
 * </ul>
 *
 * <p>{@link #build()} throws an {@link IllegalStateException} for a product that would break the contract.</p>
 *
 * @param <T> the parent builder
 */
public class ProductViewFakeBuilder<T> {

	private T parentBuilder;
	private int id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private String urlSeo;
	private String url;
	private List<String> images;
	private List<String> categoryNamePaths;
	private List<OptionViewFakeBuilder<ProductViewFakeBuilder<T>>> options;
	private List<CombinationViewFakeBuilder<ProductViewFakeBuilder<T>>> combinations;
	private PriceRangeFakeBuilder<ProductViewFakeBuilder<T>> priceRange;
	private PriceRangeFakeBuilder<ProductViewFakeBuilder<T>> previousPriceRange;
	private boolean taxesIncluded;
	private boolean requiresNonCombinableOption;

	public ProductViewFakeBuilder() {
		id = 0;
		name = "name DEFAULT";
		shortDescription = null;
		longDescription = null;
		urlSeo = null;
		url = null;
		images = new ArrayList<>();
		categoryNamePaths = new ArrayList<>();
		options = new ArrayList<>();
		combinations = new ArrayList<>();
		taxesIncluded = true;
		requiresNonCombinableOption = false;
	}

	public ProductViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public ProductViewFakeBuilder<T> id(int id) {
		this.id = id;
		return this;
	}

	public ProductViewFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public ProductViewFakeBuilder<T> shortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public ProductViewFakeBuilder<T> longDescription(String longDescription) {
		this.longDescription = longDescription;
		return this;
	}

	public ProductViewFakeBuilder<T> urlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
		return this;
	}

	public ProductViewFakeBuilder<T> url(String url) {
		this.url = url;
		return this;
	}

	public ProductViewFakeBuilder<T> images(List<String> images) {
		this.images = images;
		return this;
	}

	public ProductViewFakeBuilder<T> categoryNamePaths(List<String> categoryNamePaths) {
		this.categoryNamePaths = categoryNamePaths;
		return this;
	}

	public OptionViewFakeBuilder<ProductViewFakeBuilder<T>> option() {
		OptionViewFakeBuilder<ProductViewFakeBuilder<T>> option = new OptionViewFakeBuilder<>(this);
		options.add(option);
		return option;
	}

	public CombinationViewFakeBuilder<ProductViewFakeBuilder<T>> combination() {
		CombinationViewFakeBuilder<ProductViewFakeBuilder<T>> combination = new CombinationViewFakeBuilder<>(this);
		combinations.add(combination);
		return combination;
	}

	public PriceRangeFakeBuilder<ProductViewFakeBuilder<T>> priceRange() {
		if (priceRange == null) {
			priceRange = new PriceRangeFakeBuilder<>(this);
		}
		return priceRange;
	}

	public PriceRangeFakeBuilder<ProductViewFakeBuilder<T>> previousPriceRange() {
		if (previousPriceRange == null) {
			previousPriceRange = new PriceRangeFakeBuilder<>(this);
		}
		return previousPriceRange;
	}

	public ProductViewFakeBuilder<T> taxesIncluded(boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
		return this;
	}

	public ProductViewFakeBuilder<T> requiresNonCombinableOption(boolean requiresNonCombinableOption) {
		this.requiresNonCombinableOption = requiresNonCombinableOption;
		return this;
	}

	public ProductView build() {
		ProductViewFake productView = new ProductViewFake();
		productView.setId(id);
		productView.setName(name);
		productView.setShortDescription(shortDescription);
		productView.setLongDescription(longDescription);
		productView.setUrlSeo(urlSeo);
		productView.setUrl(url);
		productView.setImages(images);
		productView.setCategoryNamePaths(categoryNamePaths);
		productView.setOptions(options.stream().map(OptionViewFakeBuilder::build).collect(Collectors.toList()));
		boolean pricesVisible = priceRange != null || combinations.stream().anyMatch(CombinationViewFakeBuilder::hasPrice);
		StockStatus defaultStockStatus = pricesVisible ? StockStatus.IN_STOCK : StockStatus.NOT_ORDERABLE;
		List<CombinationView> builtCombinations = combinations.stream().map(combination -> combination.build(defaultStockStatus))
			.collect(Collectors.toCollection(ArrayList::new));
		PriceRange builtPriceRange = priceRange == null ? null : priceRange.build();
		if (builtCombinations.isEmpty()) {
			builtCombinations.add(defaultCombination(builtPriceRange));
		}
		if (pricesVisible) {
			requirePricedCombinations(builtCombinations);
			if (builtPriceRange == null) {
				builtPriceRange = rangeOf(builtCombinations, CombinationView::getPrice);
			}
			requireConsistentRange("price range", builtPriceRange, builtCombinations, CombinationView::getPrice);
		}
		PriceRange builtPreviousPriceRange = previousPriceRange == null ? null : previousPriceRange.build();
		if (pricesVisible) {
			requireHigherPreviousPrices(builtCombinations);
			builtPreviousPriceRange = previousRangeOf(builtPreviousPriceRange, builtCombinations);
		} else {
			requireHiddenPrices(builtPreviousPriceRange, builtCombinations);
		}
		productView.setCombinations(builtCombinations);
		productView.setPriceRange(builtPriceRange);
		productView.setPreviousPriceRange(builtPreviousPriceRange);
		productView.setTaxesIncluded(taxesIncluded);
		productView.setRequiresNonCombinableOption(requiresNonCombinableOption);
		return productView;
	}

	public T done() {
		return parentBuilder;
	}

	private static CombinationView defaultCombination(PriceRange priceRange) {
		CombinationViewFakeBuilder<Object> combination = new CombinationViewFakeBuilder<>();
		if (priceRange == null) {
			combination.stockStatus(StockStatus.NOT_ORDERABLE);
		} else {
			combination.price().amount(priceRange.getMin().getAmount()).currencyCode(priceRange.getMin().getCurrencyCode());
		}
		return combination.build();
	}

	private static void requirePricedCombinations(List<CombinationView> combinations) {
		for (CombinationView combination : combinations) {
			if (combination.getPrice() == null) {
				throw contractViolation("combination " + combination.getSku() + " has no price, but the product's prices are visible");
			}
		}
	}

	private static void requireHigherPreviousPrices(List<CombinationView> combinations) {
		for (CombinationView combination : combinations) {
			PriceView previousPrice = combination.getPreviousPrice();
			PriceView price = combination.getPrice();
			if (previousPrice != null && (!Objects.equals(previousPrice.getCurrencyCode(), price.getCurrencyCode())
				|| previousPrice.getAmount() <= price.getAmount())) {
				throw contractViolation("the previous price of combination " + combination.getSku()
					+ " must be in the currency of its price and higher than it, or production returns none");
			}
		}
	}

	private static PriceRange previousRangeOf(PriceRange previousPriceRange, List<CombinationView> combinations) {
		if (combinations.stream().allMatch(combination -> combination.getPreviousPrice() == null)) {
			if (previousPriceRange != null) {
				throw contractViolation("a previous price range needs a combination with a previous price");
			}
			return null;
		}
		if (previousPriceRange == null) {
			return rangeOf(combinations, ProductViewFakeBuilder::previousPriceOrPrice);
		}
		requireConsistentRange("previous price range", previousPriceRange, combinations,
			ProductViewFakeBuilder::previousPriceOrPrice);
		return previousPriceRange;
	}

	private static PriceView previousPriceOrPrice(CombinationView combination) {
		return combination.getPreviousPrice() == null ? combination.getPrice() : combination.getPreviousPrice();
	}

	private static PriceRange rangeOf(List<CombinationView> combinations, Function<CombinationView, PriceView> priceOf) {
		List<PriceView> prices = combinations.stream().map(priceOf).collect(Collectors.toList());
		if (prices.stream().map(PriceView::getCurrencyCode).distinct().count() > 1) {
			throw contractViolation("the combination prices are in different currencies");
		}
		PriceRangeFake range = new PriceRangeFake();
		range.setMin(copy(prices.stream().min(Comparator.comparingLong(PriceView::getAmount)).orElseThrow()));
		range.setMax(copy(prices.stream().max(Comparator.comparingLong(PriceView::getAmount)).orElseThrow()));
		return range;
	}

	private static void requireConsistentRange(String rangeName, PriceRange range, List<CombinationView> combinations,
		Function<CombinationView, PriceView> priceOf) {
		PriceView min = range.getMin();
		PriceView max = range.getMax();
		if (!Objects.equals(min.getCurrencyCode(), max.getCurrencyCode()) || min.getAmount() > max.getAmount()) {
			throw contractViolation("the " + rangeName + " must have one currency and a minimum not above its maximum");
		}
		for (CombinationView combination : combinations) {
			PriceView price = priceOf.apply(combination);
			if (!Objects.equals(price.getCurrencyCode(), min.getCurrencyCode()) || price.getAmount() < min.getAmount()
				|| price.getAmount() > max.getAmount()) {
				throw contractViolation("the price of combination " + combination.getSku() + " is outside the " + rangeName);
			}
		}
	}

	private static void requireHiddenPrices(PriceRange previousPriceRange, List<CombinationView> combinations) {
		if (previousPriceRange != null) {
			throw contractViolation("a product with hidden prices has no previous price range");
		}
		for (CombinationView combination : combinations) {
			if (combination.getPreviousPrice() != null || combination.getStockStatus() != StockStatus.NOT_ORDERABLE) {
				throw contractViolation("combination " + combination.getSku()
					+ " of a product with hidden prices must be NOT_ORDERABLE and have no previous price");
			}
		}
	}

	private static PriceView copy(PriceView price) {
		PriceViewFake copy = new PriceViewFake();
		copy.setAmount(price.getAmount());
		copy.setCurrencyCode(price.getCurrencyCode());
		return copy;
	}

	private static IllegalStateException contractViolation(String reason) {
		return new IllegalStateException("The ProductView breaks its price contract: " + reason);
	}
}
