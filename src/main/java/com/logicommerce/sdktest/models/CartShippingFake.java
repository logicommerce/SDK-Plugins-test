package com.logicommerce.sdktest.models;

import java.util.List;
import com.logicommerce.sdk.models.CartDiscount;
import com.logicommerce.sdk.models.CartShipping;

public class CartShippingFake implements CartShipping {

	private String name;
	private String taxCode;
	private Double price;
	private List<CartDiscount> discounts;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public List<CartDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<CartDiscount> discounts) {
		this.discounts = discounts;
	}

}
