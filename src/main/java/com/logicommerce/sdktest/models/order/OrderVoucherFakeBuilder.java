package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderVoucherBuilder;

public class OrderVoucherFakeBuilder<T> extends OrderVoucherBuilder<T> {

	public OrderVoucherFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderVoucherFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.code = "code DEFAULT";
		super.availableBalance = 1d;
		super.balanceProcessed = false;
	}
}