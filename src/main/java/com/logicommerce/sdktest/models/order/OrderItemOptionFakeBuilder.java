package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemOptionBuilder;
import com.logicommerce.sdk.enums.OptionValueType;
import com.logicommerce.sdk.models.order.OrderItemOption;

public class OrderItemOptionFakeBuilder<T> extends OrderItemOptionBuilder<T> {

	public OrderItemOptionFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemOptionFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		this.id = 0;
		super.optionId = 0;
		super.optionValueId = 0;
		super.sku = "sku DEFAULT";
		super.name = "name DEFAULT";
		super.prompt = "prompt DEFAULT";
		super.value = "value DEFAULT";
		super.price = 0d;
		super.weight = 0d;
		super.uniquePrice = false;
		super.valueType = OptionValueType.BOOLEAN;
		super.previousPrice = 0d;
		super.productOptionPId = "productOptionPId DEFAULT";
		super.combinable = false;
	}
	
	@Override
	public OrderItemOptionValueFakeBuilder<OrderItemOptionBuilder<T>> optionValue() {
		OrderItemOptionValueFakeBuilder<OrderItemOptionBuilder<T>> optionValue = new OrderItemOptionValueFakeBuilder<>(this);
		super.values.add(optionValue);
		return optionValue;
	}

	public OrderItemOption build() {
		OrderItemOption optionSdk = super.build();
		OrderItemOptionFake optionFake = new OrderItemOptionFake();
		optionFake.setId(super.id);
		optionFake.setValues(optionSdk.getValues());
		optionFake.setOptionId(optionSdk.getOptionId());
		optionFake.setOptionValueId(optionSdk.getOptionValueId());
		optionFake.setSku(optionSdk.getSku());
		optionFake.setName(optionSdk.getName());
		optionFake.setPrompt(optionSdk.getPrompt());
		optionFake.setValue(optionSdk.getValue());
		optionFake.setPrice(optionSdk.getPrice());
		optionFake.setWeight(optionSdk.getWeight());
		optionFake.setUniquePrice(optionSdk.isUniquePrice());
		optionFake.setValueType(optionSdk.getValueType());
		optionFake.setPreviousPrice(optionSdk.getPreviousPrice());
		optionFake.setProductOptionPId(optionSdk.getProductOptionPId());
		optionFake.setCombinable(optionSdk.isCombinable());
		return optionFake;
	}
}