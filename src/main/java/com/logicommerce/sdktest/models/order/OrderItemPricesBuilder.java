package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderItemPrices;

public class OrderItemPricesBuilder {

	private OrderItemBuilder parentBuilder;

	private double productPrice;

	private double optionsPrice;

	private double previousPrice;

	private double price;

	private double totalTaxes;

	private double total;

	public OrderItemPricesBuilder() {
		productPrice = 0d;
		optionsPrice = 0d;
		previousPrice = 0d;
		price = 0d;
		totalTaxes = 0d;
		total = 0d;
	}

	public OrderItemPricesBuilder(OrderItemBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemPricesBuilder productPrice(double productPrice) {
		this.productPrice = productPrice;
		return this;
	}

	public OrderItemPricesBuilder optionsPrice(double optionsPrice) {
		this.optionsPrice = optionsPrice;
		return this;
	}

	public OrderItemPricesBuilder previousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
		return this;
	}

	public OrderItemPricesBuilder price(double price) {
		this.price = price;
		return this;
	}

	public OrderItemPricesBuilder totalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
		return this;
	}

	public OrderItemPricesBuilder total(double total) {
		this.total = total;
		return this;
	}

	public OrderItemPrices build() {
		OrderItemPricesFake prices = new OrderItemPricesFake();
		prices.setProductPrice(productPrice);
		prices.setOptionsPrice(optionsPrice);
		prices.setPreviousPrice(previousPrice);
		prices.setPrice(price);
		prices.setTotalTaxes(totalTaxes);
		prices.setTotal(total);
		return prices;
	}

	public OrderItemBuilder done() {
		return parentBuilder;
	}

}
