package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.models.order.OrderCreditNote;

public class OrderCreditNoteFake implements OrderCreditNote {

	private int id;

	private LocalDateTime date;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
