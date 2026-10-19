package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderRMAItem;

public class OrderRMAItemFakeBuilder<T> {

	private T parentBuilder;
	private String hash;
	private int quantity;

	public OrderRMAItemFakeBuilder() {
		hash = "hash DEFAULT";
		quantity = 0;
	}

	public OrderRMAItemFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderRMAItemFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderRMAItemFakeBuilder<T> quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderRMAItem build() {
		OrderRMAItemFake orderRMAItem = new OrderRMAItemFake();
		orderRMAItem.setHash(hash);
		orderRMAItem.setQuantity(quantity);
		return orderRMAItem;
	}

	public T done() {
		return parentBuilder;
	}
}
