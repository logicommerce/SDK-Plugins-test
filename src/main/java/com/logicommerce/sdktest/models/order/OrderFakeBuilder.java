package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;

public class OrderFakeBuilder extends DocumentFakeBuilder<OrderFakeBuilder> {

	private OrderStatusType status;
	private int substatusId;
	private OrderTotalCurrencyFakeBuilder<OrderFakeBuilder> totalCurrency;

	public OrderFakeBuilder() {
		super();
		status = OrderStatusType.INCOMING;
		substatusId = 0;
		totalCurrency = new OrderTotalCurrencyFakeBuilder<>(this);
	}

	public OrderFakeBuilder status(OrderStatusType status) {
		this.status = status;
		return this;
	}

	public OrderFakeBuilder substatusId(int substatusId) {
		this.substatusId = substatusId;
		return this;
	}

	public OrderTotalCurrencyFakeBuilder<OrderFakeBuilder> totalCurrency() {
		return totalCurrency;
	}

	public Order build() {
		OrderFake orderFake = new OrderFake();
		orderFake.setStatus(status);
		orderFake.setSubstatusId(substatusId);
		orderFake.setTotalCurrency(totalCurrency.build());
		setFields(orderFake);
		return orderFake;
	}

	@Override
	public OrderFakeBuilder returnThis() {
		return this;
	}
}
