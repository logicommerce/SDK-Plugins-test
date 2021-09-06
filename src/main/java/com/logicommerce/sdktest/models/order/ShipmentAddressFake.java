package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.models.order.ShipmentAddress;

public class ShipmentAddressFake implements ShipmentAddress {

	private String name;

	private String address;

	private String city;

	private String state;

	private String postalCode;

	private Location location;

	private String mobile;

	private String phone;

	private String email;

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
	public String getMobile() {
		return mobile;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getEmail() {
		return email;
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

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}