package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartShipmentItem;

public class CartShipmentItemFakeBuilder {

	private CartShipmentFakeBuilder parentBuilder;

	private String hash;

	private String itemHash;

	private int quantity;

	public CartShipmentItemFakeBuilder() {
		hash = "hash DEFAULT";
		itemHash = "itemHash DEFAULT";
		quantity = 0;
	}

	public CartShipmentItemFakeBuilder(CartShipmentFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartShipmentItemFakeBuilder hash(String hash) {
		this.hash = hash;
		return this;
	}

	public CartShipmentItemFakeBuilder itemHash(String itemHash) {
		this.itemHash = itemHash;
		return this;
	}

	public CartShipmentItemFakeBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public CartShipmentItem build() {
		CartShipmentItemFake item = new CartShipmentItemFake();
		item.setHash(hash);
		item.setItemHash(itemHash);
		item.setQuantity(quantity);
		return item;
	}

	public CartShipmentFakeBuilder done() {
		return parentBuilder;
	}

}
