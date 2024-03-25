package com.logicommerce.sdktest.resources;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.resources.LocationResource;

public class LocationFake implements LocationResource {

	private List<Location> locationsPath = new ArrayList<>();

	private Integer languageId = 1;

	private static final String LANGUAGE_CODE = "ES";
	private static final String COUNTRY_CODE = "ES";
	private static final String COUNTRY_NAME = "España";
	private static final Integer COUNTRY_ID = 724;
	private static final String STATE_NAME = "Barcelona";
	private static final String STATE_CODE = "ES.56.B";

	@Override
	public Integer getCountryId(String countryCode) {
		return COUNTRY_ID;
	}

	@Override
	public String getCountryName(String countryCode) {
		return COUNTRY_NAME;
	}

	@Override
	public String getCountryCode(Integer countryId) {
		return COUNTRY_CODE;
	}

	@Override
	public String getLanguageCode(Integer languageId) {
		return LANGUAGE_CODE;
	}

	@Override
	public Integer getLanguageId(String languageCode) {
		return languageId;
	}

	@Override
	public List<Location> getLocationsPath(Integer languageId, Integer countryId, Integer locationId) {
		return locationsPath;
	}

	@Override
	public String getStateCode(Integer languageId, Integer countryId, Integer locationId) {
		return STATE_CODE;
	}

	@Override
	public String getStateName(Integer languageId, Integer countryId, Integer locationId) {
		return STATE_NAME;
	}

	@Override
	public List<Location> getLocations(String languageCode, String countryCode, String postalCode) {
		return List.of(locationsPath.get(0));
	}
}
