package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.UserAddress;

public class UserAddressFake extends AddressFake implements UserAddress {

	private boolean defaultAddress;

	@Override
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

}
