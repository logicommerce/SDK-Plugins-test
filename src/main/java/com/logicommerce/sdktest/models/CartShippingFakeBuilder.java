package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartShippingFakeBuilder {

	private CartShipmentFakeBuilder parentBuilder;
	private String name;
	private String taxCode;
	private Double price;
	private List<CartDiscountFakeBuilder<CartShippingFakeBuilder>> discounts;

	public CartShippingFakeBuilder() {
		name = "name DEFAULT";
		taxCode = "taxCode DEFAULT";
		price = 0.0;
		discounts = new ArrayList<>();
	}

	public CartShippingFakeBuilder(CartShipmentFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartShippingFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CartShippingFakeBuilder taxCode(String taxCode) {
		this.taxCode = taxCode;
		return this;
	}

	public CartShippingFakeBuilder price(Double price) {
		this.price = price;
		return this;
	}

	public CartDiscountFakeBuilder<CartShippingFakeBuilder> discount() {
		var discount = new CartDiscountFakeBuilder<CartShippingFakeBuilder>(this);
		discounts.add(discount);
		return discount;
	}

	public CartShippingFake build() {
		CartShippingFake shipping = new CartShippingFake();
		shipping.setName(name);
		shipping.setTaxCode(taxCode);
		shipping.setPrice(price);
		shipping.setDiscounts(discounts.stream().map(CartDiscountFakeBuilder::build).collect(Collectors.toList()));
		return shipping;
	}

	public CartShipmentFakeBuilder done() {
		return parentBuilder;
	}
}
