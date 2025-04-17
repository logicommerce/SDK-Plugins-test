package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderCurrencyBuilder;
import com.logicommerce.sdk.enums.CurrencyMode;
import com.logicommerce.sdk.models.order.OrderCurrency;

public class OrderCurrencyFakeBuilder<T> extends OrderCurrencyBuilder<T>{

	public OrderCurrencyFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderCurrencyFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.mode = CurrencyMode.PURCHASE;
		super.currencyId = 0;
		super.name = "name DEFAULT";
		super.code = "code DEFAULT";
		super.codeNumber = "codeNumber DEFAULT";
		super.symbol = "symbol DEFAULT";
		super.usdValue = 0d;
	}

	@Override
	public OrderCurrency build() {
		OrderCurrency currencySdk = super.build();		
		OrderCurrencyFake currencyFake = new OrderCurrencyFake();
		currencyFake.setId(super.id);
		currencyFake.setMode(currencySdk.getMode());
		currencyFake.setCurrencyId(currencySdk.getCurrencyId());
		currencyFake.setName(currencySdk.getName());
		currencyFake.setCode(currencySdk.getCode());
		currencyFake.setCodeNumber(currencySdk.getCodeNumber());
		currencyFake.setSymbol(currencySdk.getSymbol());
		currencyFake.setUsdValue(currencySdk.getUsdValue());

		return currencyFake;
	}
}