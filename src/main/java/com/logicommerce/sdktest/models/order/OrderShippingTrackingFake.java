package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.order.OrderShippingTracking;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackage;
import com.logicommerce.sdktest.models.ElementPropertyFake;

public class OrderShippingTrackingFake implements OrderShippingTracking {

	private Integer id;

	private List<OrderShippingTrackingPackage> packages;

	private List<ElementProperty> properties;

	private String trackingReference;

	@Override
	public void addPackage(OrderShippingTrackingPackage trackingPackage) {
		if (packages == null) {
			packages = new ArrayList<>();
		}
		packages.add(trackingPackage);
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
	public List<OrderShippingTrackingPackage> getPackages() {
		return packages;
	}

	public void setTrackingPackages(List<OrderShippingTrackingPackage> trackingPackages) {
		this.packages = trackingPackages;
	}

	public void setProperties(List<ElementProperty> properties) {
		this.properties = properties;
	}

	@Override
	public String getTrackingReference() {
		return trackingReference;
	}

	@Override
	public void setTrackingReference(String trackingReference) {
		this.trackingReference = trackingReference;
	}
}