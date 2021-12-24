package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.List;
import com.logicommerce.sdk.models.Cart;
import com.logicommerce.sdk.models.CartDelivery;
import com.logicommerce.sdk.models.CartItem;
import com.logicommerce.sdk.models.CartTotals;

public class CartFake implements Cart {

	private LocalDateTime createdAt;

	private List<CartItem> items;

	private CartTotals totals;

	private CartDelivery delivery;
	
	private String abandonedBasketLink;

	@Override
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public List<CartItem> getItems() {
		return items;
	}

	@Override
	public CartTotals getTotals() {
		return totals;
	}

	@Override
	public CartDelivery getDelivery() {
		return delivery;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void setTotals(CartTotals totals) {
		this.totals = totals;
	}

	public void setDelivery(CartDelivery delivery) {
		this.delivery = delivery;
	}

	@Override
	public String getAbandonedBasketLink() {
		return abandonedBasketLink;
	}
}
