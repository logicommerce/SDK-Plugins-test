package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.models.basket.Allocation;
import com.logicommerce.sdk.models.order.OrderItemAmounts;

public class OrderItemAmountsFake implements OrderItemAmounts {

	private String hash;

	private long unitPrice;

	private long subtotal;

	private List<Allocation> discounts;

	private long total;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public long getUnitPrice() {
		return unitPrice;
	}

	@Override
	public long getSubtotal() {
		return subtotal;
	}

	@Override
	public List<Allocation> getDiscounts() {
		return discounts;
	}

	@Override
	public long getTotal() {
		return total;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}

	public void setDiscounts(List<Allocation> discounts) {
		this.discounts = discounts;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
