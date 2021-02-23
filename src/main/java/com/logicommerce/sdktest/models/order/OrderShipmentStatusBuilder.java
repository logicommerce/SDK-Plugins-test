package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.OrderShipmentStatusType;

public class OrderShipmentStatusBuilder<T> extends OrderBaseStatusBuilder<OrderShipmentStatusType, OrderShipmentBuilder<T>> {

	public OrderShipmentStatusBuilder() {
		super();
	}

	public OrderShipmentStatusBuilder(OrderShipmentBuilder<T> parentBuilder) {
		super(parentBuilder);
	}

	@Override
	public OrderShipmentStatusFake build() {
		OrderShipmentStatusFake status = new OrderShipmentStatusFake();
		setFields(status);
		return status;
	}

}
