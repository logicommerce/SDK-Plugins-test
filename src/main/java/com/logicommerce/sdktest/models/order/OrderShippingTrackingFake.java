package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;

import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.order.OrderShippingTracking;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackage;
import com.logicommerce.sdktest.models.ElementPropertyFake;

public class OrderShippingTrackingFake implements OrderShippingTracking {

	private Integer id;
	
	private String trackingNumber;

	private List<OrderShippingTrackingPackage> trackingPackages;

	private List<ElementProperty> properties;
	
	@Override
	public void addPackage(OrderShippingTrackingPackage trackingPackage) {
		if (trackingPackages == null) {
			trackingPackages = new ArrayList<>();
		}
		trackingPackages.add(trackingPackage);
	}

	@Override
	public void addProperty(ElementProperty property) {
		if (properties == null) {
			properties = new ArrayList<>();
		}
		properties.add(property);
	}

	@Override
	public void addProperty(String name, String value) {
		addProperty(new ElementPropertyFake(name, value));
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public List<ElementProperty> getProperties() {
		return properties;
	}

	@Override
	public String getTrackingNumber() {
		return trackingNumber;
	}

	@Override
	public List<OrderShippingTrackingPackage> getTrackingPackages() {
		return trackingPackages;
	}

	@Override
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setTrackingPackages(List<OrderShippingTrackingPackage> trackingPackages) {
		this.trackingPackages = trackingPackages;
	}

	public void setProperties(List<ElementProperty> properties) {
		this.properties = properties;
	}	
}