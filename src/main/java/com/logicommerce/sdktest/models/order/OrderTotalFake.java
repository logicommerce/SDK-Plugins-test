package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderTotal;

public class OrderTotalFake implements OrderTotal {

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

	@Override
	public double getSubtotal() {
		return subtotal;
	}

	@Override
	public double getSubtotalItems() {
		return subtotalItems;
	}

	@Override
	public double getSubtotalPaymentSystem() {
		return subtotalPaymentSystem;
	}

	@Override
	public double getSubtotalShippings() {
		return subtotalShippings;
	}

	@Override
	public double getTotal() {
		return total;
	}

	@Override
	public double getTotalDiscounts() {
		return totalDiscounts;
	}

	@Override
	public double getTotalItems() {
		return totalItems;
	}

	@Override
	public double getTotalPaymentSystem() {
		return totalPaymentSystem;
	}

	@Override
	public double getTotalShippings() {
		return totalShippings;
	}

	@Override
	public double getTotalTaxes() {
		return totalTaxes;
	}

	@Override
	public double getTotalVouchers() {
		return totalVouchers;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void setSubtotalItems(double subtotalItems) {
		this.subtotalItems = subtotalItems;
	}

	public void setSubtotalPaymentSystem(double subtotalPaymentSystem) {
		this.subtotalPaymentSystem = subtotalPaymentSystem;
	}

	public void setSubtotalShippings(double subtotalShippings) {
		this.subtotalShippings = subtotalShippings;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setTotalDiscounts(double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}

	public void setTotalItems(double totalItems) {
		this.totalItems = totalItems;
	}

	public void setTotalPaymentSystem(double totalPaymentSystem) {
		this.totalPaymentSystem = totalPaymentSystem;
	}

	public void setTotalShippings(double totalShippings) {
		this.totalShippings = totalShippings;
	}

	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public void setTotalVouchers(double totalVouchers) {
		this.totalVouchers = totalVouchers;
	}
	
}
