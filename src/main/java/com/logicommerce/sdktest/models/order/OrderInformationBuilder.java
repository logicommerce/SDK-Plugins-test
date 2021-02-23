package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.order.OrderInformation;

public class OrderInformationBuilder {

	private OrderBuilder parentBuilder;

	private Integer id;

	private int channelId;

	private String transactionId;

	private String authNumber;

	private Integer marketplaceId;

	private Integer affiliateId;

	private String affiliateCode;

	private boolean commissionPaid;

	public OrderInformationBuilder() {
		id = 0;
		channelId = 0;
		transactionId = "transactionId DEFAULT";
		authNumber = "authNumber DEFAULT";
		marketplaceId = 0;
		affiliateId = 0;
		affiliateCode = "affiliateCode DEFAULT";
		commissionPaid = false;
	}

	public OrderInformationBuilder(OrderBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderInformationBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderInformationBuilder channelId(int channelId) {
		this.channelId = channelId;
		return this;
	}

	public OrderInformationBuilder transactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	public OrderInformationBuilder authNumber(String authNumber) {
		this.authNumber = authNumber;
		return this;
	}

	public OrderInformationBuilder marketplaceId(Integer marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public OrderInformationBuilder affiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
		return this;
	}

	public OrderInformationBuilder affiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
		return this;
	}

	public OrderInformationBuilder commissionPaid(boolean commissionPaid) {
		this.commissionPaid = commissionPaid;
		return this;
	}

	public OrderInformation build() {
		OrderInformationFake information = new OrderInformationFake();
		information.setId(id);
		information.setChannelId(channelId);
		information.setTransactionId(transactionId);
		information.setAuthNumber(authNumber);
		information.setMarketplaceId(marketplaceId);
		information.setAffiliateId(affiliateId);
		information.setAffiliateCode(affiliateCode);
		information.setCommissionPaid(commissionPaid);
		return information;
	}

	public OrderBuilder done() {
		return parentBuilder;
	}

}
