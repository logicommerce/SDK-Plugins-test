package com.logicommerce.sdktest.models;

import java.time.LocalDateTime;
import java.util.List;
import com.logicommerce.sdk.models.Cart;
import com.logicommerce.sdk.models.CartDelivery;
import com.logicommerce.sdk.models.CartDiscount;
import com.logicommerce.sdk.models.CartItem;
import com.logicommerce.sdk.models.CartPaymentSystem;
import com.logicommerce.sdk.models.CartTotals;
import com.logicommerce.sdk.models.Headquarter;
import com.logicommerce.sdk.models.User;
import com.logicommerce.sdk.models.implementations.HeadquarterImpl;

public class CartFake implements Cart {

	private HeadquarterImpl headquarter;

	private String token;

	private LocalDateTime createdAt;

	private List<CartItem> items;

	private CartTotals totals;

	private CartDelivery delivery;

	private String abandonedBasketLink;

	private User user;

	private String currencyCode;

	private CartPaymentSystem paymentSystem;

	private List<CartDiscount> discounts;

	@Override
	public Headquarter getHeadquarter() {
		return headquarter;
	}

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

	@Override
	public CartPaymentSystem getPaymentSystem() {
		return paymentSystem;
	}

	@Override
	public List<CartDiscount> getDiscounts() {
		return discounts;
	}

	public void setHeadquarter(HeadquarterImpl headquarter) {
		this.headquarter = headquarter;
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

	public void setPaymentSystem(CartPaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public void setDiscounts(List<CartDiscount> discounts) {
		this.discounts = discounts;
	}

}
