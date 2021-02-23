package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.CartItem;

public class CartItemFake implements CartItem {

	private Integer id;

	private String hash;

	private String name;

	private CartItemType cartItemType;

	private Integer quantity;

	private Double weight;

	private Double subTotal;

	private Double total;

	private Double totalTaxes;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CartItemType getType() {
		return cartItemType;
	}

	@Override
	public Double getWeight() {
		return weight;
	}

	@Override
	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public Double getSubtotal() {
		return subTotal;
	}

	@Override
	public Double getTotal() {
		return total;
	}

	@Override
	public Double getTotalTaxes() {
		return totalTaxes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCartItemType(CartItemType cartItemType) {
		this.cartItemType = cartItemType;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setTotalTaxes(Double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

}
