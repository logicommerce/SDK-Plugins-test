package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderShipmentItem;

public class OrderShipmentItemFakeBuilder<T> {

	private T parentBuilder;
	private Integer id;
	private int quantity;
	private Integer orderItemId;
	private double weight;
	private String name;
	private String hash;

	public OrderShipmentItemFakeBuilder() {
		id = 0;
		quantity = 0;
		orderItemId = 0;
		weight = 1;
		name = null;
		hash = null;
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

	public OrderShipmentItemFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OrderShipmentItemFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderShipmentItem build() {
		OrderShipmentItemFake item = new OrderShipmentItemFake();
		item.setId(id);
		item.setQuantity(quantity);
		item.setOrderItemId(orderItemId);
		item.setWeight(weight);
		item.setName(name);
		item.setHash(hash);
		return item;
	}

	public T done() {
		return parentBuilder;
	}
}
