package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.Cart;
import com.logicommerce.sdk.models.User;

public class CartFakeBuilder {

	private String token;
	private HeadquarterFakeBuilder<CartFakeBuilder> headquarter;
	private LocalDateTime createdAt;
	private List<CartItemFakeBuilder> items;
	private CartTotalsFakeBuilder totals;
	private CartDeliveryFakeBuilder delivery;
	private UserFakeBuilder userBuilder;
	private User user;
	private String currencyCode;
	private CartPaymentSystemFakeBuilder paymentSystem;
	private List<CartDiscountFakeBuilder<CartFakeBuilder>> discounts;
	private String basketLink;

	public CartFakeBuilder() {
		headquarter = new HeadquarterFakeBuilder<>(this);
		items = new ArrayList<>();
		totals = new CartTotalsFakeBuilder(this);
		delivery = new CartDeliveryFakeBuilder(this);
		userBuilder = new UserFakeBuilder(this);
		paymentSystem = new CartPaymentSystemFakeBuilder(this);
		discounts = new ArrayList<>();
		currencyCode = "EUR";
	}

	public HeadquarterFakeBuilder<CartFakeBuilder> headquarter() {
		return headquarter;
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

	public CartFakeBuilder basketLink(String basketLink) {
		this.basketLink = basketLink;
		return this;
	}

	public UserFakeBuilder user() {
		return userBuilder;
	}

	public CartFakeBuilder user(User user) {
		this.user = user;
		return this;
	}

	public CartFakeBuilder delivery(CartDeliveryFakeBuilder delivery) {
		this.delivery = delivery;
		return this;
	}

	public CartDeliveryFakeBuilder delivery() {
		return delivery;
	}

	public CartFakeBuilder currencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public CartPaymentSystemFakeBuilder paymentSystem() {
		return paymentSystem;
	}

	public CartDiscountFakeBuilder<CartFakeBuilder> discount() {
		var discount = new CartDiscountFakeBuilder<CartFakeBuilder>(this);
		discounts.add(discount);
		return discount;
	}

	public Cart build() {
		CartFake cart = new CartFake();
		cart.setHeadquarter(headquarter.build());
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
		cart.setDiscounts(discounts.stream()
			.map(CartDiscountFakeBuilder::build)
			.collect(Collectors.toList()));
		cart.setBasketLink(basketLink);
		return cart;
	}

}
