package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.CurrencyMode;
import com.logicommerce.sdk.models.order.OrderCurrency;

public class OrderCurrencyFake implements OrderCurrency {

	private Integer id;

	private CurrencyMode mode;

	private int currencyId;

	private String name;

	private String code;

	private String codeNumber;

	private String symbol;

	private double usdValue;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public CurrencyMode getMode() {
		return mode;
	}

	@Override
	public int getCurrencyId() {
		return currencyId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getCodeNumber() {
		return codeNumber;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public double getUsdValue() {
		return usdValue;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMode(CurrencyMode mode) {
		this.mode = mode;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setUsdValue(double usdValue) {
		this.usdValue = usdValue;
	}

}
