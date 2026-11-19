package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.List;
import com.logicommerce.sdk.enums.RMAStatusType;
import com.logicommerce.sdk.models.order.OrderRMA;
import com.logicommerce.sdk.models.order.OrderRMAItem;

public class OrderRMAFake implements OrderRMA {

	private int id;

	private String documentNumber;

	private RMAStatusType status;

	private LocalDateTime date;

	private List<OrderRMAItem> items;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDocumentNumber() {
		return documentNumber;
	}

	@Override
	public RMAStatusType getStatus() {
		return status;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public List<OrderRMAItem> getItems() {
		return items;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setStatus(RMAStatusType status) {
		this.status = status;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setItems(List<OrderRMAItem> items) {
		this.items = items;
	}
}
