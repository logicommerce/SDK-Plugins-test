package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemPricesBuilder;

public class OrderItemPricesFakeBuilder<T> extends OrderItemPricesBuilder<T> {

	public OrderItemPricesFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemPricesFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.productPrice = 0d;
		super.optionsPrice = 0d;
		super.previousPrice = 0d;
		super.price = 0d;
		super.totalTaxes = 0d;
		super.total = 0d;
	}
}