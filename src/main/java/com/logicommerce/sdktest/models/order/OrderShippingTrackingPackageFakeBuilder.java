package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.builders.order.OrderShippingTrackingPackageActivityBuilder;
import com.logicommerce.sdk.builders.order.OrderShippingTrackingPackageBuilder;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackage;

public class OrderShippingTrackingPackageFakeBuilder<T> extends OrderShippingTrackingPackageBuilder<T> {

	public OrderShippingTrackingPackageFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderShippingTrackingPackageFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.id = 0;
		super.weight = 1d;
		super.weightUnits = "kg";
		super.lastUpdate = LocalDateTime.now();
	}

	public OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>> activities() {
		OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>> activity =
			new OrderShippingTrackingPackageActivityFakeBuilder<>(this);
		activities.add(activity);
		return activity;
	}

	@Override
	public OrderShippingTrackingPackage build() {
		OrderShippingTrackingPackage trackingPackage = super.build();
		OrderShippingTrackingPackageFake trackingPackageFake = new OrderShippingTrackingPackageFake();
		trackingPackageFake.setWeight(trackingPackage.getWeight());
		trackingPackageFake.setWeightUnits(trackingPackage.getWeightUnits());
		trackingPackageFake.setId(super.id);
		trackingPackageFake.setLastUpdate(trackingPackage.getLastUpdate());
		trackingPackageFake.setActivities(trackingPackage.getActivities());

		return trackingPackageFake;
	}
}
