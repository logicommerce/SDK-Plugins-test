package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderDeliveryBuilder;
import com.logicommerce.sdk.enums.DeliveryType;
import com.logicommerce.sdk.models.order.OrderDelivery;

public class OrderDeliveryFakeBuilder<T> extends OrderDeliveryBuilder<T> {
	
	public OrderDeliveryFakeBuilder() {		
		super();
		defaultValues();
	}
	
	public OrderDeliveryFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.type = DeliveryType.SHIPPING;
		super.geographicalZone = new GeographicalZoneFakeBuilder<>(this);
		super.physicalLocation = new OrderDeliveryPhysicalLocationFakeBuilder<>(this);
	}
	
	@Override
	public OrderShipmentFakeBuilder<OrderDeliveryBuilder<T>> shipments() {
		OrderShipmentFakeBuilder<OrderDeliveryBuilder<T>> shipment = new OrderShipmentFakeBuilder<>(this);
		super.shipments.add(shipment);
		return shipment;
	}
	
	@Override
	public OrderDelivery build() {
		OrderDelivery delivery = super.build();
		OrderDeliveryFake deliveryFake = new OrderDeliveryFake(); 
		deliveryFake.setGeographicalZone(delivery.getGeographicalZone());
		deliveryFake.setPhysicalLocation(delivery.getPhysicalLocation());
		deliveryFake.setShipments(delivery.getShipments());
		deliveryFake.setType(delivery.getType());
		return deliveryFake;
	}
}