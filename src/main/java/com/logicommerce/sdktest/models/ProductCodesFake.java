package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.ProductCodes;

public class ProductCodesFake implements ProductCodes {

	private String ean;

	private String isbn;

	private String jan;

	private String manufacturerSku;

	private String sku;

	private String upc;

	@Override
	public String getEan() {
		return ean;
	}

	@Override
	public String getIsbn() {
		return isbn;
	}

	@Override
	public String getJan() {
		return jan;
	}

	@Override
	public String getManufacturerSku() {
		return manufacturerSku;
	}

	@Override
	public String getSku() {
		return sku;
	}

	@Override
	public String getUpc() {
		return upc;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}

	public void setManufacturerSku(String manufacturerSku) {
		this.manufacturerSku = manufacturerSku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

}
