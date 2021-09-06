package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.order.OrderBaseStatusBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusActionBuilder;
import com.logicommerce.sdk.models.order.OrderBaseStatus;

public abstract class OrderBaseStatusFakeBuilder<T, P> extends OrderBaseStatusBuilder<T, P>{
		
	public OrderBaseStatusFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderBaseStatusFakeBuilder(P parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.currentDateTime = LocalDateTime.now();
		super.substatusId = 0;
	}

	public OrderBaseStatusFakeBuilder<T, P> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderStatusActionBuilder<OrderBaseStatusBuilder<T, P>> actions() {
		OrderStatusActionBuilder<OrderBaseStatusBuilder<T, P>> action = new OrderStatusActionFakeBuilder<>(this);
		actions.add(action);
		return action;
	}
	
	public void setFields(OrderBaseStatusFake<T> statusFake) {		
		statusFake.setId(id);
		statusFake.setActions(actions.stream().map(OrderStatusActionBuilder::build).collect(Collectors.toList()));
		statusFake.setCurrentDateTime(currentDateTime);
		statusFake.setStatus(status);
		statusFake.setSubstatusId(substatusId);
	}
	
	public abstract  OrderBaseStatus<T> build();
}