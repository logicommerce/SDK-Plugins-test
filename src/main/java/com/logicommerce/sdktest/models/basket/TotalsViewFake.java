package com.logicommerce.sdktest.models.basket;

import java.util.List;
import com.logicommerce.sdk.models.basket.AppliedTaxView;
import com.logicommerce.sdk.models.basket.TotalsView;

public class TotalsViewFake implements TotalsView {

	private long subtotal;

	private long rowsDiscount;

	private long delivery;

	private boolean deliverySelected;

	private long discount;

	private long paymentSystem;

	private long tax;

	private long vouchers;

	private long total;

	private List<AppliedTaxView> appliedTaxes;

	@Override
	public long getSubtotal() {
		return subtotal;
	}

	@Override
	public long getRowsDiscount() {
		return rowsDiscount;
	}

	@Override
	public long getDelivery() {
		return delivery;
	}

	@Override
	public boolean isDeliverySelected() {
		return deliverySelected;
	}

	@Override
	public long getDiscount() {
		return discount;
	}

	@Override
	public long getPaymentSystem() {
		return paymentSystem;
	}

	@Override
	public long getTax() {
		return tax;
	}

	@Override
	public long getVouchers() {
		return vouchers;
	}

	@Override
	public long getTotal() {
		return total;
	}

	@Override
	public List<AppliedTaxView> getAppliedTaxes() {
		return appliedTaxes;
	}

	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}

	public void setRowsDiscount(long rowsDiscount) {
		this.rowsDiscount = rowsDiscount;
	}

	public void setDelivery(long delivery) {
		this.delivery = delivery;
	}

	public void setDeliverySelected(boolean deliverySelected) {
		this.deliverySelected = deliverySelected;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public void setPaymentSystem(long paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public void setVouchers(long vouchers) {
		this.vouchers = vouchers;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setAppliedTaxes(List<AppliedTaxView> appliedTaxes) {
		this.appliedTaxes = appliedTaxes;
	}
}
