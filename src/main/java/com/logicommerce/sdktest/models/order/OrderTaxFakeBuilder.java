package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderTaxBuilder;

public class OrderTaxFakeBuilder<T> extends OrderTaxBuilder<T> {

	public OrderTaxFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderTaxFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.taxRate = 0d;
		super.reRate = 0d;
		super.base = 0d;
		super.taxPrice = 0d;
		super.rePrice = 0d;
		super.totalPrice = 0d;
		super.baseWithoutDiscounts = 0d;
		super.discount = 0d;
		super.code = "tax_code DEFAULT";
	}
}
