package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class OrderBaseStatusBuilder<T, P> {
	
	private P parentBuilder;
	
	private List<OrderStatusActionBuilder<OrderBaseStatusBuilder<T, P>>> actions;
	
	private LocalDateTime currentDateTime;
	
	private Integer id;
	
	private T status;
	
	private int substatusId;
	
	public OrderBaseStatusBuilder() {
		id = 0;
		actions = new ArrayList<>();
		currentDateTime = LocalDateTime.now();
		substatusId = 0;
	}

	public OrderBaseStatusBuilder(P parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderBaseStatusBuilder<T, P> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderStatusActionBuilder<OrderBaseStatusBuilder<T, P>> actions() {
		OrderStatusActionBuilder<OrderBaseStatusBuilder<T, P>> action = new OrderStatusActionBuilder<>(this);
		actions.add(action);
		return action;
	}

	public OrderBaseStatusBuilder<T, P> currentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
		return this;
	}

	public OrderBaseStatusBuilder<T, P> status(T status) {
		this.status = status;
		return this;
	}

	public OrderBaseStatusBuilder<T, P> substatusId(int substatusId) {
		this.substatusId = substatusId;
		return this;
	}
	
	public void setFields(OrderBaseStatusFake<T> statusFake) {
		statusFake.setId(id);
		statusFake.setActions(actions.stream().map(OrderStatusActionBuilder::build).collect(Collectors.toList()));
		statusFake.setCurrentDateTime(currentDateTime);
		statusFake.setStatus(status);
		statusFake.setSubstatusId(substatusId);
	}
	
	public abstract  OrderBaseStatusFake<T> build();

	public P done() {
		return parentBuilder;
	}
}
