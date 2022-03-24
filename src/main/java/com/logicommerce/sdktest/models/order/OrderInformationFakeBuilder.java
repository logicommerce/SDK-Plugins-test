package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderInformationBuilder;
import com.logicommerce.sdk.models.order.OrderInformation;

public class OrderInformationFakeBuilder<T> extends OrderInformationBuilder<T> {
	
	public OrderInformationFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderInformationFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.channelId = 0;
		super.transactionId = "transactionId DEFAULT";
		super.authNumber = "authNumber DEFAULT";
		super.marketplaceId = 0;
		super.commissionPaid = false;
	}

	@Override
	public OrderInformation build() {
		OrderInformation orderInformationSdk = super.build();
		OrderInformationFake orderInformationFake = new OrderInformationFake();
		orderInformationFake.setId(super.id);
		orderInformationFake.setAuthNumber(orderInformationSdk.getAuthNumber());
		orderInformationFake.setChannelId(orderInformationSdk.getChannelId());
		orderInformationFake.setCommissionPaid(orderInformationSdk.isCommissionPaid());
		orderInformationFake.setMarketplaceId(orderInformationSdk.getMarketplaceId());
		orderInformationFake.setTransactionId(orderInformationSdk.getTransactionId());

		return orderInformationFake;
	}
}