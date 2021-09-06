package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.LocationBuilder;
import com.logicommerce.sdk.builders.ShipmentAddressBuilder;
import com.logicommerce.sdk.models.order.ShipmentAddress;
import com.logicommerce.sdktest.models.LocationFakeBuilder;

public class ShipmentAddressFakeBuilder<T> extends ShipmentAddressBuilder<T> {

	public ShipmentAddressFakeBuilder() {
		super();
		defaultValues();
	}
	
	public ShipmentAddressFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.name = "test";
		super.address = "test address";
		super.city = "test city";
		super.state = "ES";
		super.postalCode = "08700";
		super.mobile = "666777882";
		super.phone = "666777882";
		super.email = "test@mail.test";
		super.location = new LocationFakeBuilder<>(this);
	}

	
	public LocationBuilder<ShipmentAddressBuilder<T>> location() {
		LocationBuilder<ShipmentAddressBuilder<T>> location = new LocationFakeBuilder<ShipmentAddressBuilder<T>>(this);
		super.location = location;
		return location;
	}

	public ShipmentAddress build() {
		ShipmentAddress shipmentAddress = super.build();
		ShipmentAddressFake shipmentAddressFake = new ShipmentAddressFake();		
		shipmentAddressFake.setAddress(shipmentAddress.getAddress());
		shipmentAddressFake.setCity(shipmentAddress.getCity());
		shipmentAddressFake.setEmail(shipmentAddress.getEmail());
		shipmentAddressFake.setLocation(shipmentAddress.getLocation());
		shipmentAddressFake.setMobile(shipmentAddress.getMobile());
		shipmentAddressFake.setName(shipmentAddress.getName());
		shipmentAddressFake.setMobile(shipmentAddress.getMobile());
		shipmentAddressFake.setPhone(shipmentAddress.getPhone());
		shipmentAddressFake.setPostalCode(shipmentAddress.getPostalCode());
		shipmentAddressFake.setState(shipmentAddress.getState());
		
		return shipmentAddressFake;
	}
}