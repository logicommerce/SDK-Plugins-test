package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.builders.order.OrderShippingTrackingPackageActivityBuilder;
import com.logicommerce.sdk.models.ElementProperyImpl;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackageActivity;

public class OrderShippingTrackingPackageActivityFakeBuilder<T> extends OrderShippingTrackingPackageActivityBuilder<T> {

	public OrderShippingTrackingPackageActivityFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderShippingTrackingPackageActivityFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.dateTime = LocalDateTime.now();
		super.description = "TEST description";
		super.status = "TEST status";
	}
	
	public OrderShippingTrackingPackageActivityBuilder<T> addProperty(String name, String value) {
		properties.add(new ElementProperyImpl(name, value));
		return this;
	}
	
	public OrderShippingTrackingPackageActivity build() {
		OrderShippingTrackingPackageActivity trackingPackageActivity = super.build();
		OrderShippingTrackingPackageActivityFake trackingPackageActivityFake = new OrderShippingTrackingPackageActivityFake();		
		trackingPackageActivityFake.setDateTime(trackingPackageActivity.getDateTime());
		trackingPackageActivityFake.setDescription(trackingPackageActivity.getDescription());
		trackingPackageActivityFake.setId(super.id);
		trackingPackageActivityFake.setStatus(trackingPackageActivity.getStatus());
		trackingPackageActivityFake.setProperties(trackingPackageActivity.getProperties());
		
		return trackingPackageActivityFake;
	}

}