package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderTotalBuilder;
import com.logicommerce.sdk.builders.order.OrderTotalCurrencyBuilder;
import com.logicommerce.sdk.models.order.OrderTotalCurrency;

public class OrderTotalCurrencyFakeBuilder<T> extends OrderTotalCurrencyBuilder<T> {

	public OrderTotalCurrencyFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.currencyCode = "EUR";
		super.currencyCodeNumber = "978";
		super.totals = new OrderTotalFakeBuilder<>(this);
	}

	@Override
	public OrderTotalBuilder<OrderTotalCurrencyBuilder<T>> totals() {
		OrderTotalBuilder<OrderTotalCurrencyBuilder<T>> totals = new OrderTotalFakeBuilder<>(this);
		super.totals = totals;
		return totals;
	}

	@Override
	public OrderTotalCurrency build() {
		OrderTotalCurrency orderTotalCurrency = super.build();
		OrderTotalCurrencyFake orderTotalCurrencyFake = new OrderTotalCurrencyFake();
		orderTotalCurrencyFake.setCurrencyCode(orderTotalCurrency.getCurrencyCode());
		orderTotalCurrencyFake.setCurrencyCodeNumer(orderTotalCurrency.getCurrencyCodeNumer());
		orderTotalCurrencyFake.setTotals(orderTotalCurrency.getTotals());
		return orderTotalCurrencyFake;
	}
}
