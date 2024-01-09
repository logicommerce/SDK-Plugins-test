package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.TaxType;
import com.logicommerce.sdk.models.order.OrderItemTax;

public class OrderItemTaxFakeBuilder<T> {

	private T parentBuilder;
	private double base;
	private double taxValue;
	private double taxRate;
	private TaxType type;
	private String code;

	public OrderItemTaxFakeBuilder() {
		base = 0.0;
		taxValue = 0.0;
		taxRate = 0.0;
		type = TaxType.LOGICOMMERCE;
	}

	public OrderItemTaxFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemTaxFakeBuilder<T> base(double base) {
		this.base = base;
		return this;
	}

	public OrderItemTaxFakeBuilder<T> taxValue(double taxValue) {
		this.taxValue = taxValue;
		return this;
	}

	public OrderItemTaxFakeBuilder<T> taxRate(double taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	public OrderItemTaxFakeBuilder<T> type(TaxType type) {
		this.type = type;
		return this;
	}

	public OrderItemTaxFakeBuilder<T> code(String code) {
		this.code = code;
		return this;
	}

	public OrderItemTax build() {
		OrderItemTaxFake orderItemTaxFake = new OrderItemTaxFake();
		orderItemTaxFake.setBase(base);
		orderItemTaxFake.setTaxValue(taxValue);
		orderItemTaxFake.setTaxRate(taxRate);
		orderItemTaxFake.setType(type);
		orderItemTaxFake.setCode(code);
		return orderItemTaxFake;
	}

	public T done() {
		return parentBuilder;
	}
}
