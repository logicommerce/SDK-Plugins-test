package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackageActivity;
import com.logicommerce.sdktest.models.ElementPropertyFake;

public class OrderShippingTrackingPackageActivityFake implements OrderShippingTrackingPackageActivity {

	private Integer id;
	
	private LocalDateTime dateTime;

	private String description;

	private String status;

	private List<ElementProperty> properties;
	
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
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public List<ElementProperty> getProperties() {
		return properties;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setProperties(List<ElementProperty> properties) {
		this.properties = properties;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}
}