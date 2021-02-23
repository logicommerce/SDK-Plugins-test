package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderVoucher;

public class OrderVoucherBuilder {

	private OrderBuilder parentBuilder;

	private double availableBalance;

	private String code;

	private boolean balanceProcessed;

	public OrderVoucherBuilder() {
		code = "code DEFAULT";
	}

	public OrderVoucherBuilder availableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
		return this;
	}

	public OrderVoucherBuilder code(String code) {
		this.code = code;
		return this;
	}

	public OrderVoucherBuilder balanceProcessed(boolean balanceProcessed) {
		this.balanceProcessed = balanceProcessed;
		return this;
	}

	public OrderVoucherBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderVoucher build() {
		OrderVoucherFake voucher = new OrderVoucherFake();
		voucher.setAvailableBalance(availableBalance);
		voucher.setCode(code);
		voucher.setBalanceProcessed(balanceProcessed);
		return voucher;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
