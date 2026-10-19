package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderRMAItem;

public class OrderRMAItemFake implements OrderRMAItem {

	private String hash;

	private int quantity;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
