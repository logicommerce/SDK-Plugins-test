package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;

public class OrderFakeBuilder extends DocumentFakeBuilder<OrderFakeBuilder> {

	private OrderStatusType status;
	private int substatusId;
	private OrderTotalCurrencyFakeBuilder<OrderFakeBuilder> totalCurrency;
	private Boolean taxesIncluded;
	private OrderPurchaseCurrencyAmountsFakeBuilder<OrderFakeBuilder> purchaseCurrencyAmounts;
	private List<OrderRMAFakeBuilder<OrderFakeBuilder>> rmas;
	private List<OrderCreditNoteFakeBuilder<OrderFakeBuilder>> creditNotes;
	private String permalinkUrl;

	public OrderFakeBuilder() {
		super();
		status = OrderStatusType.INCOMING;
		substatusId = 0;
		totalCurrency = new OrderTotalCurrencyFakeBuilder<>(this);
	}

	public OrderFakeBuilder status(OrderStatusType status) {
		this.status = status;
		return this;
	}

	public OrderFakeBuilder substatusId(int substatusId) {
		this.substatusId = substatusId;
		return this;
	}

	public OrderTotalCurrencyFakeBuilder<OrderFakeBuilder> totalCurrency() {
		return totalCurrency;
	}

	public OrderFakeBuilder taxesIncluded(Boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
		return this;
	}

	public OrderPurchaseCurrencyAmountsFakeBuilder<OrderFakeBuilder> purchaseCurrencyAmounts() {
		if (purchaseCurrencyAmounts == null) {
			purchaseCurrencyAmounts = new OrderPurchaseCurrencyAmountsFakeBuilder<>(this);
		}
		return purchaseCurrencyAmounts;
	}

	public OrderRMAFakeBuilder<OrderFakeBuilder> rma() {
		if (rmas == null) {
			rmas = new ArrayList<>();
		}
		OrderRMAFakeBuilder<OrderFakeBuilder> rma = new OrderRMAFakeBuilder<>(this);
		rmas.add(rma);
		return rma;
	}

	public OrderCreditNoteFakeBuilder<OrderFakeBuilder> creditNote() {
		if (creditNotes == null) {
			creditNotes = new ArrayList<>();
		}
		OrderCreditNoteFakeBuilder<OrderFakeBuilder> creditNote = new OrderCreditNoteFakeBuilder<>(this);
		creditNotes.add(creditNote);
		return creditNote;
	}

	public OrderFakeBuilder permalinkUrl(String permalinkUrl) {
		this.permalinkUrl = permalinkUrl;
		return this;
	}

	public Order build() {
		OrderFake orderFake = new OrderFake();
		orderFake.setStatus(status);
		orderFake.setSubstatusId(substatusId);
		orderFake.setTotalCurrency(totalCurrency.build());
		orderFake.setTaxesIncluded(taxesIncluded);
		if (purchaseCurrencyAmounts != null) {
			orderFake.setPurchaseCurrencyAmounts(purchaseCurrencyAmounts.build());
		}
		if (rmas != null) {
			orderFake.setRMAs(rmas.stream().map(OrderRMAFakeBuilder::build).collect(Collectors.toList()));
		}
		if (creditNotes != null) {
			orderFake.setCreditNotes(creditNotes.stream().map(OrderCreditNoteFakeBuilder::build).collect(Collectors.toList()));
		}
		orderFake.setPermalinkUrl(permalinkUrl);
		setFields(orderFake);
		return orderFake;
	}

	@Override
	public OrderFakeBuilder returnThis() {
		return this;
	}
}
