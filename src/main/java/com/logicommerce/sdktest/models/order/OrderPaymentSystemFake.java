package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.enums.AmountType;
import com.logicommerce.sdk.enums.ConversionMode;
import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.order.DocumentConversionCurrency;
import com.logicommerce.sdk.models.order.OrderPaymentSystem;
import com.logicommerce.sdk.models.order.OrderTax;
import com.logicommerce.sdktest.models.ElementPropertyFake;

public class OrderPaymentSystemFake implements OrderPaymentSystem {

	private Integer id;

	private int paymentSystemId;

	private List<OrderTax> taxes;

	private String name;

	private AmountType increaseType;

	private double increaseValue;

	private double price;

	private double increaseMin;

	private boolean cashOnDelivery;

	private String property;
	
	List<ElementProperty> properties;

	private ConversionMode conversionMode;

	private List<DocumentConversionCurrency> conversionCurrencies;

	@Override
	public Integer getId() {
	  return id;
	}

	@Override
	public int getPaymentSystemId() {
	  return paymentSystemId;
	}

	@Override
	public List<OrderTax> getTaxes() {
	  return taxes;
	}

	@Override
	public String getName() {
	  return name;
	}

	@Override
	public AmountType getIncreaseType() {
	  return increaseType;
	}

	@Override
	public double getIncreaseValue() {
	  return increaseValue;
	}

	@Override
	public double getPrice() {
	  return price;
	}

	@Override
	public double getIncreaseMin() {
	  return increaseMin;
	}

	@Override
	public boolean isCashOnDelivery() {
	  return cashOnDelivery;
	}

	@Override
	public String getProperty() {
		return property;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPaymentSystemId(int paymentSystemId) {
		this.paymentSystemId = paymentSystemId;
	}

	public void setTaxes(List<OrderTax> taxes) {
		this.taxes = taxes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIncreaseType(AmountType increaseType) {
		this.increaseType = increaseType;
	}

	public void setIncreaseValue(double increaseValue) {
		this.increaseValue = increaseValue;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setIncreaseMin(double increaseMin) {
		this.increaseMin = increaseMin;
	}

	public void setCashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public List<ElementProperty> getProperties() {
		return properties;
	}

	@Override
	public void addProperty(ElementProperty property) {
		if (properties == null) {
			properties = new ArrayList<>();
		}
		properties.add(property);
	}

	@Override
	public void addProperty(String name, String value) {
		addProperty(new ElementPropertyFake(name, value));
	}

	@Override
	public ConversionMode getConversionMode() {
		return conversionMode;
	}

	public void setConversionMode(ConversionMode conversionMode) {
		this.conversionMode = conversionMode;
	}

	@Override
	public List<DocumentConversionCurrency> getConversionCurrencies() {
		return conversionCurrencies;
	}

	public void setConversionCurrencies(List<DocumentConversionCurrency> conversionCurrencies) {
		this.conversionCurrencies = conversionCurrencies;
	}

}
