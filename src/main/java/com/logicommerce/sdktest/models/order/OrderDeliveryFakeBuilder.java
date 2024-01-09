package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.GeographicalZoneBuilder;
import com.logicommerce.sdk.builders.order.OrderDeliveryPhysicalLocationBuilder;
import com.logicommerce.sdk.enums.DeliveryType;
import com.logicommerce.sdk.models.order.OrderDelivery;

public class OrderDeliveryFakeBuilder<T> {

	private T parentBuilder;
	private DeliveryType type;
	private OrderDeliveryPhysicalLocationBuilder<OrderDeliveryFakeBuilder<T>> physicalLocation;
	private GeographicalZoneBuilder<OrderDeliveryFakeBuilder<T>> geographicalZone;
	private List<OrderShipmentFakeBuilder<OrderDeliveryFakeBuilder<T>>> shipments;


	public OrderDeliveryFakeBuilder() {
		type = DeliveryType.SHIPPING;
		geographicalZone = new GeographicalZoneFakeBuilder<>(this);
		physicalLocation = new OrderDeliveryPhysicalLocationFakeBuilder<>(this);
		shipments = new ArrayList<>();
	}

	public OrderDeliveryFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderDeliveryFakeBuilder<T> type(DeliveryType type) {
		this.type = type;
		return this;
	}

	public GeographicalZoneBuilder<OrderDeliveryFakeBuilder<T>> geographicalZone() {
		return geographicalZone;
	}

	public OrderDeliveryPhysicalLocationBuilder<OrderDeliveryFakeBuilder<T>> physicalLocation() {
		return physicalLocation;
	}

	public OrderShipmentFakeBuilder<OrderDeliveryFakeBuilder<T>> shipments() {
		var shipment = new OrderShipmentFakeBuilder<OrderDeliveryFakeBuilder<T>>(this);
		shipments.add(shipment);
		return shipment;
	}

	public OrderDelivery build() {
		OrderDeliveryFake deliveryFake = new OrderDeliveryFake();
		deliveryFake.setType(type);
		deliveryFake.setGeographicalZone(geographicalZone.build());
		deliveryFake.setPhysicalLocation(physicalLocation.build());
		deliveryFake.setShipments(shipments.stream()
			.map(OrderShipmentFakeBuilder::build)
			.collect(Collectors.toList()));
		return deliveryFake;
	}

	public T done() {
		return parentBuilder;
	}
}
