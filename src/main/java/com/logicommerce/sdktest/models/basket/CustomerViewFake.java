package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.CustomerView;

public class CustomerViewFake implements CustomerView {

	private String email;

	private String firstName;

	private String lastName;

	private String phone;

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
