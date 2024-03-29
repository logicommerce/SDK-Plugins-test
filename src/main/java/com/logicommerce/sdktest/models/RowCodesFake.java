package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.RowCodes;

public class RowCodesFake implements RowCodes {

	private String pId;

	private String sku;

	private String ean;

	private String isbn;

	private String jan;

	private String upc;
	
	private String manufacturerSku;

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

	@Override
	public String getManufacturerSku() {
		return manufacturerSku;
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

	public void setManufacturerSku(String manufacturerSku) {
		this.manufacturerSku = manufacturerSku;
	}
}
