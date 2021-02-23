package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.ProductCodes;

public class ProductCodesBuilder<T> {

	private T parentBuilder;

	private String ean;

	private String isbn;

	private String jan;

	private String manufacturerSku;

	private String sku;

	private String upc;

	public ProductCodesBuilder() {
		ean = "ean DEFAULT";
		isbn = "isbn DEFAULT";
		jan = "jan DEFAULT";
		manufacturerSku = "manufacturerSku DEFAULT";
		sku = "sku DEFAULT";
		upc = "upc DEFAULT";
	}

	public ProductCodesBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public ProductCodesBuilder<T> ean(String ean) {
		this.ean = ean;
		return this;
	}

	public ProductCodesBuilder<T> isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public ProductCodesBuilder<T> jan(String jan) {
		this.jan = jan;
		return this;
	}

	public ProductCodesBuilder<T> manufacturerSku(String manufacturerSku) {
		this.manufacturerSku = manufacturerSku;
		return this;
	}

	public ProductCodesBuilder<T> sku(String sku) {
		this.sku = sku;
		return this;
	}

	public ProductCodesBuilder<T> upc(String upc) {
		this.upc = upc;
		return this;
	}

	public ProductCodes build() {
		ProductCodesFake codes = new ProductCodesFake();
		codes.setEan(ean);
		codes.setIsbn(isbn);
		codes.setJan(jan);
		codes.setManufacturerSku(manufacturerSku);
		codes.setSku(sku);
		codes.setUpc(upc);
		return codes;
	}

	public T done() {
		return parentBuilder;
	}

}
