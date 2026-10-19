package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.AppliedTaxView;

public class AppliedTaxViewFakeBuilder<T> {

	private T parentBuilder;
	private String name;
	private String rate;
	private long base;
	private long amount;

	public AppliedTaxViewFakeBuilder() {
		name = "name DEFAULT";
		rate = "21";
		base = 0;
		amount = 0;
	}

	public AppliedTaxViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public AppliedTaxViewFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public AppliedTaxViewFakeBuilder<T> rate(String rate) {
		this.rate = rate;
		return this;
	}

	public AppliedTaxViewFakeBuilder<T> base(long base) {
		this.base = base;
		return this;
	}

	public AppliedTaxViewFakeBuilder<T> amount(long amount) {
		this.amount = amount;
		return this;
	}

	public AppliedTaxView build() {
		AppliedTaxViewFake appliedTaxView = new AppliedTaxViewFake();
		appliedTaxView.setName(name);
		appliedTaxView.setRate(rate);
		appliedTaxView.setBase(base);
		appliedTaxView.setAmount(amount);
		return appliedTaxView;
	}

	public T done() {
		return parentBuilder;
	}
}
