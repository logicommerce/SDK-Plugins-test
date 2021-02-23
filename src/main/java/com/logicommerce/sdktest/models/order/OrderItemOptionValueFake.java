package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderItemOptionValue;

public class OrderItemOptionValueFake implements OrderItemOptionValue {

	private Integer id;

	private Integer productOptionValueId;

	private String sku;

	private double weight;

	private double price;

	private double previousPrice;

	private String value;

	private String optionValuePId;

	private boolean noReturn;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public Integer getProductOptionValueId() {
		return productOptionValueId;
	}

	@Override
	public String getSku() {
		return sku;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getPreviousPrice() {
		return previousPrice;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getOptionValuePId() {
		return optionValuePId;
	}

	@Override
	public boolean isNoReturn() {
		return noReturn;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProductOptionValueId(Integer productOptionValueId) {
		this.productOptionValueId = productOptionValueId;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPreviousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setOptionValuePId(String optionValuePId) {
		this.optionValuePId = optionValuePId;
	}

	public void setNoReturn(boolean noReturn) {
		this.noReturn = noReturn;
	}

}
