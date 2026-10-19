package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.RowAllocation;

public class RowAllocationFakeBuilder<T> {

	private T parentBuilder;
	private String rowHash;
	private long amount;

	public RowAllocationFakeBuilder() {
		rowHash = "rowHash DEFAULT";
		amount = 0;
	}

	public RowAllocationFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public RowAllocationFakeBuilder<T> rowHash(String rowHash) {
		this.rowHash = rowHash;
		return this;
	}

	public RowAllocationFakeBuilder<T> amount(long amount) {
		this.amount = amount;
		return this;
	}

	public RowAllocation build() {
		RowAllocationFake rowAllocation = new RowAllocationFake();
		rowAllocation.setRowHash(rowHash);
		rowAllocation.setAmount(amount);
		return rowAllocation;
	}

	public T done() {
		return parentBuilder;
	}
}
