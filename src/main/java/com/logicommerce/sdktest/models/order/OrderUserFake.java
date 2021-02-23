package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.Gender;
import com.logicommerce.sdk.models.order.OrderUser;
import com.logicommerce.sdk.models.UserAddress;

public class OrderUserFake implements OrderUser {

	private String email;

	private Gender gender;

	private UserAddress billingAddress;

	private UserAddress shippingAddress;

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public UserAddress getBillingAddress() {
		return billingAddress;
	}

	@Override
	public UserAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setBillingAddress(UserAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public void setShippingAddress(UserAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
