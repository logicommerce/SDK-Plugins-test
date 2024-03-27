package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.AddressBuilder;
import com.logicommerce.sdk.models.CartShipment;

public class CartShipmentFakeBuilder {

	private CartDeliveryFakeBuilder parentBuilder;
	private List<CartShipmentItemFakeBuilder> items;
	private double total;
	private double weight;
	private CartWarehouseFakeBuilder warehouse;
	private CartShippingFakeBuilder shipping;
	private String hash;
	private AddressBuilder<CartShipmentFakeBuilder, ?> logisticsCenterAddress;

	public CartShipmentFakeBuilder() {
		items = new ArrayList<>();
		warehouse = new CartWarehouseFakeBuilder(this);
		shipping = new CartShippingFakeBuilder(this);
		hash = "hash_DEFAULT";
		logisticsCenterAddress = new AddressBuilder<>(this);
	}

	public CartShipmentFakeBuilder(CartDeliveryFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartShipmentItemFakeBuilder item() {
		CartShipmentItemFakeBuilder item = new CartShipmentItemFakeBuilder(this);
		items.add(item);
		return item;
	}

	public CartShipmentFakeBuilder total(double total) {
		this.total = total;
		return this;
	}

	public CartShipmentFakeBuilder weight(double weight) {
		this.weight = weight;
		return this;
	}

	public CartShipmentFakeBuilder hash(String hash) {
		this.hash = hash;
		return this;
	}

	public CartWarehouseFakeBuilder warehouse() {
		return warehouse;
	}

	public CartShippingFakeBuilder shipping() {
		return shipping;
	}

	public AddressBuilder<CartShipmentFakeBuilder, ?> logisticsCenterAddress() {
		return logisticsCenterAddress;
	}

	public CartShipment build() {
		CartShipmentFake shipment = new CartShipmentFake();
		shipment.setItems(items.stream()
			.map(CartShipmentItemFakeBuilder::build)
			.collect(Collectors.toList()));
		shipment.setTotal(total);
		shipment.setWeight(weight);
		shipment.setWarehouse(warehouse.build());
		shipment.setShipping(shipping.build());
		shipment.setHash(hash);
		shipment.setLogisticsCenterAddress(logisticsCenterAddress.build());
		return shipment;
	}

	public CartDeliveryFakeBuilder done() {
		return parentBuilder;
	}

}
