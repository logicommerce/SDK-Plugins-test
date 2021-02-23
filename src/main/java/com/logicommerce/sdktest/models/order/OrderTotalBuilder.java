package com.logicommerce.sdktest.models.order;

public class OrderTotalBuilder {

	private OrderBuilder parentBuilder;

	private double subtotal;

	private double subtotalItems;

	private double subtotalPaymentSystem;

	private double subtotalShippings;

	private double total;

	private double totalDiscounts;

	private double totalItems;

	private double totalPaymentSystem;

	private double totalShippings;

	private double totalTaxes;

	private double totalVouchers;

	public OrderTotalBuilder() {
		subtotal = 0d;
		subtotalItems = 0d;
		subtotalPaymentSystem = 0d;
		subtotalShippings = 0d;
		total = 0d;
		totalDiscounts = 0d;
		totalItems = 0d;
		totalPaymentSystem = 0d;
		totalShippings = 0d;
		totalTaxes = 0d;
		totalVouchers = 0d;
	}

	public OrderTotalBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderTotalBuilder subtotal(double subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public OrderTotalBuilder subtotalItems(double subtotalItems) {
		this.subtotalItems = subtotalItems;
		return this;
	}

	public OrderTotalBuilder subtotalPaymentSystem(double subtotalPaymentSystem) {
		this.subtotalPaymentSystem = subtotalPaymentSystem;
		return this;
	}

	public OrderTotalBuilder subtotalShippings(double subtotalShippings) {
		this.subtotalShippings = subtotalShippings;
		return this;
	}

	public OrderTotalBuilder total(double total) {
		this.total = total;
		return this;
	}

	public OrderTotalBuilder totalDiscounts(double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
		return this;
	}

	public OrderTotalBuilder totalItems(double totalItems) {
		this.totalItems = totalItems;
		return this;
	}

	public OrderTotalBuilder totalPaymentSystem(double totalPaymentSystem) {
		this.totalPaymentSystem = totalPaymentSystem;
		return this;
	}

	public OrderTotalBuilder totalShippings(double totalShippings) {
		this.totalShippings = totalShippings;
		return this;
	}

	public OrderTotalBuilder totalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
		return this;
	}

	public OrderTotalBuilder totalVouchers(double totalVouchers) {
		this.totalVouchers = totalVouchers;
		return this;
	}

	public OrderTotalFake build() {
		OrderTotalFake totals = new OrderTotalFake();
		totals.setSubtotal(subtotal);
		totals.setSubtotalItems(subtotalItems);
		totals.setSubtotalPaymentSystem(subtotalPaymentSystem);
		totals.setSubtotalShippings(subtotalShippings);
		totals.setTotal(total);
		totals.setTotalDiscounts(totalDiscounts);
		totals.setTotalItems(totalItems);
		totals.setTotalPaymentSystem(totalPaymentSystem);
		totals.setTotalShippings(totalShippings);
		totals.setTotalTaxes(totalTaxes);
		totals.setTotalVouchers(totalVouchers);
		return totals;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
