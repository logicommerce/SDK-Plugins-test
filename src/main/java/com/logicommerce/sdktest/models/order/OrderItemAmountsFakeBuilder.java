package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.order.OrderItemAmounts;
import com.logicommerce.sdktest.models.basket.AllocationFakeBuilder;

public class OrderItemAmountsFakeBuilder<T> {

	private T parentBuilder;
	private String hash;
	private long unitPrice;
	private long subtotal;
	private List<AllocationFakeBuilder<OrderItemAmountsFakeBuilder<T>>> discounts;
	private long total;

	public OrderItemAmountsFakeBuilder() {
		hash = "hash DEFAULT";
		unitPrice = 0;
		subtotal = 0;
		discounts = new ArrayList<>();
		total = 0;
	}

	public OrderItemAmountsFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemAmountsFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderItemAmountsFakeBuilder<T> unitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public OrderItemAmountsFakeBuilder<T> subtotal(long subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public AllocationFakeBuilder<OrderItemAmountsFakeBuilder<T>> discount() {
		AllocationFakeBuilder<OrderItemAmountsFakeBuilder<T>> discount = new AllocationFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public OrderItemAmountsFakeBuilder<T> total(long total) {
		this.total = total;
		return this;
	}

	public OrderItemAmounts build() {
		OrderItemAmountsFake orderItemAmounts = new OrderItemAmountsFake();
		orderItemAmounts.setHash(hash);
		orderItemAmounts.setUnitPrice(unitPrice);
		orderItemAmounts.setSubtotal(subtotal);
		orderItemAmounts.setDiscounts(discounts.stream().map(AllocationFakeBuilder::build).collect(Collectors.toList()));
		orderItemAmounts.setTotal(total);
		return orderItemAmounts;
	}

	public T done() {
		return parentBuilder;
	}
}
