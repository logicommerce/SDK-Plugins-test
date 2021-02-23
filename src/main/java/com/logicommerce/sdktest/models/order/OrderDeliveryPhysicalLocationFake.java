package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.models.order.OrderDeliveryPhysicalLocation;

public class OrderDeliveryPhysicalLocationFake implements OrderDeliveryPhysicalLocation {

	private int physicalLocationId;
	
	private String physicalLocationPId;
	
	private String name;
	
	private String address;
		
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private Location location;
	
	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPhysicalLocationId() {
		return physicalLocationId;
	}

	@Override
	public String getPhysicalLocationPId() {
		return physicalLocationPId;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String getState() {
		return state;
	}

	public void setPhysicalLocationId(int physicalLocationId) {
		this.physicalLocationId = physicalLocationId;
	}

	public void setPhysicalLocationPId(String physicalLocationPId) {
		this.physicalLocationPId = physicalLocationPId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}