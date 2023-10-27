package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemTaxBuilder;
import com.logicommerce.sdk.enums.TaxType;

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
		base(0.0);
		taxValue(0.0);
		type(TaxType.LOGICOMMERCE);
	}
}
