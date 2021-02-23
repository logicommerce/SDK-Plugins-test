package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.CurrencyMode;
import com.logicommerce.sdk.models.order.OrderCurrency;

public class OrderCurrencyBuilder {

	private OrderBuilder parentBuilder;

	private Integer id;

	private CurrencyMode mode;

	private int currencyId;

	private String name;

	private String code;

	private String codeNumber;

	private String symbol;

	private double usdValue;

	public OrderCurrencyBuilder() {
		id = 0;
		mode = CurrencyMode.ECOMMERCE;
		currencyId = 0;
		name = "name DEFAULT";
		code = "code DEFAULT";
		codeNumber = "codeNumber DEFAULT";
		symbol = "symbol DEFAULT";
		usdValue = 0d;
	}

	public OrderCurrencyBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderCurrencyBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderCurrencyBuilder mode(CurrencyMode mode) {
		this.mode = mode;
		return this;
	}

	public OrderCurrencyBuilder currencyId(int currencyId) {
		this.currencyId = currencyId;
		return this;
	}

	public OrderCurrencyBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderCurrencyBuilder code(String code) {
		this.code = code;
		return this;
	}

	public OrderCurrencyBuilder codeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
		return this;
	}

	public OrderCurrencyBuilder symbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public OrderCurrencyBuilder usdValue(double usdValue) {
		this.usdValue = usdValue;
		return this;
	}

	public OrderCurrency build() {
		OrderCurrencyFake currency = new OrderCurrencyFake();
		currency.setId(id);
		currency.setMode(mode);
		currency.setCurrencyId(currencyId);
		currency.setName(name);
		currency.setCode(code);
		currency.setCodeNumber(codeNumber);
		currency.setSymbol(symbol);
		currency.setUsdValue(usdValue);
		return currency;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
