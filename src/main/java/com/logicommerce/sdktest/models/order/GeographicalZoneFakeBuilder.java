package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.GeographicalZoneBuilder;

public class GeographicalZoneFakeBuilder<T> extends GeographicalZoneBuilder<T> {

	public GeographicalZoneFakeBuilder() {
		super();
		defaultValues();
	}

	public GeographicalZoneFakeBuilder(T parentBuilder) {		
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.countryId = 709;
		super.locationId = 1;
	}
}