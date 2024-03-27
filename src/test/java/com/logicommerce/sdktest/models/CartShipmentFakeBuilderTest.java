package com.logicommerce.sdktest.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.models.Address;
import com.logicommerce.sdk.models.CartShipment;

class CartShipmentFakeBuilderTest {

	private static final String ADDRESS = "123 Main St";
	private static final String CITY = "Anytown";
	private static final String STATE = "NY";
	private static final String POSTAL_CODE = "12345";
	private static final String COUNTRY = "US";
	private static final String MOBILE = "123-456-7890";
	private static final int LOCATION_ID = 123456;
	private static final double LATITUDE = 40.7128;
	private static final double LONGITUDE = -74.0060;

	@Test
	void testBuilderAddress() {
		// @formatter:off
		CartShipment cartShipment = new CartShipmentFakeBuilder()
			.logisticsCenterAddress()
				.address(ADDRESS)
				.city(CITY)
				.location()
					.latitude(LATITUDE)
					.longitude(LONGITUDE)
					.locationId(LOCATION_ID)
					.country(COUNTRY)
					.done()
				.state(STATE)
				.postalCode(POSTAL_CODE)
				.mobile(MOBILE)
				.done()
			.build();
		// @formatter:on

		Address address = cartShipment.getLogisticsCenterAddress();
		assertEquals(ADDRESS, address.getAddress());
		assertEquals(CITY, address.getCity());
		assertEquals(STATE, address.getState());
		assertEquals(POSTAL_CODE, address.getPostalCode());
		assertEquals(MOBILE, address.getMobile());
		assertEquals(LOCATION_ID, address.getLocation().getLocationId());
		assertEquals(LATITUDE, address.getLocation().getLatitude());
		assertEquals(LONGITUDE, address.getLocation().getLongitude());
		assertEquals(COUNTRY, address.getLocation().getCountry());
	}
}
