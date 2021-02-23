package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderItemOptionValue;

public class OrderItemOptionValueBuilder {

	private OrderItemOptionBuilder parentBuilder;

	private Integer id;

	private Integer productOptionValueId;

	private String sku;

	private double weight;

	private double price;

	private double previousPrice;

	private String value;

	private String optionValuePId;

	private boolean noReturn;

	public OrderItemOptionValueBuilder() {
		id = 0;
		productOptionValueId = 0;
		sku = "sku DEFAULT";
		weight = 0d;
		price = 0d;
		previousPrice = 0d;
		value = "value DEFAULT";
		optionValuePId = "optionValuePId DEFAULT";
		noReturn = false;
	}

	public OrderItemOptionValueBuilder(OrderItemOptionBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemOptionValueBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemOptionValueBuilder productOptionValueId(Integer productOptionValueId) {
		this.productOptionValueId = productOptionValueId;
		return this;
	}

	public OrderItemOptionValueBuilder sku(String sku) {
		this.sku = sku;
		return this;
	}

	public OrderItemOptionValueBuilder weight(double weight) {
		this.weight = weight;
		return this;
	}

	public OrderItemOptionValueBuilder price(double price) {
		this.price = price;
		return this;
	}

	public OrderItemOptionValueBuilder previousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
		return this;
	}

	public OrderItemOptionValueBuilder value(String value) {
		this.value = value;
		return this;
	}

	public OrderItemOptionValueBuilder optionValuePId(String optionValuePId) {
		this.optionValuePId = optionValuePId;
		return this;
	}

	public OrderItemOptionValueBuilder noReturn(boolean noReturn) {
		this.noReturn = noReturn;
		return this;
	}

	public OrderItemOptionValue build() {
		OrderItemOptionValueFake optionValue = new OrderItemOptionValueFake();
		optionValue.setId(id);
		optionValue.setProductOptionValueId(productOptionValueId);
		optionValue.setSku(sku);
		optionValue.setWeight(weight);
		optionValue.setPrice(price);
		optionValue.setPreviousPrice(previousPrice);
		optionValue.setValue(value);
		optionValue.setOptionValuePId(optionValuePId);
		optionValue.setNoReturn(noReturn);
		return optionValue;
	}

	public OrderItemOptionBuilder done() {
		return parentBuilder;
	}

}
