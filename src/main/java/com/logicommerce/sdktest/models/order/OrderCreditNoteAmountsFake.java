package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderCreditNoteAmounts;

public class OrderCreditNoteAmountsFake implements OrderCreditNoteAmounts {

	private int creditNoteId;

	private long total;

	@Override
	public int getCreditNoteId() {
		return creditNoteId;
	}

	@Override
	public long getTotal() {
		return total;
	}

	public void setCreditNoteId(int creditNoteId) {
		this.creditNoteId = creditNoteId;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
