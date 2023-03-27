package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.RowCodes;

public class RowCodesFakeBuilder {

	private CartItemFakeBuilder parentBuilder;

	private String pId;

	private String sku;

	private String ean;

	private String isbn;

	private String jan;

	private String upc;
	
	private String manufacturerSku;

	public RowCodesFakeBuilder() {
		pId = "default_pId";
		sku = "default_sku";
		ean = "default_ean";
		isbn = "default_isbn";
		jan = "default_jan";
		upc = "default_upc";
		manufacturerSku = "default_manufacturerSku";
	}

	public RowCodesFakeBuilder(CartItemFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public RowCodesFakeBuilder pId(String pId) {
		this.pId = pId;
		return this;
	}

	public RowCodesFakeBuilder sku(String sku) {
		this.sku = sku;
		return this;
	}

	public RowCodesFakeBuilder ean(String ean) {
		this.ean = ean;
		return this;
	}

	public RowCodesFakeBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public RowCodesFakeBuilder jan(String jan) {
		this.jan = jan;
		return this;
	}

	public RowCodesFakeBuilder upc(String upc) {
		this.upc = upc;
		return this;
	}

	public RowCodesFakeBuilder manufacturerSku(String manufacturerSku) {
		this.manufacturerSku = manufacturerSku;
		return this;
	}

	public RowCodes build() {
		RowCodesFake codes = new RowCodesFake();
		codes.setpId(pId);
		codes.setSku(sku);
		codes.setEan(ean);
		codes.setIsbn(isbn);
		codes.setJan(jan);
		codes.setUpc(upc);
		codes.setManufacturerSku(manufacturerSku);
		return codes;
	}

	public CartItemFakeBuilder done() {
		return parentBuilder;
	}
}
