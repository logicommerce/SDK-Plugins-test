package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.models.order.OrderCreditNote;

public class OrderCreditNoteFakeBuilder<T> {

	private T parentBuilder;
	private int id;
	private LocalDateTime date;

	public OrderCreditNoteFakeBuilder() {
		id = 0;
		date = LocalDateTime.now();
	}

	public OrderCreditNoteFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderCreditNoteFakeBuilder<T> id(int id) {
		this.id = id;
		return this;
	}

	public OrderCreditNoteFakeBuilder<T> date(LocalDateTime date) {
		this.date = date;
		return this;
	}

	public OrderCreditNote build() {
		OrderCreditNoteFake orderCreditNote = new OrderCreditNoteFake();
		orderCreditNote.setId(id);
		orderCreditNote.setDate(date);
		return orderCreditNote;
	}

	public T done() {
		return parentBuilder;
	}
}
