package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderShipmentStatusBuilder;

public class OrderShipmentStatusFakeBuilder<T> extends OrderShipmentStatusBuilder<T> {

	public OrderShipmentStatusFakeBuilder() {
		super();
	}

	public OrderShipmentStatusFakeBuilder(T parentBuilder) {
		super(parentBuilder);
	}
}
