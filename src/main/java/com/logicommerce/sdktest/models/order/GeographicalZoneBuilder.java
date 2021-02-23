package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.GeographicalZone;

public class GeographicalZoneBuilder<T> {

	private T parentBuilder;
	
	private int countryId;
	
	private int locationId;
	
	public GeographicalZoneBuilder() {
		countryId = 709;
		locationId = 1;
	}
	
	public GeographicalZoneBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public GeographicalZoneBuilder<T> countryId(int countryId) {
		this.countryId = countryId;
		return this;
	}
	
	public GeographicalZoneBuilder<T> locationId(int locationId) {
		this.locationId = locationId;
		return this;
	}
	
	public GeographicalZone build() {
		GeographicalZoneFake geographicalZone = new GeographicalZoneFake();		
		geographicalZone.setCountryId(countryId);
		geographicalZone.setLocationId(locationId);
		
		return geographicalZone;
	}
	
	public T done() {
		return parentBuilder;
	}
}
