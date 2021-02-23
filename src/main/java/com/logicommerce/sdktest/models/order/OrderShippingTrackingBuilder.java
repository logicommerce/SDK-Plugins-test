package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.models.order.OrderShippingTracking;
import com.logicommerce.sdktest.models.ElementPropertyBuilder;

public class OrderShippingTrackingBuilder<T>{
	
	private T parentBuilder;
	
	private Integer id;
	
	private String trackingNumber;

	private List<OrderShippingTrackingPackageBuilder<OrderShippingTrackingBuilder<T>>> trackingPackages;

	private List<ElementPropertyBuilder<OrderShippingTrackingBuilder<T>>> properties;
	
	public OrderShippingTrackingBuilder() {
		id = 0;
		trackingNumber = "0001";
		trackingPackages = new ArrayList<>();
		properties = new ArrayList<>();
	}
	
	public OrderShippingTrackingBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public OrderShippingTrackingBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}
	
	public OrderShippingTrackingBuilder<T> trackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}
	
	public OrderShippingTrackingPackageBuilder<OrderShippingTrackingBuilder<T>> trackingPackages() {
		OrderShippingTrackingPackageBuilder<OrderShippingTrackingBuilder<T>> trackingPackage = new OrderShippingTrackingPackageBuilder<>(this);
		trackingPackages.add(trackingPackage);		
		return trackingPackage;
	}

	public ElementPropertyBuilder<OrderShippingTrackingBuilder<T>> properties() {
		ElementPropertyBuilder<OrderShippingTrackingBuilder<T>> property = new ElementPropertyBuilder<>(this);
		properties.add(property);		
		return property;
	}

	public OrderShippingTracking build() {
		OrderShippingTrackingFake tracking = new OrderShippingTrackingFake();
		tracking.setTrackingNumber(trackingNumber);
		tracking.setId(id);
		tracking.setProperties(properties.stream().map(ElementPropertyBuilder<OrderShippingTrackingBuilder<T>>::build).collect(Collectors.toList()));
		tracking.setTrackingPackages(trackingPackages.stream().map(OrderShippingTrackingPackageBuilder<OrderShippingTrackingBuilder<T>>::build).collect(Collectors.toList()));
		
		return tracking;
	}

	public T done() {
		return parentBuilder;
	}
}
