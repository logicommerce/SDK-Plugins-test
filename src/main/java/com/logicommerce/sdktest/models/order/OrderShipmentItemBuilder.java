package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderShipmentItem;

public class OrderShipmentItemBuilder<T> {

	private OrderShipmentBuilder<T> parentBuilder;

	private Integer id;

	private int quantity;

	private Integer orderItemId;

	public OrderShipmentItemBuilder() {
		id = 0;
		quantity = 0;
		orderItemId = 0;
	}

	public OrderShipmentItemBuilder(OrderShipmentBuilder<T> parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShipmentItemBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShipmentItemBuilder<T> quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderShipmentItemBuilder<T> orderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public OrderShipmentItem build() {
		OrderShipmentItemFake item = new OrderShipmentItemFake();
		item.setId(id);
		item.setQuantity(quantity);
		item.setOrderItemId(orderItemId);
		return item;
	}

	public OrderShipmentBuilder<T> done() {
		return parentBuilder;
	}

}
