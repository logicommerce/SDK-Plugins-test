package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.Brand;
import com.logicommerce.sdk.models.CartDiscount;
import com.logicommerce.sdk.models.CartItem;
import com.logicommerce.sdk.models.Category;
import com.logicommerce.sdk.models.CustomTag;
import com.logicommerce.sdk.models.RowCodes;

public class CartItemFake implements CartItem {

	private Integer id;
	private String hash;
	private String name;
	private CartItemType cartItemType;
	private Integer quantity;
	private Double weight;
	private Double unitPrice;
	private Double subTotal;
	private Double total;
	private Double totalTaxes;
	private RowCodes codes;
	private String urlSeo;
	private String imageUrl;
	private Brand brand;
	private Category mainCategory;
	private List<CustomTag> customTags = new ArrayList<>();
	private List<CustomTag> customTagPluginValues = new ArrayList<>();
	private String taxCode;
	private List<CartDiscount> discounts = new ArrayList<>();

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

	@Override
	public List<CustomTag> getCustomTagValues() {
		return customTags;
	}

	@Override
	public List<CustomTag> getCustomTagPluginValues() {
		return customTagPluginValues;
	}

	@Override
	public String getUrlSeo() {
		return urlSeo;
	}

	public void setUrlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public Double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}

	@Override
	public Category getMainCategory() {
		return mainCategory;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setMainCategory(Category mainCategory) {
		this.mainCategory = mainCategory;
	}

	@Override
	public RowCodes getCodes() {
		return codes;
	}

	public void setCodes(RowCodes codes) {
		this.codes = codes;
	}

	@Override
	public String getTaxCode() {
		return this.taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	@Override
	public List<CartDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<CartDiscount> discounts) {
		this.discounts = discounts;
	}
}
