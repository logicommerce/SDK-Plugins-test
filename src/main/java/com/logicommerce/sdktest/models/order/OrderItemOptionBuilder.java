package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.OptionValueType;
import com.logicommerce.sdk.models.order.OrderItemOption;

public class OrderItemOptionBuilder {

	private OrderItemBuilder parentBuilder;

	private Integer id;

	private List<OrderItemOptionValueBuilder> values;

	private Integer optionId;

	private Integer optionValueId;

	private String sku;

	private String name;

	private String prompt;

	private String value;

	private Double price;

	private double weight;

	private boolean uniquePrice;

	private OptionValueType valueType;

	private double previousPrice;

	private String productOptionPId;

	private boolean combinable;

	public OrderItemOptionBuilder() {
		id = 0;
		values = new ArrayList<>();
		optionId = 0;
		optionValueId = 0;
		sku = "sku DEFAULT";
		name = "name DEFAULT";
		prompt = "prompt DEFAULT";
		value = "value DEFAULT";
		price = 0d;
		weight = 0d;
		uniquePrice = false;
		valueType = OptionValueType.BOOLEAN;
		previousPrice = 0d;
		productOptionPId = "productOptionPId DEFAULT";
		combinable = false;
	}

	public OrderItemOptionBuilder(OrderItemBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemOptionBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemOptionValueBuilder optionValue() {
		OrderItemOptionValueBuilder optionValue = new OrderItemOptionValueBuilder(this);
		values.add(optionValue);
		return optionValue;
	}

	public OrderItemOptionBuilder optionId(Integer optionId) {
		this.optionId = optionId;
		return this;
	}

	public OrderItemOptionBuilder optionValueId(Integer optionValueId) {
		this.optionValueId = optionValueId;
		return this;
	}

	public OrderItemOptionBuilder sku(String sku) {
		this.sku = sku;
		return this;
	}

	public OrderItemOptionBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderItemOptionBuilder prompt(String prompt) {
		this.prompt = prompt;
		return this;
	}

	public OrderItemOptionBuilder value(String value) {
		this.value = value;
		return this;
	}

	public OrderItemOptionBuilder price(Double price) {
		this.price = price;
		return this;
	}

	public OrderItemOptionBuilder weight(double weight) {
		this.weight = weight;
		return this;
	}

	public OrderItemOptionBuilder uniquePrice(boolean uniquePrice) {
		this.uniquePrice = uniquePrice;
		return this;
	}

	public OrderItemOptionBuilder valueType(OptionValueType valueType) {
		this.valueType = valueType;
		return this;
	}

	public OrderItemOptionBuilder previousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
		return this;
	}

	public OrderItemOptionBuilder productOptionPId(String productOptionPId) {
		this.productOptionPId = productOptionPId;
		return this;
	}

	public OrderItemOptionBuilder combinable(boolean combinable) {
		this.combinable = combinable;
		return this;
	}

	public OrderItemOption build() {
		OrderItemOptionFake option = new OrderItemOptionFake();
		option.setId(id);
		option.setValues(values.stream().map(OrderItemOptionValueBuilder::build).collect(Collectors.toList()));
		option.setOptionId(optionId);
		option.setOptionValueId(optionValueId);
		option.setSku(sku);
		option.setName(name);
		option.setPrompt(prompt);
		option.setValue(value);
		option.setPrice(price);
		option.setWeight(weight);
		option.setUniquePrice(uniquePrice);
		option.setValueType(valueType);
		option.setPreviousPrice(previousPrice);
		option.setProductOptionPId(productOptionPId);
		option.setCombinable(combinable);
		return option;
	}

	public OrderItemBuilder done() {
		return parentBuilder;
	}

}
