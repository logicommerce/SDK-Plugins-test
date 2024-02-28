package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.UserAddressBuilder;
import com.logicommerce.sdk.models.implementations.UserAddressImpl;

public class UserAddressFakeBuilder<T> extends UserAddressBuilder<T, UserAddressImpl> {

	public UserAddressFakeBuilder() {
		super();
		setDefaultvalues();
	}

	public UserAddressFakeBuilder(T userFakeBuilder) {
		super(userFakeBuilder);
		setDefaultvalues();
	}

	private void setDefaultvalues() {
		defaultAddress(false);
		alias("alias DEFAULT");
		firstName("firstName DEFAULT");
		lastName("lastName DEFAULT");
		company("company DEFAULT");
		addressAdditionalInformation("addressAdditionalInformation DEFAULT");
		number("number DEFAULT");
		nif("nif DEFAULT");
		vat("vat DEFAULT");
		tax(false);
		re(false);
	}

	@Override
	public UserAddressFakeBuilder<T> returnThis() {
		return this;
	}

}
