package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartItemCodes;

public class CartItemCodesFake implements CartItemCodes {

	private String pId;

	private String sku;

	private String ean;

	private String isbn;

	private String jan;

	private String upc;

	@Override
	public String getPId() {
		return pId;
	}

	@Override
	public String getSku() {
		return sku;
	}

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
	public String getUpc() {
		return upc;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public void setUpc(String upc) {
		this.upc = upc;
	}

}
