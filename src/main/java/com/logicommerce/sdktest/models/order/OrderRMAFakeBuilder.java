package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.RMAStatusType;
import com.logicommerce.sdk.models.order.OrderRMA;

public class OrderRMAFakeBuilder<T> {

	private T parentBuilder;
	private int id;
	private String documentNumber;
	private RMAStatusType status;
	private LocalDateTime date;
	private List<OrderRMAItemFakeBuilder<OrderRMAFakeBuilder<T>>> items;

	public OrderRMAFakeBuilder() {
		id = 0;
		status = RMAStatusType.PENDING;
		date = LocalDateTime.now();
		items = new ArrayList<>();
	}

	public OrderRMAFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderRMAFakeBuilder<T> id(int id) {
		this.id = id;
		return this;
	}

	public OrderRMAFakeBuilder<T> documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}

	public OrderRMAFakeBuilder<T> status(RMAStatusType status) {
		this.status = status;
		return this;
	}

	public OrderRMAFakeBuilder<T> date(LocalDateTime date) {
		this.date = date;
		return this;
	}

	public OrderRMAItemFakeBuilder<OrderRMAFakeBuilder<T>> item() {
		OrderRMAItemFakeBuilder<OrderRMAFakeBuilder<T>> item = new OrderRMAItemFakeBuilder<>(this);
		items.add(item);
		return item;
	}

	public OrderRMA build() {
		OrderRMAFake orderRMA = new OrderRMAFake();
		orderRMA.setId(id);
		orderRMA.setDocumentNumber(documentNumber);
		orderRMA.setStatus(status);
		orderRMA.setDate(date);
		orderRMA.setItems(items.stream().map(OrderRMAItemFakeBuilder::build).collect(Collectors.toList()));
		return orderRMA;
	}

	public T done() {
		return parentBuilder;
	}
}
