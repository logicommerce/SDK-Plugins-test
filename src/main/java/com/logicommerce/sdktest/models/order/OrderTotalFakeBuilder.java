package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderTotalBuilder;

public class OrderTotalFakeBuilder<T> extends OrderTotalBuilder<T> {

	public OrderTotalFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderTotalFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.subtotal = 0d;
		super.subtotalItems = 0d;
		super.subtotalPaymentSystem = 0d;
		super.subtotalShippings = 0d;
		super.total = 0d;
		super.totalDiscounts = 0d;
		super.totalItems = 0d;
		super.totalPaymentSystem = 0d;
		super.totalShippings = 0d;
		super.totalTaxes = 0d;
		super.totalVouchers = 0d;
	}
}
