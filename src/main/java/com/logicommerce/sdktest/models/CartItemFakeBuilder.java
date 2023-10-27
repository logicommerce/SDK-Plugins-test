package com.logicommerce.sdktest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.models.CartItem;

public class CartItemFakeBuilder {

	private CartFakeBuilder parentBuilder;
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
	private RowCodesFakeBuilder<CartItemFakeBuilder> codes;
	private String urlSeo;
	private String imageUrl;
	private BrandFakeBuilder brand;
	private CategoryFakeBuilder mainCategory;
	private String taxCode;
	private List<CartDiscountFakeBuilder<CartItemFakeBuilder>> discounts;

	public CartItemFakeBuilder() {
		id = 1;
		hash = "hash DEFAULT";
		name = "name DEFAULT";
		cartItemType = CartItemType.PRODUCT;
		quantity = 1;
		weight = 0.0;
		unitPrice = 0.0;
		subTotal = 0.0;
		total = 0.0;
		totalTaxes = 0.0;
		codes = new RowCodesFakeBuilder<>(this);
		brand = new BrandFakeBuilder(this);
		mainCategory = new CategoryFakeBuilder(this);
		taxCode = "taxCode DEFAULT";
		discounts = new ArrayList<>();
	}

	public CartItemFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CartItemFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public CartItemFakeBuilder hash(String hash) {
		this.hash = hash;
		return this;
	}

	public CartItemFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CartItemFakeBuilder cartItemType(CartItemType cartItemType) {
		this.cartItemType = cartItemType;
		return this;
	}

	public CartItemFakeBuilder quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public CartItemFakeBuilder weight(Double weight) {
		this.weight = weight;
		return this;
	}

	public CartItemFakeBuilder unitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public CartItemFakeBuilder subTotal(Double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public CartItemFakeBuilder total(Double total) {
		this.total = total;
		return this;
	}

	public CartItemFakeBuilder totalTaxes(Double totalTaxes) {
		this.totalTaxes = totalTaxes;
		return this;
	}

	public RowCodesFakeBuilder<CartItemFakeBuilder> codes() {
		return codes;
	}

	public CartItemFakeBuilder urlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
		return this;
	}

	public CartItemFakeBuilder imageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public BrandFakeBuilder brand() {
		return brand;
	}

	public CategoryFakeBuilder mainCategory() {
		return mainCategory;
	}

	public CartItemFakeBuilder taxCode(String taxCode) {
		this.taxCode = taxCode;
		return this;
	}

	public CartDiscountFakeBuilder<CartItemFakeBuilder> discount() {
		var discount = new CartDiscountFakeBuilder<CartItemFakeBuilder>(this);
		discounts.add(discount);
		return discount;
	}

	public CartItem build() {
		CartItemFake cartItem = new CartItemFake();
		cartItem.setId(id);
		cartItem.setHash(hash);
		cartItem.setName(name);
		cartItem.setCartItemType(cartItemType);
		cartItem.setQuantity(quantity);
		cartItem.setWeight(weight);
		cartItem.setUnitPrice(unitPrice);
		cartItem.setSubTotal(subTotal);
		cartItem.setTotal(total);
		cartItem.setTotalTaxes(totalTaxes);
		cartItem.setCodes(codes.build());
		cartItem.setUrlSeo(urlSeo);
		cartItem.setImageUrl(imageUrl);
		cartItem.setBrand(brand.build());
		cartItem.setMainCategory(mainCategory.build());
		cartItem.setTaxCode(taxCode);
		cartItem.setDiscounts(discounts.stream()
			.map(CartDiscountFakeBuilder::build)
			.collect(Collectors.toList()));
		return cartItem;
	}

	public CartFakeBuilder done() {
		return parentBuilder;
	}
}
