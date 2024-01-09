package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderShipmentItem;

public class OrderShipmentItemFakeBuilder<T> {

	private T parentBuilder;
	private Integer id;
	private int quantity;
	private Integer orderItemId;
	private double weight;

	public OrderShipmentItemFakeBuilder() {
		id = 0;
		quantity = 0;
		orderItemId = 0;
		weight = 1;
	}

	public OrderShipmentItemFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShipmentItemFakeBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShipmentItemFakeBuilder<T> quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderShipmentItemFakeBuilder<T> orderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public OrderShipmentItemFakeBuilder<T> weight(double weight) {
		this.weight = weight;
		return this;
	}

	public OrderShipmentItem build() {
		OrderShipmentItemFake item = new OrderShipmentItemFake();
		item.setId(id);
		item.setQuantity(quantity);
		item.setOrderItemId(orderItemId);
		item.setWeight(weight);
		return item;
	}

	public T done() {
		return parentBuilder;
	}
}
