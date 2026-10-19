package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.models.basket.AppliedDiscountView;
import com.logicommerce.sdk.models.basket.TotalsView;
import com.logicommerce.sdk.models.order.OrderCreditNoteAmounts;
import com.logicommerce.sdk.models.order.OrderItemAmounts;
import com.logicommerce.sdk.models.order.OrderPurchaseCurrencyAmounts;
import com.logicommerce.sdk.models.order.OrderShipmentAmounts;

public class OrderPurchaseCurrencyAmountsFake implements OrderPurchaseCurrencyAmounts {

	private String currencyCode;

	private List<OrderItemAmounts> items;

	private List<AppliedDiscountView> discounts;

	private TotalsView totals;

	private List<OrderShipmentAmounts> shipments;

	private List<OrderCreditNoteAmounts> creditNotes;

	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	@Override
	public List<OrderItemAmounts> getItems() {
		return items;
	}

	@Override
	public List<AppliedDiscountView> getDiscounts() {
		return discounts;
	}

	@Override
	public TotalsView getTotals() {
		return totals;
	}

	@Override
	public List<OrderShipmentAmounts> getShipments() {
		return shipments;
	}

	@Override
	public List<OrderCreditNoteAmounts> getCreditNotes() {
		return creditNotes;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setItems(List<OrderItemAmounts> items) {
		this.items = items;
	}

	public void setDiscounts(List<AppliedDiscountView> discounts) {
		this.discounts = discounts;
	}

	public void setTotals(TotalsView totals) {
		this.totals = totals;
	}

	public void setShipments(List<OrderShipmentAmounts> shipments) {
		this.shipments = shipments;
	}

	public void setCreditNotes(List<OrderCreditNoteAmounts> creditNotes) {
		this.creditNotes = creditNotes;
	}
}
