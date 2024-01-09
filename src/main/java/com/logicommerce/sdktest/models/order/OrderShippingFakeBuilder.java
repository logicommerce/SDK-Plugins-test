package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.ShippingCalculation;
import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.ElementProperyImpl;
import com.logicommerce.sdk.models.order.OrderShipping;

public class OrderShippingFakeBuilder<T> {

	private T parentBuilder;
	private Integer id;
	private int shippingTypeId;
	private String name;
	private Double price;
	private String shippingTypeName;
	private Integer shippingSectionId;
	private ShippingCalculation shippingCalculation;
	private String shipperPId;
	private int shipperId;
	private String shippingTypePId;
	private boolean cashOnDelivery;
	private OrderShippingTrackingFakeBuilder<OrderShippingFakeBuilder<T>> tracking;
	private List<OrderItemTaxFakeBuilder<OrderShippingFakeBuilder<T>>> taxes;
	private List<OrderDiscountFakeBuilder<OrderShippingFakeBuilder<T>>> discounts;
	private List<ElementProperty> properties;

	public OrderShippingFakeBuilder() {
		id = 0;
		shippingTypeId = 0;
		name = "name DEFAULT";
		price = 0d;
		shippingTypeName = "shippingTypeName DEFAULT";
		shippingSectionId = 0;
		shippingCalculation = ShippingCalculation.BY_WEIGHT;
		shipperPId = "shipperPId DEFAULT";
		shippingTypePId = "shippingTypePId DEFAULT";
		cashOnDelivery = false;
		tracking = new OrderShippingTrackingFakeBuilder<>(this);
		taxes = new ArrayList<>();
		discounts = new ArrayList<>();
		properties = new ArrayList<>();
	}

	public OrderShippingFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShippingFakeBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShippingFakeBuilder<T> shippingTypeId(int shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
		return this;
	}

	public OrderShippingFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OrderShippingFakeBuilder<T> price(Double price) {
		this.price = price;
		return this;
	}

	public OrderShippingFakeBuilder<T> shippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
		return this;
	}

	public OrderShippingFakeBuilder<T> shippingSectionId(Integer shippingSectionId) {
		this.shippingSectionId = shippingSectionId;
		return this;
	}

	public OrderShippingFakeBuilder<T> shippingCalculation(ShippingCalculation shippingCalculation) {
		this.shippingCalculation = shippingCalculation;
		return this;
	}

	public OrderShippingFakeBuilder<T> shipperPId(String shipperPId) {
		this.shipperPId = shipperPId;
		return this;
	}

	public OrderShippingFakeBuilder<T> shipperId(int shipperId) {
		this.shipperId = shipperId;
		return this;
	}

	public OrderShippingFakeBuilder<T> shippingTypePId(String shippingTypePId) {
		this.shippingTypePId = shippingTypePId;
		return this;
	}

	public OrderShippingFakeBuilder<T> cashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
		return this;
	}

	public OrderShippingTrackingFakeBuilder<OrderShippingFakeBuilder<T>> tracking() {
		return tracking;
	}

	public OrderItemTaxFakeBuilder<OrderShippingFakeBuilder<T>> tax() {
		var tax = new OrderItemTaxFakeBuilder<OrderShippingFakeBuilder<T>>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderDiscountFakeBuilder<OrderShippingFakeBuilder<T>> discount() {
		var discount = new OrderDiscountFakeBuilder<OrderShippingFakeBuilder<T>>(this);
		discounts.add(discount);
		return discount;
	}

	public OrderShippingFakeBuilder<T> property(String name, String value) {
		properties.add(new ElementProperyImpl(name, value));
		return this;
	}

	public OrderShipping build() {
		OrderShippingFake shippingFake = new OrderShippingFake();
		shippingFake.setId(id);
		shippingFake.setShippingTypeId(shippingTypeId);
		shippingFake.setName(name);
		shippingFake.setPrice(price);
		shippingFake.setShippingTypeName(shippingTypeName);
		shippingFake.setShippingSectionId(shippingSectionId);
		shippingFake.setShippingCalculation(shippingCalculation);
		shippingFake.setShipperId(shipperId);
		shippingFake.setShipperPId(shipperPId);
		shippingFake.setShippingTypePId(shippingTypePId);
		shippingFake.setCashOnDelivery(cashOnDelivery);
		shippingFake.setTracking(tracking.build());
		shippingFake.setTaxes(taxes.stream().map(OrderItemTaxFakeBuilder::build).collect(Collectors.toList()));
		shippingFake.setDiscounts(discounts.stream().map(OrderDiscountFakeBuilder::build).collect(Collectors.toList()));
		shippingFake.setProperties(properties);
		return shippingFake;
	}

	public T done() {
		return parentBuilder;
	}
}
