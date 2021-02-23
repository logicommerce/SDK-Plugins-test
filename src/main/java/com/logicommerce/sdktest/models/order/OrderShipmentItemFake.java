package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderShipmentItem;

public class OrderShipmentItemFake implements OrderShipmentItem {

	private Integer id;

	private int quantity;

	private Integer orderItemId;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

}
