package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartItemCodes;

public class CartItemCodesFakeBuilder {

	private CartItemFakeBuilder parentBuilder;

	private String pId;

	private String sku;

	private String ean;

	private String isbn;

	private String jan;

	private String upc;

	public CartItemCodesFakeBuilder() {
		pId = "default_pId";
		sku = "default_sku";
		ean = "default_ean";
		isbn = "default_isbn";
		jan = "default_jan";
		upc = "default_upc";
	}

	public CartItemCodesFakeBuilder(CartItemFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartItemCodesFakeBuilder pId(String pId) {
		this.pId = pId;
		return this;
	}

	public CartItemCodesFakeBuilder sku(String sku) {
		this.sku = sku;
		return this;
	}

	public CartItemCodesFakeBuilder ean(String ean) {
		this.ean = ean;
		return this;
	}

	public CartItemCodesFakeBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public CartItemCodesFakeBuilder jan(String jan) {
		this.jan = jan;
		return this;
	}

	public CartItemCodesFakeBuilder upc(String upc) {
		this.upc = upc;
		return this;
	}


	public CartItemCodes build() {
		CartItemCodesFake codes = new CartItemCodesFake();
		codes.setpId(pId);
		codes.setSku(sku);
		codes.setEan(ean);
		codes.setIsbn(isbn);
		codes.setJan(jan);
		codes.setUpc(upc);
		return codes;
	}

	public CartItemFakeBuilder done() {
		return parentBuilder;
	}
}
