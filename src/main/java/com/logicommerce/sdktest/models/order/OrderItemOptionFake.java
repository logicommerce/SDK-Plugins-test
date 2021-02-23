package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.OptionValueType;
import com.logicommerce.sdk.models.order.OrderItemOption;
import com.logicommerce.sdk.models.order.OrderItemOptionValue;

public class OrderItemOptionFake implements OrderItemOption {

	private Integer id;

	private List<OrderItemOptionValue> values;

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

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public List<OrderItemOptionValue> getValues() {
		return values;
	}

	@Override
	public Integer getOptionId() {
		return optionId;
	}

	@Override
	public Integer getOptionValueId() {
		return optionValueId;
	}

	@Override
	public String getSku() {
		return sku;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public boolean isUniquePrice() {
		return uniquePrice;
	}

	@Override
	public OptionValueType getValueType() {
		return valueType;
	}

	@Override
	public double getPreviousPrice() {
		return previousPrice;
	}

	@Override
	public String getProductOptionPId() {
		return productOptionPId;
	}

	@Override
	public boolean isCombinable() {
		return combinable;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValues(List<OrderItemOptionValue> values) {
		this.values = values;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public void setOptionValueId(Integer optionValueId) {
		this.optionValueId = optionValueId;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setUniquePrice(boolean uniquePrice) {
		this.uniquePrice = uniquePrice;
	}

	public void setValueType(OptionValueType valueType) {
		this.valueType = valueType;
	}

	public void setPreviousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
	}

	public void setProductOptionPId(String productOptionPId) {
		this.productOptionPId = productOptionPId;
	}

	public void setCombinable(boolean combinable) {
		this.combinable = combinable;
	}

}
