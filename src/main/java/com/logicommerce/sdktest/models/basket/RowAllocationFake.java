package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.RowAllocation;

public class RowAllocationFake implements RowAllocation {

	private String rowHash;

	private long amount;

	@Override
	public String getRowHash() {
		return rowHash;
	}

	@Override
	public long getAmount() {
		return amount;
	}

	public void setRowHash(String rowHash) {
		this.rowHash = rowHash;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
