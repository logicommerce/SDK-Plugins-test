package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderAdditionalInformationBuilder;

public class OrderAdditionalInformationFakeBuilder<T> extends OrderAdditionalInformationBuilder<T> {

	public OrderAdditionalInformationFakeBuilder() {
		super();
		defaultValues();		
	}

	public OrderAdditionalInformationFakeBuilder(T parentBuilder) {		
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.name = "name DEFAULT";
		super.value = "value DEFAULT";
	}
}