package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderVoucher;

public class OrderVoucherFake implements OrderVoucher {

	private double availableBalance;

	private String code;

	private boolean balanceProcessed;

	@Override
	public double getAvailableBalance() {
		return availableBalance;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public boolean isBalanceProcessed() {
		return balanceProcessed;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setBalanceProcessed(boolean balanceProcessed) {
		this.balanceProcessed = balanceProcessed;
	}

}
