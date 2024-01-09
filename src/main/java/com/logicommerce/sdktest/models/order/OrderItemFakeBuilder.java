package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.CustomTagBuilder;
import com.logicommerce.sdk.enums.BackorderMode;
import com.logicommerce.sdktest.models.CustomTagFakeBuilder;
import com.logicommerce.sdktest.models.RowCodesFakeBuilder;

public class OrderItemFakeBuilder<T> {

	private T parentBuilder;
	private Integer id;
	private String pId;
	private String hash;
	private String name;
	private Integer productId;
	private int quantity;
	private double weight;
	private OrderItemPricesFakeBuilder<OrderItemFakeBuilder<T>> prices;
	private Integer vinculatedTo;
	private String image;
	private boolean sale;
	private boolean stockManagement;
	private boolean reverseChargeVat;
	private RowCodesFakeBuilder<OrderItemFakeBuilder<T>> codes;
	private boolean noReturn;
	private BackorderMode backOrder;
	private boolean onRequest;
	private int onRequestDays;
	private String link;
	private Integer combinationId;
	private String supplierReference;
	private List<OrderItemOptionFakeBuilder<OrderItemFakeBuilder<T>>> options;
	private List<OrderItemStockFakeBuilder<OrderItemFakeBuilder<T>>> stocks;
	private List<OrderItemTaxFakeBuilder<OrderItemFakeBuilder<T>>> taxes;
	private List<CustomTagFakeBuilder<OrderItemFakeBuilder<T>>> customTags;
	private List<OrderDiscountFakeBuilder<OrderItemFakeBuilder<T>>> discounts;

	public OrderItemFakeBuilder() {
		id = 0;
		pId = "pId DEFAULT";
		hash = "hash DEFAULT";
		name = "name DEFAULT";
		productId = 0;
		quantity = 0;
		weight = 0d;
		prices = new OrderItemPricesFakeBuilder<>(this);
		vinculatedTo = 0;
		image = "image DEFAULT";
		sale = false;
		stockManagement = false;
		reverseChargeVat = false;
		codes = new RowCodesFakeBuilder<>(this);
		noReturn = false;
		backOrder = BackorderMode.NONE;
		onRequest = false;
		onRequestDays = 0;
		link = "link DEFAULT";
		combinationId = 0;
		supplierReference = "supplierReference DEFAULT";
		options = new ArrayList<>();
		stocks = new ArrayList<>();
		taxes = new ArrayList<>();
		customTags = new ArrayList<>();
		discounts = new ArrayList<>();
	}

	public OrderItemFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemFakeBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemFakeBuilder<T> pId(String pId) {
		this.pId = pId;
		return this;
	}

	public OrderItemFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderItemFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OrderItemFakeBuilder<T> productId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public OrderItemFakeBuilder<T> quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderItemFakeBuilder<T> weight(double weight) {
		this.weight = weight;
		return this;
	}

	public OrderItemPricesFakeBuilder<OrderItemFakeBuilder<T>> prices() {
		return prices;
	}

	public OrderItemFakeBuilder<T> vinculatedTo(Integer vinculatedTo) {
		this.vinculatedTo = vinculatedTo;
		return this;
	}

	public OrderItemFakeBuilder<T> image(String image) {
		this.image = image;
		return this;
	}

	public OrderItemFakeBuilder<T> sale(boolean sale) {
		this.sale = sale;
		return this;
	}

	public OrderItemFakeBuilder<T> stockManagement(boolean stockManagement) {
		this.stockManagement = stockManagement;
		return this;
	}

	public OrderItemFakeBuilder<T> reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return this;
	}

	public RowCodesFakeBuilder<OrderItemFakeBuilder<T>> codes() {
		return codes;
	}

	public OrderItemFakeBuilder<T> noReturn(boolean noReturn) {
		this.noReturn = noReturn;
		return this;
	}

	public OrderItemFakeBuilder<T> backOrder(BackorderMode backOrder) {
		this.backOrder = backOrder;
		return this;
	}

	public OrderItemFakeBuilder<T> onRequest(boolean onRequest) {
		this.onRequest = onRequest;
		return this;
	}

	public OrderItemFakeBuilder<T> onRequestDays(int onRequestDays) {
		this.onRequestDays = onRequestDays;
		return this;
	}

	public OrderItemFakeBuilder<T> link(String link) {
		this.link = link;
		return this;
	}

	public OrderItemFakeBuilder<T> combinationId(Integer combinationId) {
		this.combinationId = combinationId;
		return this;
	}

	public OrderItemFakeBuilder<T> supplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
		return this;
	}

	public OrderItemTaxFakeBuilder<OrderItemFakeBuilder<T>> taxes() {
		OrderItemTaxFakeBuilder<OrderItemFakeBuilder<T>> tax = new OrderItemTaxFakeBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderItemStockFakeBuilder<OrderItemFakeBuilder<T>> stocks() {
		OrderItemStockFakeBuilder<OrderItemFakeBuilder<T>> stock = new OrderItemStockFakeBuilder<>(this);
		stocks.add(stock);
		return stock;
	}

	public CustomTagBuilder<OrderItemFakeBuilder<T>> customTag() {
		CustomTagFakeBuilder<OrderItemFakeBuilder<T>> customTag = new CustomTagFakeBuilder<>(this);
		customTags.add(customTag);
		return customTag;
	}

	public OrderDiscountFakeBuilder<OrderItemFakeBuilder<T>> discount() {
		OrderDiscountFakeBuilder<OrderItemFakeBuilder<T>> discount = new OrderDiscountFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public OrderItemOptionFakeBuilder<OrderItemFakeBuilder<T>> options() {
		OrderItemOptionFakeBuilder<OrderItemFakeBuilder<T>> option = new OrderItemOptionFakeBuilder<>(this);
		options.add(option);
		return option;
	}

	public OrderItemFake build() {
		OrderItemFake item = new OrderItemFake();
		item.setId(id);
		item.setPId(pId);
		item.setHash(hash);
		item.setName(name);
		item.setProductId(productId);
		item.setQuantity(quantity);
		item.setWeight(weight);
		item.setPrices(prices.build());
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
		item.setLink(link);
		item.setCombinationId(combinationId);
		item.setSupplierReference(supplierReference);

		item.setOptions(options.stream().map(OrderItemOptionFakeBuilder::build).collect(Collectors.toList()));
		item.setTaxes(taxes.stream().map(OrderItemTaxFakeBuilder::build).collect(Collectors.toList()));
		item.setStocks(stocks.stream().map(OrderItemStockFakeBuilder::build).collect(Collectors.toList()));
		item.setCustomTags(customTags.stream().map(CustomTagFakeBuilder::build).collect(Collectors.toList()));
		item.setDiscounts(discounts.stream().map(OrderDiscountFakeBuilder::build).collect(Collectors.toList()));
		return item;
	}

	public T done() {
		return parentBuilder;
	}
}
