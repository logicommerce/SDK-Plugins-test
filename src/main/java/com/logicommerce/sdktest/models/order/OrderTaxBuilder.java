package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderTax;

public class OrderTaxBuilder<T> {

	private T parentBuilder;

	private double taxRate;

	private double reRate;

	private double base;

	private double taxPrice;

	private double rePrice;

	private double totalPrice;

	private double baseWithoutDiscounts;

	private double discount;

	public OrderTaxBuilder() {
		taxRate = 0d;
		reRate = 0d;
		base = 0d;
		taxPrice = 0d;
		rePrice = 0d;
		totalPrice = 0d;
		baseWithoutDiscounts = 0d;
		discount = 0d;
	}

	public OrderTaxBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderTaxBuilder<T> taxRate(double taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	public OrderTaxBuilder<T> reRate(double reRate) {
		this.reRate = reRate;
		return this;
	}

	public OrderTaxBuilder<T> base(double base) {
		this.base = base;
		return this;
	}

	public OrderTaxBuilder<T> taxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
		return this;
	}

	public OrderTaxBuilder<T> rePrice(double rePrice) {
		this.rePrice = rePrice;
		return this;
	}

	public OrderTaxBuilder<T> totalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public OrderTaxBuilder<T> baseWithoutDiscounts(double baseWithoutDiscounts) {
		this.baseWithoutDiscounts = baseWithoutDiscounts;
		return this;
	}

	public OrderTaxBuilder<T> discount(double discount) {
		this.discount = discount;
		return this;
	}

	public OrderTax build() {
		OrderTaxFake information = new OrderTaxFake();
		information.setTaxRate(taxRate);
		information.setReRate(reRate);
		information.setBase(base);
		information.setTaxPrice(taxPrice);
		information.setRePrice(rePrice);
		information.setTotalPrice(totalPrice);
		information.setBaseWithoutDiscounts(baseWithoutDiscounts);
		information.setDiscount(discount);
		return information;
	}

	public T done() {
		return parentBuilder;
	}

}
