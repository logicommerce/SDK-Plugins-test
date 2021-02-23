package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.AmountType;
import com.logicommerce.sdk.models.order.OrderPaymentSystem;

public class OrderPaymentSystemBuilder {

	private OrderBuilder parentBuilder;

	private Integer id;

	private int paymentSystemId;

	private List<OrderTaxBuilder<OrderPaymentSystemBuilder>> taxes;

	private String name;

	private AmountType increaseType;

	private double increaseValue;

	private double price;

	private double increaseMin;

	private boolean cashOnDelivery;

	private String property;

	public OrderPaymentSystemBuilder() {
		id = 0;
		paymentSystemId = 0;
		taxes = new ArrayList<>();
		name = "name DEFAULT";
		increaseType = AmountType.ABSOLUTE;
		increaseValue = 0d;
		price = 0d;
		increaseMin = 0d;
		cashOnDelivery = false;
		property = "";
	}

	public OrderPaymentSystemBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}


	public OrderPaymentSystemBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderPaymentSystemBuilder paymentSystemId(int paymentSystemId) {
		this.paymentSystemId = paymentSystemId;
		return this;
	}

	public OrderTaxBuilder<OrderPaymentSystemBuilder> tax() {
		OrderTaxBuilder<OrderPaymentSystemBuilder> tax = new OrderTaxBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderPaymentSystemBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderPaymentSystemBuilder increaseType(AmountType increaseType) {
		this.increaseType = increaseType;
		return this;
	}

	public OrderPaymentSystemBuilder increaseValue(double increaseValue) {
		this.increaseValue = increaseValue;
		return this;
	}

	public OrderPaymentSystemBuilder price(double price) {
		this.price = price;
		return this;
	}

	public OrderPaymentSystemBuilder increaseMin(double increaseMin) {
		this.increaseMin = increaseMin;
		return this;
	}

	public OrderPaymentSystemBuilder cashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
		return this;
	}

	public OrderPaymentSystemBuilder property(String property) {
		this.property = property;
		return this;
	}

	public OrderPaymentSystem build() {
		OrderPaymentSystemFake paymentSystem = new OrderPaymentSystemFake();
		paymentSystem.setId(id);
		paymentSystem.setPaymentSystemId(paymentSystemId);
		paymentSystem.setTaxes(taxes.stream().map(OrderTaxBuilder::build).collect(Collectors.toList()));
		paymentSystem.setName(name);
		paymentSystem.setIncreaseType(increaseType);
		paymentSystem.setIncreaseValue(increaseValue);
		paymentSystem.setPrice(price);
		paymentSystem.setIncreaseMin(increaseMin);
		paymentSystem.setCashOnDelivery(cashOnDelivery);
		paymentSystem.setProperty(property);
		return paymentSystem;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
