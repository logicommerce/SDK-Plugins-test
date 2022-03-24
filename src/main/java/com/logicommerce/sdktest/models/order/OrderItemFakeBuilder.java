package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.CustomTagBuilder;
import com.logicommerce.sdk.builders.order.OrderItemBuilder;
import com.logicommerce.sdk.builders.order.OrderItemTaxBuilder;
import com.logicommerce.sdk.enums.BackorderMode;
import com.logicommerce.sdk.models.order.OrderItem;
import com.logicommerce.sdktest.models.CustomTagFakeBuilder;
import com.logicommerce.sdktest.models.ProductCodesFakeBuilder;

public class OrderItemFakeBuilder<T> extends OrderItemBuilder<T> {


	public OrderItemFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}		
	
	private void defaultValues() {
		super.id = 0;
		super.pId = "pId DEFAULT";
		super.name = "name DEFAULT";
		super.quantity = 0;
		super.productId = 0;
		super.weight = 0d;
		super.prices = new OrderItemPricesFakeBuilder<>(this);
		super.vinculatedTo = 0;
		super.image = "image DEFAULT";
		super.sale = false;
		super.stockManagement = false;
		super.reverseChargeVat = false;
		super.codes = new ProductCodesFakeBuilder<>(this);
		super.noReturn = false;
		super.backOrder = BackorderMode.NONE;
		super.onRequest = false;
		super.onRequestDays = 0;
	}

	@Override
	public OrderItemTaxBuilder<OrderItemBuilder<T>> taxes() {
		OrderItemTaxBuilder<OrderItemBuilder<T>> tax = new OrderItemTaxFakeBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	@Override
	public OrderItemStockFakeBuilder<OrderItemBuilder<T>> stocks() {
		OrderItemStockFakeBuilder<OrderItemBuilder<T>> stock = new OrderItemStockFakeBuilder<>(this);
		stocks.add(stock);
		return stock;
	}

	@Override
	public CustomTagBuilder<OrderItemBuilder<T>> customTag() {
		CustomTagBuilder<OrderItemBuilder<T>> customTag = new CustomTagFakeBuilder<>(this);
		customTags.add(customTag);
		return customTag;
	}

	@Override
	public OrderDiscountFakeBuilder<OrderItemBuilder<T>> discount() {
		OrderDiscountFakeBuilder<OrderItemBuilder<T>> discount = new OrderDiscountFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	@Override
	public OrderItemOptionFakeBuilder<OrderItemBuilder<T>> options() {
		OrderItemOptionFakeBuilder<OrderItemBuilder<T>> option = new OrderItemOptionFakeBuilder<>(this);
		options.add(option);
		return option;
	}

	@Override
	public OrderItemFake build() {
		OrderItem itemSdk = super.build();
		OrderItemFake item = new OrderItemFake();
		item.setId(super.id);
		item.setPId(itemSdk.getPId());
		item.setTaxes(itemSdk.getTaxes());
		item.setOptions(itemSdk.getOptions());
		item.setStocks(itemSdk.getStocks());
		item.setCustomTags(itemSdk.getCustomTags());
		item.setDiscounts(itemSdk.getDiscounts());
		item.setName(itemSdk.getName());
		item.setQuantity(itemSdk.getQuantity());
		item.setProductId(itemSdk.getProductId());
		item.setWeight(itemSdk.getWeight());
		item.setPrices(itemSdk.getPrices());
		item.setVinculatedTo(itemSdk.getVinculatedTo());
		item.setImage(itemSdk.getImage());
		item.setSale(itemSdk.isSale());
		item.setStockManagement(itemSdk.isStockManagement());
		item.setReverseChargeVat(itemSdk.isReverseChargeVat());
		item.setCodes(itemSdk.getCodes());
		item.setNoReturn(itemSdk.isNoReturn());
		item.setBackOrder(itemSdk.getBackOrder());
		item.setOnRequest(itemSdk.isOnRequest());
		item.setOnRequestDays(itemSdk.getOnRequestDays());
		return item;
	}
}