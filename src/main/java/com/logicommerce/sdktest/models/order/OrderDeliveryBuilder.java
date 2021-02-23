package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.enums.DeliveryType;
import com.logicommerce.sdk.models.order.OrderDelivery;

public class OrderDeliveryBuilder {
	
	private OrderBuilder parentBuilder;
	
	private DeliveryType type;
	
	private OrderDeliveryPhysicalLocationBuilder<OrderDeliveryBuilder> physicalLocation;
	
	private List<OrderShipmentBuilder<OrderDeliveryBuilder>> shipments;
		
	private GeographicalZoneBuilder<OrderDeliveryBuilder> geographicalZone;
	
	public OrderDeliveryBuilder() {		
		geographicalZone = new GeographicalZoneBuilder<>(this);
		shipments = new ArrayList<>();
		physicalLocation = new OrderDeliveryPhysicalLocationBuilder<>(this);
		type = DeliveryType.SHIPPING;
	}
	
	public OrderDeliveryBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public OrderDeliveryBuilder type(DeliveryType type) {
		this.type = type;
		return this;
	}
	
	public OrderDeliveryBuilder geographicalZone() {
		this.geographicalZone = new GeographicalZoneBuilder<>(this);
		return this;
	}
	
	public OrderShipmentBuilder<OrderDeliveryBuilder> shipments() {
		OrderShipmentBuilder<OrderDeliveryBuilder> shipment = new OrderShipmentBuilder<>(this);
		shipments.add(shipment);
		return shipment;
	}
	
	public OrderDelivery build() {
		OrderDeliveryFake delivery  = new OrderDeliveryFake();
		delivery.setGeographicalZone(geographicalZone.build());
		delivery.setPhysicalLocation(physicalLocation.build());
		delivery.setShipments(shipments.stream().map(OrderShipmentBuilder::build).collect(Collectors.toList()));
		delivery.setType(type);
		return delivery;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}
}
