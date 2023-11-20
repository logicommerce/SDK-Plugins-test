package com.logicommerce.sdktest.models;

import java.util.List;
import com.logicommerce.sdk.models.CartShipment;
import com.logicommerce.sdk.models.CartShipmentItem;
import com.logicommerce.sdk.models.CartShipping;
import com.logicommerce.sdk.models.CartWarehouse;

public class CartShipmentFake implements CartShipment {

	private List<CartShipmentItem> items;
	private double total;
	private double weight;
	private CartWarehouse warehouse;
	private CartShipping shipping;
	private String hash;

	@Override
	public List<CartShipmentItem> getItems() {
		return items;
	}

	@Override
	public double getTotal() {
		return total;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public CartWarehouse getWarehouse() {
		return warehouse;
	}

	@Override
	public CartShipping getShipping() {
		return shipping;
	}

	@Override
	public String getHash() {
		return hash;
	}

	public void setItems(List<CartShipmentItem> items) {
		this.items = items;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setWarehouse(CartWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void setShipping(CartShipping shipping) {
		this.shipping = shipping;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
