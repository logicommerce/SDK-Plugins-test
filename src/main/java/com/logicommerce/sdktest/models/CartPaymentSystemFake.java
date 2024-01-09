package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartPaymentSystem;

public class CartPaymentSystemFake implements CartPaymentSystem {

	private double price;
	private String taxCode;

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getTaxCode() {
		return taxCode;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

}
