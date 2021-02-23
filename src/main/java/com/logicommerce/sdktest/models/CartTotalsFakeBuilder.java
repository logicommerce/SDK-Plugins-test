package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CartTotals;

public class CartTotalsFakeBuilder {

	private CartFakeBuilder parentBuilder;

	private double subtotal;

	private double subtotalPaymentSystem;

	private double subtotalItems;

	private double subtotalShippings;

	private double total;

	private double totalDiscounts;

	private double totalPaymentSystem;

	private double totalItems;

	private double totalShippings;

	private double totalTaxes;

	private double totalVouchers;

	public CartTotalsFakeBuilder() {
		subtotal = 0.0;
		subtotalPaymentSystem = 0.0;
		subtotalItems = 0.0;
		subtotalShippings = 0.0;
		total = 0.0;
		totalDiscounts = 0.0;
		totalPaymentSystem = 0.0;
		totalItems = 0.0;
		totalShippings = 0.0;
		totalTaxes = 0.0;
		totalVouchers = 0.0;
	}

	public CartTotalsFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartTotalsFakeBuilder subtotal(double subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public CartTotalsFakeBuilder subtotalPaymentSystem(double subtotalPaymentSystem) {
		this.subtotalPaymentSystem = subtotalPaymentSystem;
		return this;
	}

	public CartTotalsFakeBuilder subtotalItems(double subtotalItems) {
		this.subtotalItems = subtotalItems;
		return this;
	}

	public CartTotalsFakeBuilder subtotalShippings(double subtotalShippings) {
		this.subtotalShippings = subtotalShippings;
		return this;
	}

	public CartTotalsFakeBuilder total(double total) {
		this.total = total;
		return this;
	}

	public CartTotalsFakeBuilder totalDiscounts(double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
		return this;
	}

	public CartTotalsFakeBuilder totalPaymentSystem(double totalPaymentSystem) {
		this.totalPaymentSystem = totalPaymentSystem;
		return this;
	}

	public CartTotalsFakeBuilder totalItems(double totalItems) {
		this.totalItems = totalItems;
		return this;
	}

	public CartTotalsFakeBuilder totalShippings(double totalShippings) {
		this.totalShippings = totalShippings;
		return this;
	}

	public CartTotalsFakeBuilder totalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
		return this;
	}

	public CartTotalsFakeBuilder totalVouchers(double totalVouchers) {
		this.totalVouchers = totalVouchers;
		return this;
	}
	
	public CartTotals build() {
		CartTotalsFake totals = new CartTotalsFake();
		totals.setSubtotal(subtotal);
		totals.setSubtotalPaymentSystem(subtotalPaymentSystem);
		totals.setSubtotalItems(subtotalItems);
		totals.setSubtotalShippings(subtotalShippings);
		totals.setTotal(total);
		totals.setTotalDiscounts(totalDiscounts);
		totals.setTotalPaymentSystem(totalPaymentSystem);
		totals.setTotalItems(totalItems);
		totals.setTotalShippings(totalShippings);
		totals.setTotalTaxes(totalTaxes);
		totals.setTotalVouchers(totalVouchers);
		return totals;
	}
	
	public CartFakeBuilder done() {
		return parentBuilder;
	}

}
