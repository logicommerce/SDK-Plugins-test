package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderTotal;
import com.logicommerce.sdk.models.order.OrderTotalCurrency;

public class OrderTotalCurrencyFake implements OrderTotalCurrency {

	private OrderTotal totals;

	private String currencyCode;

	private String currencyCodeNumer;

	@Override
	public OrderTotal getTotals() {
		return totals;
	}

	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	@Override
	public String getCurrencyCodeNumer() {
		return currencyCodeNumer;
	}

	public void setTotals(OrderTotal totals) {
		this.totals = totals;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setCurrencyCodeNumer(String currencyCodeNumer) {
		this.currencyCodeNumer = currencyCodeNumer;
	}

}
