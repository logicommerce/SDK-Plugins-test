package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.GeographicalZone;

public class GeographicalZoneFake implements GeographicalZone{
	
	private int countryId;	
	
	private int locationId;
	
	@Override
	public int getCountryId() {
		return countryId;
	}

	@Override
	public int getLocationId() {
		return locationId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
}