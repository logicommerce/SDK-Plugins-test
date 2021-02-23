package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderAdditionalInformation;

public class OrderAdditionalInformationFake implements OrderAdditionalInformation {

	private String name;

	private String value;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
