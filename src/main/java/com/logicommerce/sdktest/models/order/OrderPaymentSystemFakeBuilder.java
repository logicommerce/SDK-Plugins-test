package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderPaymentSystemBuilder;
import com.logicommerce.sdk.builders.order.OrderTaxBuilder;
import com.logicommerce.sdk.enums.AmountType;
import com.logicommerce.sdk.models.order.OrderPaymentSystem;

public class OrderPaymentSystemFakeBuilder<T> extends OrderPaymentSystemBuilder<T> {

	public OrderPaymentSystemFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderPaymentSystemFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.paymentSystemId = 0;
		super.name = "name DEFAULT";
		super.increaseType = AmountType.ABSOLUTE;
		super.increaseValue = 0d;
		super.price = 0d;
		super.increaseMin = 0d;
		super.cashOnDelivery = false;
		super.property = "";		
	}

	@Override
	public OrderTaxBuilder<OrderPaymentSystemBuilder<T>> tax() {
		OrderTaxBuilder<OrderPaymentSystemBuilder<T>> tax = new OrderTaxFakeBuilder<>(this);
		super.taxes.add(tax);
		return tax;
	}

	public OrderPaymentSystem build() {
		OrderPaymentSystem paymentSystemSdk = super.build();
		OrderPaymentSystemFake paymentSystem = new OrderPaymentSystemFake();
		paymentSystem.setId(super.id);
		paymentSystem.setPaymentSystemId(paymentSystemSdk.getPaymentSystemId());
		paymentSystem.setTaxes(paymentSystemSdk.getTaxes());
		paymentSystem.setName(paymentSystemSdk.getName());
		paymentSystem.setIncreaseType(paymentSystemSdk.getIncreaseType());
		paymentSystem.setIncreaseValue(paymentSystemSdk.getIncreaseValue());
		paymentSystem.setPrice(paymentSystemSdk.getPrice());
		paymentSystem.setIncreaseMin(paymentSystemSdk.getIncreaseMin());
		paymentSystem.setCashOnDelivery(paymentSystemSdk.isCashOnDelivery());
		paymentSystem.setProperty(paymentSystemSdk.getProperty());

		return paymentSystem;
	}
}