package com.logicommerce.sdktest.models.basket;

import java.util.List;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.basket.Allocation;
import com.logicommerce.sdk.models.basket.BasketRowView;

public class BasketRowViewFake implements BasketRowView {

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

	private List<Allocation> discounts;

	private long total;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public int getProductId() {
		return productId;
	}

	@Override
	public List<Integer> getOptionValueIds() {
		return optionValueIds;
	}

	@Override
	public CartItemType getType() {
		return type;
	}

	@Override
	public Integer getBundleId() {
		return bundleId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public long getQuantity() {
		return quantity;
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

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setOptionValueIds(List<Integer> optionValueIds) {
		this.optionValueIds = optionValueIds;
	}

	public void setType(CartItemType type) {
		this.type = type;
	}

	public void setBundleId(Integer bundleId) {
		this.bundleId = bundleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
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
