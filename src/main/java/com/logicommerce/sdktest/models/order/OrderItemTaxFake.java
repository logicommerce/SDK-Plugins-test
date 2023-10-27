package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.TaxType;
import com.logicommerce.sdk.models.order.OrderItemTax;

public class OrderItemTaxFake implements OrderItemTax {

	private double base;
	private double taxValue;
	private double taxRate;
	private TaxType taxType;
	private String code;

	@Override
	public double getBase() {
		return base;
	}

	@Override
	public double getTaxValue() {
		return taxValue;
	}

	@Override
	public double getTaxRate() {
		return taxRate;
	}

	@Override
	public TaxType getType() {
		return taxType;
	}

	@Override
	public String getCode() {
		return code;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setTaxValue(double taxValue) {
		this.taxValue = taxValue;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
