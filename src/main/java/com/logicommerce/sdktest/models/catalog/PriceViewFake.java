package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.PriceView;

public class PriceViewFake implements PriceView {

	private long amount;

	private String currencyCode;

	@Override
	public long getAmount() {
		return amount;
	}

	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
