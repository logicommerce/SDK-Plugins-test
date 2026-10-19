package com.logicommerce.sdktest.models.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.catalog.ProductPage;

public class ProductPageFakeBuilder<T> {

	private T parentBuilder;
	private List<ProductViewFakeBuilder<ProductPageFakeBuilder<T>>> products;
	private boolean nextPage;
	private boolean priceFilterIgnored;

	public ProductPageFakeBuilder() {
		products = new ArrayList<>();
		nextPage = false;
		priceFilterIgnored = false;
	}

	public ProductPageFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public ProductViewFakeBuilder<ProductPageFakeBuilder<T>> product() {
		ProductViewFakeBuilder<ProductPageFakeBuilder<T>> product = new ProductViewFakeBuilder<>(this);
		products.add(product);
		return product;
	}

	public ProductPageFakeBuilder<T> nextPage(boolean nextPage) {
		this.nextPage = nextPage;
		return this;
	}

	public ProductPageFakeBuilder<T> priceFilterIgnored(boolean priceFilterIgnored) {
		this.priceFilterIgnored = priceFilterIgnored;
		return this;
	}

	public ProductPage build() {
		ProductPageFake productPage = new ProductPageFake();
		productPage.setProducts(products.stream().map(ProductViewFakeBuilder::build).collect(Collectors.toList()));
		productPage.setNextPage(nextPage);
		productPage.setPriceFilterIgnored(priceFilterIgnored);
		return productPage;
	}

	public T done() {
		return parentBuilder;
	}
}
