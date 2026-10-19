package com.logicommerce.sdktest.models.order;

import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.order.OrderBaseStatusBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusActionBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusBuilder;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.OrderStatus;

public class OrderStatusFakeBuilder<T> extends OrderStatusBuilder<T> {

	private OrderStatusType fromStatus;

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

	public OrderStatusFakeBuilder<T> fromStatus(OrderStatusType fromStatus) {
		this.fromStatus = fromStatus;
		return this;
	}

	@Override
	public OrderStatus build() {
		OrderStatusFake orderStatus = new OrderStatusFake();
		orderStatus.setId(id);
		orderStatus.setActions(actions.stream().map(OrderStatusActionBuilder::build).collect(Collectors.toList()));
		orderStatus.setCurrentDateTime(currentDateTime);
		orderStatus.setStatus(status);
		orderStatus.setSubstatusId(substatusId);
		orderStatus.setFromStatus(fromStatus);
		return orderStatus;
	}
}