package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.implementations.UserAddressImpl;

@Deprecated
public class UserAddressFake extends UserAddressImpl {

	private boolean defaultAddress;

	@Override
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

}
