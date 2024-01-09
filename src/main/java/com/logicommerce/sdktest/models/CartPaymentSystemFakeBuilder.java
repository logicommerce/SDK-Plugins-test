package com.logicommerce.sdktest.models;

public class CartPaymentSystemFakeBuilder {

	private CartFakeBuilder parentBuilder;
	private double price;
	private String taxCode;

	public CartPaymentSystemFakeBuilder() {}

	public CartPaymentSystemFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartPaymentSystemFakeBuilder price(double price) {
		this.price = price;
		return this;
	}

	public CartPaymentSystemFakeBuilder taxCode(String taxCode) {
		this.taxCode = taxCode;
		return this;
	}

	public CartPaymentSystemFake build() {
		CartPaymentSystemFake paymentSystem = new CartPaymentSystemFake();
		paymentSystem.setPrice(price);
		paymentSystem.setTaxCode(taxCode);
		return paymentSystem;
	}

	public CartFakeBuilder done() {
		return parentBuilder;
	}
}
