package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.order.OrderPurchaseCurrencyAmounts;
import com.logicommerce.sdktest.models.basket.AppliedDiscountViewFakeBuilder;
import com.logicommerce.sdktest.models.basket.TotalsViewFakeBuilder;

public class OrderPurchaseCurrencyAmountsFakeBuilder<T> {

	private T parentBuilder;
	private String currencyCode;
	private List<OrderItemAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>>> items;
	private List<AppliedDiscountViewFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>>> discounts;
	private TotalsViewFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> totals;
	private List<OrderShipmentAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>>> shipments;
	private List<OrderCreditNoteAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>>> creditNotes;

	public OrderPurchaseCurrencyAmountsFakeBuilder() {
		currencyCode = "EUR";
		items = new ArrayList<>();
		discounts = new ArrayList<>();
		totals = new TotalsViewFakeBuilder<>(this);
		shipments = new ArrayList<>();
		creditNotes = new ArrayList<>();
	}

	public OrderPurchaseCurrencyAmountsFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderPurchaseCurrencyAmountsFakeBuilder<T> currencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public OrderItemAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> item() {
		OrderItemAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> item = new OrderItemAmountsFakeBuilder<>(this);
		items.add(item);
		return item;
	}

	public AppliedDiscountViewFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> discount() {
		AppliedDiscountViewFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> discount = new AppliedDiscountViewFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public TotalsViewFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> totals() {
		return totals;
	}

	public OrderShipmentAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> shipment() {
		OrderShipmentAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> shipment = new OrderShipmentAmountsFakeBuilder<>(this);
		shipments.add(shipment);
		return shipment;
	}

	public OrderCreditNoteAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> creditNote() {
		OrderCreditNoteAmountsFakeBuilder<OrderPurchaseCurrencyAmountsFakeBuilder<T>> creditNote = new OrderCreditNoteAmountsFakeBuilder<>(this);
		creditNotes.add(creditNote);
		return creditNote;
	}

	public OrderPurchaseCurrencyAmounts build() {
		OrderPurchaseCurrencyAmountsFake orderPurchaseCurrencyAmounts = new OrderPurchaseCurrencyAmountsFake();
		orderPurchaseCurrencyAmounts.setCurrencyCode(currencyCode);
		orderPurchaseCurrencyAmounts.setItems(items.stream().map(OrderItemAmountsFakeBuilder::build).collect(Collectors.toList()));
		orderPurchaseCurrencyAmounts.setDiscounts(discounts.stream().map(AppliedDiscountViewFakeBuilder::build).collect(Collectors.toList()));
		orderPurchaseCurrencyAmounts.setTotals(totals.build());
		orderPurchaseCurrencyAmounts.setShipments(shipments.stream().map(OrderShipmentAmountsFakeBuilder::build).collect(Collectors.toList()));
		orderPurchaseCurrencyAmounts.setCreditNotes(creditNotes.stream().map(OrderCreditNoteAmountsFakeBuilder::build).collect(Collectors.toList()));
		return orderPurchaseCurrencyAmounts;
	}

	public T done() {
		return parentBuilder;
	}
}
