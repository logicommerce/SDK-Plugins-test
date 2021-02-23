package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.enums.ShippingCalculation;
import com.logicommerce.sdk.models.order.OrderShipping;

public class OrderShippingBuilder<T> {

	private OrderShipmentBuilder<T> parentBuilder;

	private Integer id;

	private int shippingTypeId;

	private String name;

	private Double price;

	private String shippingTypeName;

	private Integer shippingSectionId;

	private ShippingCalculation shippingCalculation;

	private String shipperPId;

	private String shippingTypePId;

	private boolean cashOnDelivery;

	private List<OrderItemTaxBuilder<OrderShippingBuilder<T>>> taxes;

	private List<OrderDiscountBuilder<OrderShippingBuilder<T>>> discounts;

	private OrderShippingTrackingBuilder<OrderShippingBuilder<T>> tracking;

	public OrderShippingBuilder() {
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
		taxes = new ArrayList<>();
		discounts = new ArrayList<>();
		tracking = new OrderShippingTrackingBuilder<>(this);
	}

	public OrderShippingBuilder(OrderShipmentBuilder<T> parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShippingBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShippingBuilder<T> shippingTypeId(int shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
		return this;
	}

	public OrderShippingBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OrderShippingBuilder<T> price(Double price) {
		this.price = price;
		return this;
	}

	public OrderShippingBuilder<T> shippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
		return this;
	}

	public OrderShippingBuilder<T> shippingSectionId(Integer shippingSectionId) {
		this.shippingSectionId = shippingSectionId;
		return this;
	}

	public OrderShippingBuilder<T> shippingCalculation(ShippingCalculation shippingCalculation) {
		this.shippingCalculation = shippingCalculation;
		return this;
	}

	public OrderShippingBuilder<T> shipperPId(String shipperPId) {
		this.shipperPId = shipperPId;
		return this;
	}

	public OrderShippingBuilder<T> shippingTypePId(String shippingTypePId) {
		this.shippingTypePId = shippingTypePId;
		return this;
	}

	public OrderShippingBuilder<T> cashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
		return this;
	}

	public OrderItemTaxBuilder<OrderShippingBuilder<T>> tax() {
		OrderItemTaxBuilder<OrderShippingBuilder<T>> tax = new OrderItemTaxBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderDiscountBuilder<OrderShippingBuilder<T>> discount() {
		OrderDiscountBuilder<OrderShippingBuilder<T>> discount = new OrderDiscountBuilder<>(this);
		discounts.add(discount);
		return discount;
	}
	
	public OrderShippingTrackingBuilder<OrderShippingBuilder<T>> tracking() {
		OrderShippingTrackingBuilder<OrderShippingBuilder<T>> tracking = new OrderShippingTrackingBuilder<>(this); 
		//this.tracking = tracking;
		return tracking;
	}
	
	public OrderShipping build() {
		OrderShippingFake shipping = new OrderShippingFake();
		shipping.setId(id);
		shipping.setShippingTypeId(shippingTypeId);
		shipping.setName(name);
		shipping.setPrice(price);
		shipping.setShippingTypeName(shippingTypeName);
		shipping.setShippingSectionId(shippingSectionId);
		shipping.setShippingCalculation(shippingCalculation);
		shipping.setShipperPId(shipperPId);
		shipping.setShippingTypePId(shippingTypePId);
		shipping.setCashOnDelivery(cashOnDelivery);
		shipping.setTaxes(taxes.stream().map(OrderItemTaxBuilder::build).collect(Collectors.toList()));
		shipping.setDiscounts(discounts.stream().map(OrderDiscountBuilder::build).collect(Collectors.toList()));
		shipping.setTracking(tracking.build());
		return shipping;
	}

	public OrderShipmentBuilder<T> done() {
		return parentBuilder;
	}
}