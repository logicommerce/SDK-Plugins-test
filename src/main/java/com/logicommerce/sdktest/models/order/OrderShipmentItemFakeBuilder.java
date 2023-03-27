package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderShipmentItemBuilder;
import com.logicommerce.sdk.models.order.OrderShipmentItem;

public class OrderShipmentItemFakeBuilder<T> extends OrderShipmentItemBuilder<T> {

	public OrderShipmentItemFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderShipmentItemFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.id = 0;
		super.quantity = 0;
		super.orderItemId = 0;
		super.weight = 1;
	}

	@Override
	public OrderShipmentItem build() {
		OrderShipmentItem ordershipmentItem = super.build();
		OrderShipmentItemFake item = new OrderShipmentItemFake();
		item.setId(id);
		item.setQuantity(ordershipmentItem.getQuantity());
		item.setOrderItemId(ordershipmentItem.getOrderItemId());
		item.setWeight(ordershipmentItem.getWeight());
		return item;
	}
}