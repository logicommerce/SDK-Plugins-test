package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.Cart;
import com.logicommerce.sdk.models.User;

public class CartFakeBuilder {

	private String token;
	private LocalDateTime createdAt;
	private List<CartItemFakeBuilder> items;
	private CartTotalsFakeBuilder totals;
	private CartDeliVeryFakeBuilder delivery;
	private UserFakeBuilder userBuilder;
	private User user;
	private String currencyCode;
	private CartPaymentSystemFakeBuilder paymentSystem;

	public CartFakeBuilder() {
		items = new ArrayList<>();
		totals = new CartTotalsFakeBuilder(this);
		delivery = new CartDeliVeryFakeBuilder(this);
		userBuilder = new UserFakeBuilder(this);
		paymentSystem = new CartPaymentSystemFakeBuilder(this);
		currencyCode = "EUR";
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

	public CartFakeBuilder token(String token) {
		this.token = token;
		return this;
	}

	public UserFakeBuilder user() {
		return userBuilder;
	}

	public CartFakeBuilder user(User user) {
		this.user = user;
		return this;
	}

	public CartFakeBuilder delivery(CartDeliVeryFakeBuilder delivery) {
		this.delivery = delivery;
		return this;
	}

	public CartDeliVeryFakeBuilder delivery() {
		return delivery;
	}

	public CartFakeBuilder currencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public CartPaymentSystemFakeBuilder paymentSystem() {
		return paymentSystem;
	}

	public Cart build() {
		CartFake cart = new CartFake();
		cart.setToken(token);
		cart.setCreatedAt(createdAt);
		cart.setItems(items.stream()
			.map(CartItemFakeBuilder::build)
			.collect(Collectors.toList()));
		cart.setTotals(totals.build());
		cart.setDelivery(delivery.build());
		if (user == null) {
			user = userBuilder.build();
		}
		cart.setUser(user);
		cart.setCurrencyCode(currencyCode);
		cart.setPaymentSystem(paymentSystem.build());
		return cart;
	}

}
