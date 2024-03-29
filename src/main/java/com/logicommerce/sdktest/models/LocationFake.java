package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Location;

public class LocationFake implements Location {

	private String country;

	private Integer locationId;

	private Double latitude;

	private Double longitude;

	private String stateCode;

	private String name;

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public Integer getLocationId() {
		return locationId;
	}

	@Override
	public Double getLatitude() {
		return latitude;
	}

	@Override
	public Double getLongitude() {
		return longitude;
	}

	@Override
	public String getStateCode() {
		return stateCode;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setName(String name) {
		this.name = name;
	}
}
