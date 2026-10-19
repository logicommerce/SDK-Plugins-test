package com.logicommerce.sdktest.models.order;

import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.order.OrderShipmentStatusBuilder;
import com.logicommerce.sdk.builders.order.OrderStatusActionBuilder;
import com.logicommerce.sdk.enums.OrderShipmentStatusType;
import com.logicommerce.sdk.models.order.OrderShipmentStatus;

public class OrderShipmentStatusFakeBuilder<T> extends OrderShipmentStatusBuilder<T> {

	private OrderShipmentStatusType fromStatus;

	public OrderShipmentStatusFakeBuilder() {
		super();
	}

	public OrderShipmentStatusFakeBuilder(T parentBuilder) {
		super(parentBuilder);
	}

	public OrderShipmentStatusFakeBuilder<T> fromStatus(OrderShipmentStatusType fromStatus) {
		this.fromStatus = fromStatus;
		return this;
	}

	@Override
	public OrderShipmentStatus build() {
		OrderShipmentStatusFake shipmentStatus = new OrderShipmentStatusFake();
		shipmentStatus.setId(id);
		shipmentStatus.setActions(actions.stream().map(OrderStatusActionBuilder::build).collect(Collectors.toList()));
		shipmentStatus.setCurrentDateTime(currentDateTime);
		shipmentStatus.setStatus(status);
		shipmentStatus.setSubstatusId(substatusId);
		shipmentStatus.setFromStatus(fromStatus);
		return shipmentStatus;
	}
}
