package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.models.CartDelivery;

public class CartDeliVeryFakeBuilder {

	private CartFakeBuilder parentBuilder;

	private List<CartShipmentFakeBuilder> shipments;

	public CartDeliVeryFakeBuilder() {
		shipments = new ArrayList<>();
	}

	public CartDeliVeryFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartShipmentFakeBuilder shipment() {
		CartShipmentFakeBuilder shipment = new CartShipmentFakeBuilder(this);
		shipments.add(shipment);
		return shipment;
	}

	public CartDelivery build() {
		CartDeliveryFake cartDelivery = new CartDeliveryFake();
		cartDelivery.setShipments(shipments.stream().map(CartShipmentFakeBuilder::build).collect(Collectors.toList()));
		return cartDelivery;
	}

	public CartFakeBuilder done() {
		return parentBuilder;
	}
}
