package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderShippingTrackingBuilder;
import com.logicommerce.sdk.models.order.OrderShippingTracking;

public class OrderShippingTrackingFakeBuilder<T> extends OrderShippingTrackingBuilder<T> {

	public OrderShippingTrackingFakeBuilder() {
		super();
		defaultValues();
	}
	
	public OrderShippingTrackingFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.trackingNumber = "0001";
	}
	
	public OrderShippingTrackingFakeBuilder<T> trackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}
	
	public OrderShippingTrackingPackageFakeBuilder<OrderShippingTrackingBuilder<T>> packages() {
		OrderShippingTrackingPackageFakeBuilder<OrderShippingTrackingBuilder<T>> trackingPackage = new OrderShippingTrackingPackageFakeBuilder<>(this);
		super.trackingPackages.add(trackingPackage);
		return trackingPackage;
	}

	public OrderShippingTracking build() {
		OrderShippingTracking tracking = super.build();
		OrderShippingTrackingFake trackingFake = new OrderShippingTrackingFake();
		trackingFake.setTrackingNumber(tracking.getTrackingNumber());
		trackingFake.setId(super.id);
		trackingFake.setProperties(tracking.getProperties());
		trackingFake.setTrackingPackages(tracking.getPackages());
		
		return trackingFake;
	}
}