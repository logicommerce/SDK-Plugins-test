package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderBaseStatusBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusActionBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusBuilder;
import com.logicommerce.sdk.enums.OrderStatusType;

public class OrderStatusFakeBuilder<T> extends OrderStatusBuilder<T> {
	

	public OrderStatusFakeBuilder() {
		super();
	}

	public OrderStatusFakeBuilder(T parentBuilder) {
		super(parentBuilder);
	}
	
	@Override
	public OrderStatusActionBuilder<OrderBaseStatusBuilder<OrderStatusType, T>> actions() {
		OrderStatusActionBuilder<OrderBaseStatusBuilder<OrderStatusType, T>> action = new OrderStatusActionFakeBuilder<>(this);
		super.actions.add(action);
		return action;
	}	
}