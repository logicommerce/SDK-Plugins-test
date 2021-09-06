package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderUserBuilder;
import com.logicommerce.sdk.enums.Gender;
import com.logicommerce.sdk.models.order.OrderUser;
import com.logicommerce.sdktest.models.AddressFakeBuilder;

public class OrderUserFakeBuilder<T> extends OrderUserBuilder<T> {
	
	public OrderUserFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.email = "email DEFAULT";
		super.gender = Gender.FEMALE;
		super.billingAddress = new AddressFakeBuilder<>(this);
		super.shippingAddress = new AddressFakeBuilder<>(this);
	}
	
	public OrderUser build() {
		OrderUser user = super.build();
		OrderUserFake userFake = new OrderUserFake();
		userFake.setEmail(user.getEmail());
		userFake.setGender(user.getGender());
		userFake.setBillingAddress(user.getBillingAddress());
		userFake.setShippingAddress(user.getShippingAddress());
		return userFake;
	}
}