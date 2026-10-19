package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.AppliedTaxView;

public class AppliedTaxViewFake implements AppliedTaxView {

	private String name;

	private String rate;

	private long base;

	private long amount;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRate() {
		return rate;
	}

	@Override
	public long getBase() {
		return base;
	}

	@Override
	public long getAmount() {
		return amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setBase(long base) {
		this.base = base;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
