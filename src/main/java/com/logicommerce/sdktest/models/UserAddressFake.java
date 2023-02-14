package com.logicommerce.sdktest.models;

public class UserAddressFake extends AddressFake {

	private boolean defaultAddress;

	@Override
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

}
