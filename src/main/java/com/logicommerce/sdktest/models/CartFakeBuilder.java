package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.Cart;

public class CartFakeBuilder {

	private LocalDateTime createdAt;

	private List<CartItemFakeBuilder> items;

	private CartTotalsFakeBuilder totals;
	
	private CartDeliVeryFakeBuilder delivery;
	
	public CartFakeBuilder() {
		items = new ArrayList<>();
		totals = new CartTotalsFakeBuilder(this);
		delivery = new CartDeliVeryFakeBuilder(this);
	}

	public CartItemFakeBuilder item() {
		CartItemFakeBuilder item = new CartItemFakeBuilder(this);
		items.add(item);
		return item;
	}

	public CartTotalsFakeBuilder totals() {
		return totals;
	}

	public CartFakeBuilder createdAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public Cart build() {
		CartFake cart = new CartFake();
		cart.setCreatedAt(createdAt);
		cart.setItems(items.stream()
				.map(CartItemFakeBuilder::build)
				.collect(Collectors.toList()));
		cart.setTotals(totals.build());
		cart.setDelivery(delivery.build());
		return cart;
	}

}
