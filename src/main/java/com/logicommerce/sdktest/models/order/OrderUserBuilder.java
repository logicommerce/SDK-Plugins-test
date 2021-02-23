package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.Gender;
import com.logicommerce.sdk.models.order.OrderUser;
import com.logicommerce.sdktest.models.UserAddressFakeBuilder;

public class OrderUserBuilder {

	private OrderBuilder parentBuilder;

	private String email;

	private Gender gender;

	private UserAddressFakeBuilder<OrderUserBuilder> billingAddress;

	private UserAddressFakeBuilder<OrderUserBuilder> shippingAddress;

	public OrderUserBuilder(OrderBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.email = "email DEFAULT";
		this.gender = Gender.FEMALE;
		this.billingAddress = new UserAddressFakeBuilder<>(this);
		this.shippingAddress = new UserAddressFakeBuilder<>(this);
	}

	public OrderUserBuilder email(String email) {
		this.email = email;
		return this;
	}

	public OrderUserBuilder gender(Gender gender) {
		this.gender = gender;
		return this;
	}
	
	public UserAddressFakeBuilder<OrderUserBuilder> billingAddress() {
		return billingAddress;
	}
	
	public UserAddressFakeBuilder<OrderUserBuilder> shippingAddress() {
		return shippingAddress;
	}

	public OrderUser build() {
		OrderUserFake user = new OrderUserFake();
		user.setEmail(email);
		user.setGender(gender);
		user.setBillingAddress(billingAddress.build());
		user.setShippingAddress(shippingAddress.build());
		return user;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
