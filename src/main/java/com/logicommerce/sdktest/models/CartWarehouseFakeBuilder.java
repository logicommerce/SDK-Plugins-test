package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartWarehouse;

public class CartWarehouseFakeBuilder {

	private CartShipmentFakeBuilder parentBuilder;

	private String address;

	private String city;

	private String country;

	private String name;

	private String state;

	private int locationId;

	private String postalCode;

	private Integer physicalLocationId;

	private int offsetDays;

	private boolean needsShipping;

	public CartWarehouseFakeBuilder() {
		address = "address DEFAULT";
		city = "city DEFAULT";
		country = "country DEFAULT";
		name = "name DEFAULT";
		state = "state DEFAULT";
		locationId = 0;
		postalCode = "postalCode DEFAULT";
		physicalLocationId = 0;
		offsetDays = 0;
		needsShipping = true;
	}

	public CartWarehouseFakeBuilder(CartShipmentFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartWarehouseFakeBuilder address(String address) {
		this.address = address;
		return this;
	}

	public CartWarehouseFakeBuilder city(String city) {
		this.city = city;
		return this;
	}

	public CartWarehouseFakeBuilder country(String country) {
		this.country = country;
		return this;
	}

	public CartWarehouseFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CartWarehouseFakeBuilder state(String state) {
		this.state = state;
		return this;
	}

	public CartWarehouseFakeBuilder locationId(int locationId) {
		this.locationId = locationId;
		return this;
	}

	public CartWarehouseFakeBuilder postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public CartWarehouseFakeBuilder physicalLocationId(Integer physicalLocationId) {
		this.physicalLocationId = physicalLocationId;
		return this;
	}

	public CartWarehouseFakeBuilder offsetDays(int offsetDays) {
		this.offsetDays = offsetDays;
		return this;
	}

	public CartWarehouseFakeBuilder needsShipping(boolean needsShipping) {
		this.needsShipping = needsShipping;
		return this;
	}

	public CartWarehouse build() {
		CartWarehouseFake warehouse = new CartWarehouseFake();
		warehouse.setAddress(address);
		warehouse.setCity(city);
		warehouse.setCountry(country);
		warehouse.setName(name);
		warehouse.setState(state);
		warehouse.setLocationId(locationId);
		warehouse.setPostalCode(postalCode);
		warehouse.setPhysicalLocationId(physicalLocationId);
		warehouse.setOffsetDays(offsetDays);
		warehouse.setNeedsShipping(needsShipping);
		return warehouse;
	}

	public CartShipmentFakeBuilder done() {
		return parentBuilder;
	}
}
