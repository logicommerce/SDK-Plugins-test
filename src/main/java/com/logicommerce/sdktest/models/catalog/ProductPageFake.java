package com.logicommerce.sdktest.models.catalog;

import java.util.List;
import com.logicommerce.sdk.models.catalog.ProductPage;
import com.logicommerce.sdk.models.catalog.ProductView;

public class ProductPageFake implements ProductPage {

	private List<ProductView> products;

	private boolean nextPage;

	private boolean priceFilterIgnored;

	@Override
	public List<ProductView> getProducts() {
		return products;
	}

	@Override
	public boolean hasNextPage() {
		return nextPage;
	}

	@Override
	public boolean isPriceFilterIgnored() {
		return priceFilterIgnored;
	}

	public void setProducts(List<ProductView> products) {
		this.products = products;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public void setPriceFilterIgnored(boolean priceFilterIgnored) {
		this.priceFilterIgnored = priceFilterIgnored;
	}
}
