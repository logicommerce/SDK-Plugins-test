package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.AddressBuilder;
import com.logicommerce.sdk.models.implementations.AddressImpl;

public class AddressFakeBuilder<T> extends AddressBuilder<T> {

	public AddressFakeBuilder() {
		super();
		defaultValues();
	}

	public AddressFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	protected void defaultValues() {
		super.address = "address DEFAULT";
		super.addressAdditionalInformation = "addressAdditionalInformation DEFAULT";
		super.number = "number DEFAULT";
		super.city = "city DEFAULT";
		super.state = "state DEFAULT";
		super.postalCode = "postalCode DEFAULT";
		super.phone = "phone DEFAULT";
		super.mobile = "mobile DEFAULT";
		super.name = "name DEFAULT";
		super.location = new LocationFakeBuilder<>(returnThis());
	}

	public AddressImpl build() {
		AddressImpl addressImpl = new AddressImpl();
		setElements(addressImpl);
		return addressImpl;
	}

	protected AddressFakeBuilder<T> returnThis() {
		return this;
	}
}
