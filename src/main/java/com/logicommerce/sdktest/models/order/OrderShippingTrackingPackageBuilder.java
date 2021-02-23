package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.models.order.OrderShippingTrackingPackage;

public class OrderShippingTrackingPackageBuilder<T> {
	
	private T parentBuilder;
	
	private Integer id;

	private Double weight;

	private String weightUnits;

	private LocalDateTime lastUpdate;

	private List<OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>>> activities;
	
	public OrderShippingTrackingPackageBuilder() {
		this.id = 0;
		this.weight = 1d;
		this.weightUnits = "kg";
		this.lastUpdate  = LocalDateTime.now();
		this.activities = new ArrayList<>();		
	}
	
	public OrderShippingTrackingPackageBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShippingTrackingPackageBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShippingTrackingPackageBuilder<T> weight(Double weight) {
		this.weight = weight;
		return this;
	}

	public OrderShippingTrackingPackageBuilder<T> weightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
		return this;
	}

	public OrderShippingTrackingPackageBuilder<T> lastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}
	
	public OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>> activities() {
		OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>> activity = new OrderShippingTrackingPackageActivityBuilder<>(this);
		activities.add(activity);		
		return activity;
	}
	
	public OrderShippingTrackingPackage build() {
		OrderShippingTrackingPackageFake trackingPackage = new OrderShippingTrackingPackageFake();
		trackingPackage.setWeight(weight);
		trackingPackage.setWeightUnits(weightUnits);
		trackingPackage.setId(id);
		trackingPackage.setLastUpdate(lastUpdate);
		trackingPackage.setActivities(activities.stream().map(OrderShippingTrackingPackageActivityBuilder<OrderShippingTrackingPackageBuilder<T>>::build).collect(Collectors.toList()));
		
		return trackingPackage;
	}

	public T done() {
		return parentBuilder;
	}
}
