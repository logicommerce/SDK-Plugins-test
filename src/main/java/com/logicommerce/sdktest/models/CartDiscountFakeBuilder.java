package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartDiscount;

public class CartDiscountFakeBuilder {

	private int discountId;
	private String name;
	private String description;
	private Integer multiplier = 1;
	private double discountValue = 0.0;
	private double valueWithTaxes = 0.0;

	private CartFakeBuilder parentBuilder;

	public CartDiscountFakeBuilder() {}

	public CartDiscountFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartDiscountFakeBuilder discountId(int discountId) {
		this.discountId = discountId;
		return this;
	}

	public CartDiscountFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CartDiscountFakeBuilder description(String description) {
		this.description = description;
		return this;
	}

	public CartDiscountFakeBuilder multiplier(Integer multiplier) {
		this.multiplier = multiplier;
		return this;
	}

	public CartDiscountFakeBuilder discountValue(double discountValue) {
		this.discountValue = discountValue;
		return this;
	}

	public CartDiscountFakeBuilder valueWithTaxes(double valueWithTaxes) {
		this.valueWithTaxes = valueWithTaxes;
		return this;
	}

	public CartDiscount build() {
		CartDiscountFake discount = new CartDiscountFake();
		discount.setDiscountId(discountId);
		discount.setName(name);
		discount.setDescription(description);
		discount.setMultiplier(multiplier);
		discount.setDiscountValue(discountValue);
		discount.setValueWithTaxes(valueWithTaxes);
		return discount;
	}

	public CartFakeBuilder done() {
		return parentBuilder;
	}

}
