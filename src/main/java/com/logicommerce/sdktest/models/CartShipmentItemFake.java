package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartShipmentItem;

public class CartShipmentItemFake implements CartShipmentItem {

	private String hash;

	private String itemHash;

	private int quantity;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public String getItemHash() {
		return itemHash;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setItemHash(String itemHash) {
		this.itemHash = itemHash;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
