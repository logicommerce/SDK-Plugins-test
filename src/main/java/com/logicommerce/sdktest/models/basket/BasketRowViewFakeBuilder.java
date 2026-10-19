package com.logicommerce.sdktest.models.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.basket.BasketRowView;

public class BasketRowViewFakeBuilder<T> {

	private T parentBuilder;
	private String hash;
	private int productId;
	private List<Integer> optionValueIds;
	private CartItemType type;
	private Integer bundleId;
	private String name;
	private String imageUrl;
	private long quantity;
	private long unitPrice;
	private long subtotal;
	private List<AllocationFakeBuilder<BasketRowViewFakeBuilder<T>>> discounts;
	private long total;

	public BasketRowViewFakeBuilder() {
		hash = "hash DEFAULT";
		productId = 0;
		optionValueIds = new ArrayList<>();
		type = CartItemType.PRODUCT;
		bundleId = null;
		name = "name DEFAULT";
		imageUrl = null;
		quantity = 1;
		unitPrice = 0;
		subtotal = 0;
		discounts = new ArrayList<>();
		total = 0;
	}

	public BasketRowViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public BasketRowViewFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public BasketRowViewFakeBuilder<T> productId(int productId) {
		this.productId = productId;
		return this;
	}

	public BasketRowViewFakeBuilder<T> optionValueIds(List<Integer> optionValueIds) {
		this.optionValueIds = optionValueIds;
		return this;
	}

	public BasketRowViewFakeBuilder<T> type(CartItemType type) {
		this.type = type;
		return this;
	}

	public BasketRowViewFakeBuilder<T> bundleId(Integer bundleId) {
		this.bundleId = bundleId;
		return this;
	}

	public BasketRowViewFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public BasketRowViewFakeBuilder<T> imageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public BasketRowViewFakeBuilder<T> quantity(long quantity) {
		this.quantity = quantity;
		return this;
	}

	public BasketRowViewFakeBuilder<T> unitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public BasketRowViewFakeBuilder<T> subtotal(long subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public AllocationFakeBuilder<BasketRowViewFakeBuilder<T>> discount() {
		AllocationFakeBuilder<BasketRowViewFakeBuilder<T>> discount = new AllocationFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public BasketRowViewFakeBuilder<T> total(long total) {
		this.total = total;
		return this;
	}

	public BasketRowView build() {
		BasketRowViewFake basketRowView = new BasketRowViewFake();
		basketRowView.setHash(hash);
		basketRowView.setProductId(productId);
		basketRowView.setOptionValueIds(optionValueIds);
		basketRowView.setType(type);
		basketRowView.setBundleId(bundleId);
		basketRowView.setName(name);
		basketRowView.setImageUrl(imageUrl);
		basketRowView.setQuantity(quantity);
		basketRowView.setUnitPrice(unitPrice);
		basketRowView.setSubtotal(subtotal);
		basketRowView.setDiscounts(discounts.stream().map(AllocationFakeBuilder::build).collect(Collectors.toList()));
		basketRowView.setTotal(total);
		return basketRowView;
	}

	public T done() {
		return parentBuilder;
	}
}
