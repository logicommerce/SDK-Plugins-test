package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.List;
import com.logicommerce.sdk.models.Cart;
import com.logicommerce.sdk.models.CartDelivery;
import com.logicommerce.sdk.models.CartItem;
import com.logicommerce.sdk.models.CartTotals;
import com.logicommerce.sdk.models.User;

public class CartFake implements Cart {

	private String token;

	private LocalDateTime createdAt;

	private List<CartItem> items;

	private CartTotals totals;

	private CartDelivery delivery;

	private String abandonedBasketLink;

	private User user;
	
	private String currencyCode;

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

	@Override
	public String getAbandonedBasketLink() {
		return abandonedBasketLink;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public String getCurrencyCode() {
		return currencyCode;
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

	public void setToken(String token) {
		this.token = token;
	}

	public void setAbandonedBasketLink(String abandonedBasketLink) {
		this.abandonedBasketLink = abandonedBasketLink;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
