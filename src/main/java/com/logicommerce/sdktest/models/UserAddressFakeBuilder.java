package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.UserAddress;

public class UserAddressFakeBuilder extends AddressBuilder<UserFakeBuilder, UserAddressFake> {

	private boolean defaultAddress;

	public UserAddressFakeBuilder(UserFakeBuilder userFakeBuilder) {
		super(userFakeBuilder);
	}

	public UserAddressFakeBuilder defaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
		return this;
	}

	@Override
	public UserAddress build() {
		UserAddressFake userAddress = new UserAddressFake();
		setElements(userAddress);
		userAddress.setDefaultAddress(defaultAddress);
		return userAddress;
	}

	@Override
	public UserAddressFakeBuilder returnThis() {
		return this;
	}

}
