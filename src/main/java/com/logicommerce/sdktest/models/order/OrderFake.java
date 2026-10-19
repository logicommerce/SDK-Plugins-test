package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdk.models.order.OrderCreditNote;
import com.logicommerce.sdk.models.order.OrderPurchaseCurrencyAmounts;
import com.logicommerce.sdk.models.order.OrderRMA;
import com.logicommerce.sdk.models.order.OrderTotalCurrency;

public class OrderFake extends DocumentFake implements Order {

	private OrderStatusType status;
	private int substatusId;
	private OrderTotalCurrency totalCurrency;
	private Boolean taxesIncluded;
	private OrderPurchaseCurrencyAmounts purchaseCurrencyAmounts;
	private List<OrderRMA> rmas;
	private List<OrderCreditNote> creditNotes;
	private String permalinkUrl;

	@Override
	public OrderStatusType getStatus() {
		return status;
	}

	public void setStatus(OrderStatusType status) {
		this.status = status;
	}

	@Override
	public int getSubstatusId() {
		return substatusId;
	}

	public void setSubstatusId(int substatusId) {
		this.substatusId = substatusId;
	}

	@Override
	public OrderTotalCurrency getTotalCurrency() {
		return totalCurrency;
	}

	public void setTotalCurrency(OrderTotalCurrency totalCurrency) {
		this.totalCurrency = totalCurrency;
	}

	@Override
	public Boolean isTaxesIncluded() {
		return taxesIncluded;
	}

	public void setTaxesIncluded(Boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
	}

	@Override
	public OrderPurchaseCurrencyAmounts getPurchaseCurrencyAmounts() {
		return purchaseCurrencyAmounts;
	}

	public void setPurchaseCurrencyAmounts(OrderPurchaseCurrencyAmounts purchaseCurrencyAmounts) {
		this.purchaseCurrencyAmounts = purchaseCurrencyAmounts;
	}

	@Override
	public List<OrderRMA> getRMAs() {
		return rmas;
	}

	public void setRMAs(List<OrderRMA> rmas) {
		this.rmas = rmas;
	}

	@Override
	public List<OrderCreditNote> getCreditNotes() {
		return creditNotes;
	}

	public void setCreditNotes(List<OrderCreditNote> creditNotes) {
		this.creditNotes = creditNotes;
	}

	@Override
	public String getPermalinkUrl() {
		return permalinkUrl;
	}

	public void setPermalinkUrl(String permalinkUrl) {
		this.permalinkUrl = permalinkUrl;
	}
}
