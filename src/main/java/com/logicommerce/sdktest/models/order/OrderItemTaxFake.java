package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.TaxType;
import com.logicommerce.sdk.models.order.OrderItemTax;
import com.logicommerce.sdk.models.order.OrderItemTaxDefinition;

public class OrderItemTaxFake implements OrderItemTax {

	private double base;
	private double taxValue;
	private double taxRate;
	private TaxType type;
	private String code;
	private OrderItemTaxDefinition taxDefinition;

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
		return type;
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

	public void setType(TaxType type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public OrderItemTaxDefinition getTaxDefinition() {
		return taxDefinition;
	}

	public void setTaxDefinition(OrderItemTaxDefinition taxDefinition) {
		this.taxDefinition = taxDefinition;
	}

}
