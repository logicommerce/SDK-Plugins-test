package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemTaxBuilder;
import com.logicommerce.sdk.builders.order.OrderShippingBuilder;
import com.logicommerce.sdk.enums.ShippingCalculation;
import com.logicommerce.sdk.models.order.OrderShipping;

public class OrderShippingFakeBuilder<T> extends OrderShippingBuilder<T> {

	public OrderShippingFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderShippingFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.shippingTypeId = 0;
		super.name = "name DEFAULT";
		super.price = 0d;
		super.shippingTypeName = "shippingTypeName DEFAULT";
		super.shippingSectionId = 0;
		super.shippingCalculation = ShippingCalculation.BY_WEIGHT;
		super.shipperPId = "shipperPId DEFAULT";
		super.shippingTypePId = "shippingTypePId DEFAULT";
		super.cashOnDelivery = false;
		super.tracking = new OrderShippingTrackingFakeBuilder<>(this);
	}

	public OrderItemTaxBuilder<OrderShippingBuilder<T>> tax() {
		OrderItemTaxBuilder<OrderShippingBuilder<T>> tax = new OrderItemTaxFakeBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public OrderDiscountFakeBuilder<OrderShippingBuilder<T>> discount() {
		OrderDiscountFakeBuilder<OrderShippingBuilder<T>> discount = new OrderDiscountFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}
	
	public OrderShippingTrackingFakeBuilder<OrderShippingBuilder<T>> tracking() {
		OrderShippingTrackingFakeBuilder<OrderShippingBuilder<T>> tracking = new OrderShippingTrackingFakeBuilder<>(this); 
		this.tracking = tracking;
		return tracking;
	}
	
	@Override
	public OrderShipping build() {
		OrderShipping shipping = super.build();		
		OrderShippingFake shippingFake = new OrderShippingFake();
		shippingFake.setId(super.id);
		shippingFake.setShippingTypeId(shipping.getShippingTypeId());
		shippingFake.setName(shipping.getName());
		shippingFake.setPrice(shipping.getPrice());
		shippingFake.setShippingTypeName(shipping.getShippingTypeName());
		shippingFake.setShippingSectionId(shipping.getShippingSectionId());
		shippingFake.setShippingCalculation(shipping.getShippingCalculation());
		shippingFake.setShipperPId(shipping.getShipperPId());
		shippingFake.setShippingTypePId(shipping.getShippingTypePId());
		shippingFake.setCashOnDelivery(shipping.isCashOnDelivery());
		shippingFake.setTaxes(shipping.getTaxes());
		shippingFake.setDiscounts(shipping.getDiscounts());
		shippingFake.setTracking(shipping.getTracking());
		return shippingFake;
	}
}