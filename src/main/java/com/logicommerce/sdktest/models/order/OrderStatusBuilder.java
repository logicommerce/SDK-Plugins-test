package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.OrderStatusType;

public class OrderStatusBuilder extends OrderBaseStatusBuilder<OrderStatusType, OrderBuilder> {
	

	public OrderStatusBuilder() {
		super();
	}

	public OrderStatusBuilder(OrderBuilder parentBuilder) {
		super(parentBuilder);
	}

	@Override
	public OrderStatusFake build() {
		OrderStatusFake status = new OrderStatusFake();
		setFields(status);
		return status;
	}

}
