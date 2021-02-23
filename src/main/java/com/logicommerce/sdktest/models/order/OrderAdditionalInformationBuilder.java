package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderAdditionalInformation;

public class OrderAdditionalInformationBuilder {

	private OrderBuilder parentBuilder;

	private String name;

	private String value;

	public OrderAdditionalInformationBuilder() {
		name = "name DEFAULT";
		value = "value DEFAULT";
	}

	public OrderAdditionalInformationBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderAdditionalInformationBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderAdditionalInformationBuilder value(String value) {
		this.value = value;
		return this;
	}

	public OrderAdditionalInformation build() {
		OrderAdditionalInformationFake information = new OrderAdditionalInformationFake();
		information.setName(name);
		information.setValue(value);
		return information;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
