package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartDiscount;

public class CartDiscountFake implements CartDiscount {

	private int discountId;
	private String name;
	private String description;
	private Integer multiplier = 1;
	private double discountValue = 0.0;
	private double valueWithTaxes = 0.0;

	@Override
	public int getDiscountId() {
		return discountId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Integer getMultiplier() {
		return multiplier;
	}

	@Override
	public double getValueWithTaxes() {
		return valueWithTaxes;
	}

	@Override
	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMultiplier(Integer multiplier) {
		this.multiplier = multiplier;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public void setValueWithTaxes(double valueWithTaxes) {
		this.valueWithTaxes = valueWithTaxes;
	}

}
