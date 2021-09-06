package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemOptionValueBuilder;
import com.logicommerce.sdk.models.order.OrderItemOptionValue;

public class OrderItemOptionValueFakeBuilder<T> extends OrderItemOptionValueBuilder<T> {

	public OrderItemOptionValueFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemOptionValueFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.id = 0;
		super.productOptionValueId = 0;
		super.sku = "sku DEFAULT";
		super.weight = 0d;
		super.price = 0d;
		super.previousPrice = 0d;
		super.value = "value DEFAULT";
		super.optionValuePId = "optionValuePId DEFAULT";
		super.noReturn = false;		
	}

	public OrderItemOptionValue build() {
		OrderItemOptionValue orderItemOptionValueSdk = super.build();
		OrderItemOptionValueFake optionValueFake = new OrderItemOptionValueFake();
		optionValueFake.setId(super.id);
		optionValueFake.setProductOptionValueId(orderItemOptionValueSdk.getProductOptionValueId());
		optionValueFake.setSku(orderItemOptionValueSdk.getSku());
		optionValueFake.setWeight(orderItemOptionValueSdk.getWeight());
		optionValueFake.setPrice(orderItemOptionValueSdk.getPrice());
		optionValueFake.setPreviousPrice(orderItemOptionValueSdk.getPreviousPrice());
		optionValueFake.setValue(orderItemOptionValueSdk.getValue());
		optionValueFake.setOptionValuePId(orderItemOptionValueSdk.getOptionValuePId());
		optionValueFake.setNoReturn(orderItemOptionValueSdk.isNoReturn());

		return optionValueFake;
	}

}
