package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderDeliveryPhysicalLocationBuilder;
import com.logicommerce.sdk.models.order.OrderDeliveryPhysicalLocation;
import com.logicommerce.sdktest.models.LocationFakeBuilder;

public class OrderDeliveryPhysicalLocationFakeBuilder<T> extends OrderDeliveryPhysicalLocationBuilder<T> {
	
	public OrderDeliveryPhysicalLocationFakeBuilder() {		
		super();
		defaultValues();
	}
	
	public OrderDeliveryPhysicalLocationFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.physicalLocationId = 1;
		super.physicalLocationPId = "test";
		super.name = "TEST name";
		super.address = "test address";
		super.city = "test city";
		super.state = "test state";
		super.postalCode = "test postalCode";
		super.location = new LocationFakeBuilder<>(this);
	}
	
	public OrderDeliveryPhysicalLocation build() {
		OrderDeliveryPhysicalLocation deliveryPhysicalLocation = super.build();
		OrderDeliveryPhysicalLocationFake orderDeliveryPhysicalLocationFake = new OrderDeliveryPhysicalLocationFake();
		orderDeliveryPhysicalLocationFake.setAddress(deliveryPhysicalLocation.getAddress());
		orderDeliveryPhysicalLocationFake.setCity(deliveryPhysicalLocation.getCity());
		orderDeliveryPhysicalLocationFake.setLocation(deliveryPhysicalLocation.getLocation());
		orderDeliveryPhysicalLocationFake.setName(deliveryPhysicalLocation.getName());
		orderDeliveryPhysicalLocationFake.setPhysicalLocationId(deliveryPhysicalLocation.getPhysicalLocationId());
		orderDeliveryPhysicalLocationFake.setPhysicalLocationPId(deliveryPhysicalLocation.getPhysicalLocationPId());
		orderDeliveryPhysicalLocationFake.setPostalCode(deliveryPhysicalLocation.getPostalCode());
		orderDeliveryPhysicalLocationFake.setState(deliveryPhysicalLocation.getState());
		
		return orderDeliveryPhysicalLocationFake;
	}
}