package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderDeliveryPhysicalLocation;
import com.logicommerce.sdktest.models.LocationBuilder;

public class OrderDeliveryPhysicalLocationBuilder<T> {

	private T parentBuilder;
	
	private int physicalLocationId;
	
	private String physicalLocationPId;
	
	private String name;
	
	private String address;
		
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private LocationBuilder<OrderDeliveryPhysicalLocationBuilder<T>> location;
	
	public OrderDeliveryPhysicalLocationBuilder() {		
		physicalLocationId = 1;
		physicalLocationPId = "test";
		name = "TEST name";
		address = "test address";
		city = "test city";
		state = "test state";
		postalCode = "test postalCode";
		location = new LocationBuilder<>(this);
	}
	
	public OrderDeliveryPhysicalLocationBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderDeliveryPhysicalLocationBuilder<T> physicalLocationId(int physicalLocationId) {
		this.physicalLocationId = physicalLocationId;
		return this;
	}
	
	public OrderDeliveryPhysicalLocationBuilder<T> physicalLocationPId(String physicalLocationPId) {
		this.physicalLocationPId = physicalLocationPId;
		return this;
	}
	
	public OrderDeliveryPhysicalLocationBuilder<T> name(String name) {
		this.name = name;
		return this;
	}
	
	public OrderDeliveryPhysicalLocationBuilder<T> address(String address) {
		this.address = address;
		return this;
	}
	
	public OrderDeliveryPhysicalLocationBuilder<T> city(String city) {
		this.city = city;
		return this;
	}

	public OrderDeliveryPhysicalLocationBuilder<T> state(String state) {
		this.state = state;
		return this;
	}

	public OrderDeliveryPhysicalLocationBuilder<T> postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public OrderDeliveryPhysicalLocationBuilder<T> postalCode(LocationBuilder<OrderDeliveryPhysicalLocationBuilder<T>> location) {
		this.location = location;
		return this;
	}
	
	public OrderDeliveryPhysicalLocation build() {
		OrderDeliveryPhysicalLocationFake orderDeliveryPhysicalLocation = new OrderDeliveryPhysicalLocationFake();
		orderDeliveryPhysicalLocation.setAddress(address);
		orderDeliveryPhysicalLocation.setCity(city);
		orderDeliveryPhysicalLocation.setLocation(location.build());
		orderDeliveryPhysicalLocation.setName(name);
		orderDeliveryPhysicalLocation.setPhysicalLocationId(physicalLocationId);
		orderDeliveryPhysicalLocation.setPhysicalLocationPId(physicalLocationPId);
		orderDeliveryPhysicalLocation.setPostalCode(postalCode);
		orderDeliveryPhysicalLocation.setState(state);
		
		return orderDeliveryPhysicalLocation;
	}
	
	public T done() {
		return parentBuilder;
	}
}