package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.PriceView;

public class PriceViewFakeBuilder<T> {

	private T parentBuilder;
	private long amount;
	private String currencyCode;

	public PriceViewFakeBuilder() {
		amount = 0;
		currencyCode = "EUR";
	}

	public PriceViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public PriceViewFakeBuilder<T> amount(long amount) {
		this.amount = amount;
		return this;
	}

	public PriceViewFakeBuilder<T> currencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public PriceView build() {
		PriceViewFake priceView = new PriceViewFake();
		priceView.setAmount(amount);
		priceView.setCurrencyCode(currencyCode);
		return priceView;
	}

	public T done() {
		return parentBuilder;
	}
}
