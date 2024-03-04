package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartWarehouse;
import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.models.implementations.AddressImpl;

public class CartWarehouseFake extends AddressImpl implements CartWarehouse {

	private String address;

	private String city;

	private String country;

	private String name;

	private String state;

	private String postalCode;

	private Integer physicalLocationId;

	private int offsetDays;

	private boolean needsShipping;

	private String phone;

	private String mobile;

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public Integer getPhysicalLocationId() {
		return physicalLocationId;
	}

	@Override
	public int getOffsetDays() {
		return offsetDays;
	}

	@Override
	public boolean needsShipping() {
		return needsShipping;
	}

	@Override
	public Location getLocation() {
		return new LocationFake();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPhysicalLocationId(Integer physicalLocationId) {
		this.physicalLocationId = physicalLocationId;
	}

	public void setOffsetDays(int offsetDays) {
		this.offsetDays = offsetDays;
	}

	public void setNeedsShipping(boolean needsShipping) {
		this.needsShipping = needsShipping;
	}

}
