package com.logicommerce.sdktest.models;

import java.util.List;

import com.logicommerce.sdk.models.CartDelivery;
import com.logicommerce.sdk.models.CartShipment;

public class CartDeliveryFake implements CartDelivery {

	private List<CartShipment> shipments;

	@Override
	public List<CartShipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<CartShipment> shipments) {
		this.shipments = shipments;
	}

}
