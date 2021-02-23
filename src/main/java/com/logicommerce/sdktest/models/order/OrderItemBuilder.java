package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.BackorderMode;
import com.logicommerce.sdktest.models.CustomTagBuilder;
import com.logicommerce.sdktest.models.ProductCodesBuilder;

public class OrderItemBuilder {

	private OrderBuilder parentBuilder;

	private Integer id;

	private String pId;

	private List<OrderItemTaxBuilder<OrderItemBuilder>> taxes;

	private List<OrderItemOptionBuilder> options;

	private List<OrderItemStockBuilder> stocks;

	private List<CustomTagBuilder<OrderItemBuilder>> customTags;

	private List<OrderDiscountBuilder<OrderItemBuilder>> discounts;

	private String name;

	private int quantity;

	private Integer productId;

	private double weight;

	private OrderItemPricesBuilder prices;

	private double affiliatePercentCommission;

	private Integer vinculatedTo;

	private String image;

	private boolean sale;

	private boolean stockManagement;

	private boolean reverseChargeVat;

	private ProductCodesBuilder<OrderItemBuilder> codes;

	private boolean noReturn;

	private BackorderMode backOrder;

	private boolean onRequest;

	private int onRequestDays;

	public OrderItemBuilder() {
		id = 0;
		pId = "pId DEFAULT";
		taxes = new ArrayList<>();
		options = new ArrayList<>();
		stocks = new ArrayList<>();
		customTags = new ArrayList<>();
		discounts = new ArrayList<>();
		name = "name DEFAULT";
		quantity = 0;
		productId = 0;
		weight = 0d;
		prices = new OrderItemPricesBuilder(this);
		affiliatePercentCommission = 0d;
		vinculatedTo = 0;
		image = "image DEFAULT";
		sale = false;
		stockManagement = false;
		reverseChargeVat = false;
		codes = new ProductCodesBuilder<>(this);
		noReturn = false;
		backOrder = BackorderMode.NONE;
		onRequest = false;
		onRequestDays = 0;
	}

	public OrderItemBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemBuilder pId(String pId) {
		this.pId = pId;
		return this;
	}

	public OrderItemTaxBuilder<OrderItemBuilder> taxes() {
		OrderItemTaxBuilder<OrderItemBuilder> tax = new OrderItemTaxBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderItemOptionBuilder options() {
		OrderItemOptionBuilder option = new OrderItemOptionBuilder(this);
		options.add(option);
		return option;
	}

	public OrderItemStockBuilder stocks() {
		OrderItemStockBuilder stock = new OrderItemStockBuilder(this);
		stocks.add(stock);
		return stock;
	}

	public CustomTagBuilder<OrderItemBuilder> customTag() {
		CustomTagBuilder<OrderItemBuilder> customTag = new CustomTagBuilder<>(this);
		customTags.add(customTag);
		return customTag;
	}

	public OrderDiscountBuilder<OrderItemBuilder> discount() {
		OrderDiscountBuilder<OrderItemBuilder> discount = new OrderDiscountBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public OrderItemBuilder name(String name) {
		this.name = name;
		return this;
	}

	public OrderItemBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderItemBuilder productId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public OrderItemBuilder weight(double weight) {
		this.weight = weight;
		return this;
	}

	public OrderItemPricesBuilder prices() {
		return prices;
	}

	public OrderItemBuilder affiliatePercentCommission(double affiliatePercentCommission) {
		this.affiliatePercentCommission = affiliatePercentCommission;
		return this;
	}

	public OrderItemBuilder vinculatedTo(Integer vinculatedTo) {
		this.vinculatedTo = vinculatedTo;
		return this;
	}

	public OrderItemBuilder image(String image) {
		this.image = image;
		return this;
	}

	public OrderItemBuilder sale(boolean sale) {
		this.sale = sale;
		return this;
	}

	public OrderItemBuilder stockManagement(boolean stockManagement) {
		this.stockManagement = stockManagement;
		return this;
	}

	public OrderItemBuilder reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return this;
	}

	public ProductCodesBuilder<OrderItemBuilder> codes() {
		return codes;
	}

	public OrderItemBuilder noReturn(boolean noReturn) {
		this.noReturn = noReturn;
		return this;
	}

	public OrderItemBuilder backOrder(BackorderMode backOrder) {
		this.backOrder = backOrder;
		return this;
	}

	public OrderItemBuilder onRequest(boolean onRequest) {
		this.onRequest = onRequest;
		return this;
	}

	public OrderItemBuilder onRequestDays(int onRequestDays) {
		this.onRequestDays = onRequestDays;
		return this;
	}

	public OrderItemFake build() {
		OrderItemFake item = new OrderItemFake();
		item.setId(id);
		item.setPId(pId);
		item.setTaxes(taxes.stream().map(OrderItemTaxBuilder::build).collect(Collectors.toList()));
		item.setOptions(options.stream().map(OrderItemOptionBuilder::build).collect(Collectors.toList()));
		item.setStocks(stocks.stream().map(OrderItemStockBuilder::build).collect(Collectors.toList()));
		item.setCustomTags(customTags.stream().map(CustomTagBuilder::build).collect(Collectors.toList()));
		item.setDiscounts(discounts.stream().map(OrderDiscountBuilder::build).collect(Collectors.toList()));
		item.setName(name);
		item.setQuantity(quantity);
		item.setProductId(productId);
		item.setWeight(weight);
		item.setPrices(prices.build());
		item.setAffiliatePercentCommission(affiliatePercentCommission);
		item.setVinculatedTo(vinculatedTo);
		item.setImage(image);
		item.setSale(sale);
		item.setStockManagement(stockManagement);
		item.setReverseChargeVat(reverseChargeVat);
		item.setCodes(codes.build());
		item.setNoReturn(noReturn);
		item.setBackOrder(backOrder);
		item.setOnRequest(onRequest);
		item.setOnRequestDays(onRequestDays);
		return item;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
