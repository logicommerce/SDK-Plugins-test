package com.logicommerce.sdktest.models.catalog;

import java.util.List;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.OptionView;
import com.logicommerce.sdk.models.catalog.PriceRange;
import com.logicommerce.sdk.models.catalog.ProductView;

public class ProductViewFake implements ProductView {

	private int id;

	private String name;

	private String shortDescription;

	private String longDescription;

	private String urlSeo;

	private String url;

	private List<String> images;

	private List<String> categoryNamePaths;

	private List<OptionView> options;

	private List<CombinationView> combinations;

	private PriceRange priceRange;

	private PriceRange previousPriceRange;

	private boolean taxesIncluded;

	private boolean requiresNonCombinableOption;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public String getLongDescription() {
		return longDescription;
	}

	@Override
	public String getUrlSeo() {
		return urlSeo;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public List<String> getImages() {
		return images;
	}

	@Override
	public List<String> getCategoryNamePaths() {
		return categoryNamePaths;
	}

	@Override
	public List<OptionView> getOptions() {
		return options;
	}

	@Override
	public List<CombinationView> getCombinations() {
		return combinations;
	}

	@Override
	public PriceRange getPriceRange() {
		return priceRange;
	}

	@Override
	public PriceRange getPreviousPriceRange() {
		return previousPriceRange;
	}

	@Override
	public boolean isTaxesIncluded() {
		return taxesIncluded;
	}

	@Override
	public boolean requiresNonCombinableOption() {
		return requiresNonCombinableOption;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public void setUrlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public void setCategoryNamePaths(List<String> categoryNamePaths) {
		this.categoryNamePaths = categoryNamePaths;
	}

	public void setOptions(List<OptionView> options) {
		this.options = options;
	}

	public void setCombinations(List<CombinationView> combinations) {
		this.combinations = combinations;
	}

	public void setPriceRange(PriceRange priceRange) {
		this.priceRange = priceRange;
	}

	public void setPreviousPriceRange(PriceRange previousPriceRange) {
		this.previousPriceRange = previousPriceRange;
	}

	public void setTaxesIncluded(boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
	}

	public void setRequiresNonCombinableOption(boolean requiresNonCombinableOption) {
		this.requiresNonCombinableOption = requiresNonCombinableOption;
	}
}
