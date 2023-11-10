package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.ShippingCalculation;
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
	private List<OrderItemTaxFakeBuilder<OrderShippingFakeBuilder<T>>> taxes;
	private List<OrderDiscountFakeBuilder<OrderShippingFakeBuilder<T>>> discounts;
	private OrderShippingTrackingFakeBuilder<OrderShippingFakeBuilder<T>> tracking;

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
	}

	public OrderShippingFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
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

	public OrderShippingTrackingFakeBuilder<OrderShippingFakeBuilder<T>> tracking() {
		var tracking = new OrderShippingTrackingFakeBuilder<OrderShippingFakeBuilder<T>>(this);
		this.tracking = tracking;
		return tracking;
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
		shippingFake.setTaxes(taxes.stream().map(OrderItemTaxFakeBuilder::build).collect(Collectors.toList()));
		shippingFake.setDiscounts(discounts.stream().map(OrderDiscountFakeBuilder::build).collect(Collectors.toList()));
		shippingFake.setTracking(tracking.build());
		return shippingFake;
	}

	public T done() {
		return parentBuilder;
	}
}
