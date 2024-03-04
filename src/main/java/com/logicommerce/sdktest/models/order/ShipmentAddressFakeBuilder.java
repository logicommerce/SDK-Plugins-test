package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.ShipmentAddressBuilder;
import com.logicommerce.sdk.models.order.ShipmentAddress;
import com.logicommerce.sdk.models.order.implementations.ShipmentAddressImpl;
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

	public ShipmentAddress build() {
		ShipmentAddress shipmentAddress = super.build();
		ShipmentAddressImpl shipmentAddressImpl = new ShipmentAddressImpl();
		shipmentAddressImpl.setAddress(shipmentAddress.getAddress());
		shipmentAddressImpl.setCity(shipmentAddress.getCity());
		shipmentAddressImpl.setEmail(shipmentAddress.getEmail());
		shipmentAddressImpl.setLocation(shipmentAddress.getLocation());
		shipmentAddressImpl.setMobile(shipmentAddress.getMobile());
		shipmentAddressImpl.setName(shipmentAddress.getName());
		shipmentAddressImpl.setMobile(shipmentAddress.getMobile());
		shipmentAddressImpl.setPhone(shipmentAddress.getPhone());
		shipmentAddressImpl.setPostalCode(shipmentAddress.getPostalCode());
		shipmentAddressImpl.setState(shipmentAddress.getState());
		return shipmentAddressImpl;
	}
}
