package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.CustomerView;

public class CustomerViewFakeBuilder<T> {

	private T parentBuilder;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;

	public CustomerViewFakeBuilder() {
		email = null;
		firstName = null;
		lastName = null;
		phone = null;
	}

	public CustomerViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CustomerViewFakeBuilder<T> email(String email) {
		this.email = email;
		return this;
	}

	public CustomerViewFakeBuilder<T> firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CustomerViewFakeBuilder<T> lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public CustomerViewFakeBuilder<T> phone(String phone) {
		this.phone = phone;
		return this;
	}

	public CustomerView build() {
		CustomerViewFake customerView = new CustomerViewFake();
		customerView.setEmail(email);
		customerView.setFirstName(firstName);
		customerView.setLastName(lastName);
		customerView.setPhone(phone);
		return customerView;
	}

	public T done() {
		return parentBuilder;
	}
}
