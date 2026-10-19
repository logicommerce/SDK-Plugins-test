package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.models.basket.Allocation;

public class AllocationFake implements Allocation {

	private int discountId;

	private long amount;

	@Override
	public int getDiscountId() {
		return discountId;
	}

	@Override
	public long getAmount() {
		return amount;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
