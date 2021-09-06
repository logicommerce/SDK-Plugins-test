package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemTaxBuilder;

public class OrderItemTaxFakeBuilder<T> extends OrderItemTaxBuilder<T> {

	public OrderItemTaxFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemTaxFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.base = 0.0;
		super.taxValue = 0.0;		
	}
}
