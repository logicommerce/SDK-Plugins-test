package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.AddressBuilder;

public class AddressFakeBuilder<T, S> extends AddressBuilder<T, S> {
	
	public AddressFakeBuilder() {
		super();
		defaultValues();
	}
	
	public AddressFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	public void defaultValues() {
		super.alias = "alias DEFAULT";
		super.firstName = "firstName DEFAULT";
		super.lastName = "lastName DEFAULT";
		super.companyy = "companyy DEFAULT";
		super.address = "address DEFAULT";
		super.addressAdditionalInformation = "addressAdditionalInformation DEFAULT";
		super.number = "number DEFAULT";
		super.city = "city DEFAULT";
		super.state = "state DEFAULT";
		super.postalCode = "postalCode DEFAULT";
		super.vat = "vat DEFAULT";
		super.nif = "nif DEFAULT";
		super.phone = "phone DEFAULT";
		super.mobile = "mobile DEFAULT";
		super.fax = "fax DEFAULT";
		super.name = "name DEFAULT";
		super.location = new LocationFakeBuilder<>(returnThis());
	}
}
