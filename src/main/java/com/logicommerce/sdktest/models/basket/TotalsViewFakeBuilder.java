package com.logicommerce.sdktest.models.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.basket.TotalsView;

public class TotalsViewFakeBuilder<T> {

	private T parentBuilder;
	private long subtotal;
	private long rowsDiscount;
	private long delivery;
	private boolean deliverySelected;
	private long discount;
	private long paymentSystem;
	private long tax;
	private long vouchers;
	private long total;
	private List<AppliedTaxViewFakeBuilder<TotalsViewFakeBuilder<T>>> appliedTaxes;

	public TotalsViewFakeBuilder() {
		subtotal = 0;
		rowsDiscount = 0;
		delivery = 0;
		deliverySelected = false;
		discount = 0;
		paymentSystem = 0;
		tax = 0;
		vouchers = 0;
		total = 0;
		appliedTaxes = new ArrayList<>();
	}

	public TotalsViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public TotalsViewFakeBuilder<T> subtotal(long subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public TotalsViewFakeBuilder<T> rowsDiscount(long rowsDiscount) {
		this.rowsDiscount = rowsDiscount;
		return this;
	}

	public TotalsViewFakeBuilder<T> delivery(long delivery) {
		this.delivery = delivery;
		return this;
	}

	public TotalsViewFakeBuilder<T> deliverySelected(boolean deliverySelected) {
		this.deliverySelected = deliverySelected;
		return this;
	}

	public TotalsViewFakeBuilder<T> discount(long discount) {
		this.discount = discount;
		return this;
	}

	public TotalsViewFakeBuilder<T> paymentSystem(long paymentSystem) {
		this.paymentSystem = paymentSystem;
		return this;
	}

	public TotalsViewFakeBuilder<T> tax(long tax) {
		this.tax = tax;
		return this;
	}

	public TotalsViewFakeBuilder<T> vouchers(long vouchers) {
		this.vouchers = vouchers;
		return this;
	}

	public TotalsViewFakeBuilder<T> total(long total) {
		this.total = total;
		return this;
	}

	public AppliedTaxViewFakeBuilder<TotalsViewFakeBuilder<T>> appliedTax() {
		AppliedTaxViewFakeBuilder<TotalsViewFakeBuilder<T>> appliedTax = new AppliedTaxViewFakeBuilder<>(this);
		appliedTaxes.add(appliedTax);
		return appliedTax;
	}

	public TotalsView build() {
		TotalsViewFake totalsView = new TotalsViewFake();
		totalsView.setSubtotal(subtotal);
		totalsView.setRowsDiscount(rowsDiscount);
		totalsView.setDelivery(delivery);
		totalsView.setDeliverySelected(deliverySelected);
		totalsView.setDiscount(discount);
		totalsView.setPaymentSystem(paymentSystem);
		totalsView.setTax(tax);
		totalsView.setVouchers(vouchers);
		totalsView.setTotal(total);
		totalsView.setAppliedTaxes(appliedTaxes.stream().map(AppliedTaxViewFakeBuilder::build).collect(Collectors.toList()));
		return totalsView;
	}

	public T done() {
		return parentBuilder;
	}
}
