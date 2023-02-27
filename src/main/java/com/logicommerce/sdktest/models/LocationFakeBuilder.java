package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.LocationBuilder;

public class LocationFakeBuilder<T> extends LocationBuilder<T> {

	public LocationFakeBuilder() {
		super();
		defaultValues();
	}

	public LocationFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.country = "country DEFAULT";
		super.locationId = 1;
		super.latitude = 0d;
		super.longitude = 0d;
		super.stateCode = "stateCode DEFAULT";
	}
}