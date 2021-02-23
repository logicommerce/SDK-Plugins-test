package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderItemTax;

public class OrderItemTaxBuilder<T> {

	private T parentBuilder;

	private double base;

	private double taxValue;

	public OrderItemTaxBuilder() {
		base = 0.0;
		taxValue = 0.0;
	}

	public OrderItemTaxBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemTaxBuilder<T> base(double base) {
		this.base = base;
		return this;
	}

	public OrderItemTaxBuilder<T> taxValue(double taxValue) {
		this.taxValue = taxValue;
		return this;
	}

	public OrderItemTax build() {
		OrderItemTaxFake tax = new OrderItemTaxFake();
		tax.setBase(base);
		tax.setTaxValue(taxValue);
		return tax;
	}

	public T done() {
		return parentBuilder;
	}

}
