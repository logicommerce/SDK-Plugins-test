package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;

public class OrderFake extends DocumentFake implements Order {

	private OrderStatusType status;
	private int substatusId;

	@Override
	public OrderStatusType getStatus() {
		return status;
	}

	public void setStatus(OrderStatusType status) {
		this.status = status;
	}

	@Override
	public int getSubstatusId() {
		return substatusId;
	}

	public void setSubstatusId(int substatusId) {
		this.substatusId = substatusId;
	}

}
