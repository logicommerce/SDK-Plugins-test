package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderCreditNoteAmounts;

public class OrderCreditNoteAmountsFakeBuilder<T> {

	private T parentBuilder;
	private int creditNoteId;
	private long total;

	public OrderCreditNoteAmountsFakeBuilder() {
		creditNoteId = 0;
		total = 0;
	}

	public OrderCreditNoteAmountsFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderCreditNoteAmountsFakeBuilder<T> creditNoteId(int creditNoteId) {
		this.creditNoteId = creditNoteId;
		return this;
	}

	public OrderCreditNoteAmountsFakeBuilder<T> total(long total) {
		this.total = total;
		return this;
	}

	public OrderCreditNoteAmounts build() {
		OrderCreditNoteAmountsFake orderCreditNoteAmounts = new OrderCreditNoteAmountsFake();
		orderCreditNoteAmounts.setCreditNoteId(creditNoteId);
		orderCreditNoteAmounts.setTotal(total);
		return orderCreditNoteAmounts;
	}

	public T done() {
		return parentBuilder;
	}
}
