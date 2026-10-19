package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.Allocation;

public class AllocationFakeBuilder<T> {

	private T parentBuilder;
	private int discountId;
	private long amount;

	public AllocationFakeBuilder() {
		discountId = 0;
		amount = 0;
	}

	public AllocationFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public AllocationFakeBuilder<T> discountId(int discountId) {
		this.discountId = discountId;
		return this;
	}

	public AllocationFakeBuilder<T> amount(long amount) {
		this.amount = amount;
		return this;
	}

	public Allocation build() {
		AllocationFake allocation = new AllocationFake();
		allocation.setDiscountId(discountId);
		allocation.setAmount(amount);
		return allocation;
	}

	public T done() {
		return parentBuilder;
	}
}
