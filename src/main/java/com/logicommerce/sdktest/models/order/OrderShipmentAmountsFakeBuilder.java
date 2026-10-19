package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.order.OrderShipmentAmounts;
import com.logicommerce.sdktest.models.basket.AllocationFakeBuilder;

public class OrderShipmentAmountsFakeBuilder<T> {

	private T parentBuilder;
	private int shipmentId;
	private long shippingPrice;
	private List<AllocationFakeBuilder<OrderShipmentAmountsFakeBuilder<T>>> shippingDiscounts;

	public OrderShipmentAmountsFakeBuilder() {
		shipmentId = 0;
		shippingPrice = 0;
		shippingDiscounts = new ArrayList<>();
	}

	public OrderShipmentAmountsFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShipmentAmountsFakeBuilder<T> shipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public OrderShipmentAmountsFakeBuilder<T> shippingPrice(long shippingPrice) {
		this.shippingPrice = shippingPrice;
		return this;
	}

	public AllocationFakeBuilder<OrderShipmentAmountsFakeBuilder<T>> shippingDiscount() {
		AllocationFakeBuilder<OrderShipmentAmountsFakeBuilder<T>> shippingDiscount = new AllocationFakeBuilder<>(this);
		shippingDiscounts.add(shippingDiscount);
		return shippingDiscount;
	}

	public OrderShipmentAmounts build() {
		OrderShipmentAmountsFake orderShipmentAmounts = new OrderShipmentAmountsFake();
		orderShipmentAmounts.setShipmentId(shipmentId);
		orderShipmentAmounts.setShippingPrice(shippingPrice);
		orderShipmentAmounts.setShippingDiscounts(shippingDiscounts.stream().map(AllocationFakeBuilder::build).collect(Collectors.toList()));
		return orderShipmentAmounts;
	}

	public T done() {
		return parentBuilder;
	}
}
