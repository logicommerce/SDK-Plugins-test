package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.models.basket.Allocation;
import com.logicommerce.sdk.models.order.OrderShipmentAmounts;

public class OrderShipmentAmountsFake implements OrderShipmentAmounts {

	private int shipmentId;

	private long shippingPrice;

	private List<Allocation> shippingDiscounts;

	@Override
	public int getShipmentId() {
		return shipmentId;
	}

	@Override
	public long getShippingPrice() {
		return shippingPrice;
	}

	@Override
	public List<Allocation> getShippingDiscounts() {
		return shippingDiscounts;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public void setShippingPrice(long shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public void setShippingDiscounts(List<Allocation> shippingDiscounts) {
		this.shippingDiscounts = shippingDiscounts;
	}
}
