package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Location;

public class LocationBuilder<T> {
	
	private T parentBuilder;

	private String country;

	private Integer locationId;

	private Double latitude;

	private Double longitude;
	
	public LocationBuilder() {
		country = "country DEFAULT";
		locationId = 1;
		latitude = 0d;
		longitude = 0d;
	}

	public LocationBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public LocationBuilder<T> country(String country) {
		this.country = country;
		return this;
	}
	
	public LocationBuilder<T> locationId(Integer locationId) {
		this.locationId = locationId;
		return this;
	}
	
	public LocationBuilder<T> latitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}
	
	public LocationBuilder<T> longitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}
	
	public Location build() {
		LocationFake location = new LocationFake();
		location.setCountry(country);
		location.setLocationId(locationId);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		return location;
	}

	public T done(){
		return parentBuilder;
	}
}
