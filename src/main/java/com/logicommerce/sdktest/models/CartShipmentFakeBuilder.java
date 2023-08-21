package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.CartShipment;

public class CartShipmentFakeBuilder {

	private CartDeliVeryFakeBuilder parentBuilder;
	private List<CartShipmentItemFakeBuilder> items;
	private double total;
	private double weight;
	private CartWarehouseFakeBuilder warehouse;
	private String taxCode;

	public CartShipmentFakeBuilder() {
		items = new ArrayList<>();
		warehouse = new CartWarehouseFakeBuilder(this);
		taxCode = "taxCode DEFAULT";

	}

	public CartShipmentFakeBuilder(CartDeliVeryFakeBuilder parentBuilder) {
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

	public CartShipmentFakeBuilder taxCode(String taxCode) {
		this.taxCode = taxCode;
		return this;
	}

	public CartWarehouseFakeBuilder warehouse() {
		return warehouse;
	}

	public CartShipment build() {
		CartShipmentFake shipment = new CartShipmentFake();
		shipment.setItems(items.stream()
			.map(CartShipmentItemFakeBuilder::build)
			.collect(Collectors.toList()));
		shipment.setTotal(total);
		shipment.setWeight(weight);
		shipment.setWarehouse(warehouse.build());
		shipment.setTaxCode(taxCode);
		return shipment;
	}

	public CartDeliVeryFakeBuilder done() {
		return parentBuilder;
	}

}
