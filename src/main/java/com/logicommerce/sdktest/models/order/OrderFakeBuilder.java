package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;

public class OrderFakeBuilder extends DocumentFakeBuilder<OrderFakeBuilder> {

	private OrderStatusType status;
	private int substatusId;

	public OrderFakeBuilder() {
		super();
		status = OrderStatusType.INCOMING;
		substatusId = 0;
	}

	public OrderFakeBuilder status(OrderStatusType status) {
		this.status = status;
		return this;
	}

	public OrderFakeBuilder substatusId(int substatusId) {
		this.substatusId = substatusId;
		return this;
	}

	public Order build() {
		OrderFake orderFake = new OrderFake();
		orderFake.setStatus(status);
		orderFake.setSubstatusId(substatusId);
		setFields(orderFake);
		return orderFake;
	}

	@Override
	public OrderFakeBuilder returnThis() {
		return this;
	}
}
