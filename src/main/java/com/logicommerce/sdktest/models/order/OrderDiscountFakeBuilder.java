package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.builders.order.OrderDiscountBuilder;
import com.logicommerce.sdk.enums.BenefitMode;
import com.logicommerce.sdk.enums.CalculationMode;
import com.logicommerce.sdk.enums.DiscountApplyTo;
import com.logicommerce.sdk.enums.DiscountType;
import com.logicommerce.sdk.models.order.OrderDiscount;

public class OrderDiscountFakeBuilder<T> extends OrderDiscountBuilder<T> {

	public OrderDiscountFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderDiscountFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.name = "name DEFAULT";
		super.description = "description DEFAULT";
		super.applyTo = DiscountApplyTo.PRODUCT;
		super.discountTypeValue = DiscountType.AMOUNT;
		super.discountValue = 0d;
		super.minCondition = 0;
		super.maxCondition = 0;
		super.ticketCode = "ticketCode DEFAULT";
		super.expiryDate = LocalDateTime.now();
		super.amount = 0d;
		super.discountId = 0;
		super.triggeredBy = "triggeredBy DEFAULT";
		super.accumulateProducts = false;
		super.calculationMode = CalculationMode.FIXED_AMOUNT;
		super.benefitMode = BenefitMode.CHEAPEST;
	}

	public OrderDiscount build() {
		OrderDiscount discountSdk = super.build();
		OrderDiscountFake discountFake = new OrderDiscountFake();
		discountFake.setDiscountType(discountSdk.getDiscountType());
		discountFake.setId(super.id);
		discountFake.setName(discountSdk.getName());
		discountFake.setDescription(discountSdk.getDescription());
		discountFake.setApplyTo(discountSdk.getApplyTo());
		discountFake.setDiscountTypeValue(discountSdk.getDiscountTypeValue());
		discountFake.setDiscountValue(discountSdk.getDiscountValue());
		discountFake.setMinCondition(discountSdk.getMinCondition());
		discountFake.setMaxCondition(discountSdk.getMaxCondition());
		discountFake.setTicketCode(discountSdk.getTicketCode());
		discountFake.setExpiryDate(discountSdk.getExpiryDate());
		discountFake.setAmount(discountSdk.getAmount());
		discountFake.setDiscountId(discountSdk.getDiscountId());
		discountFake.setTriggeredBy(discountSdk.getTriggeredBy());
		discountFake.setAccumulateProducts(discountSdk.getAccumulateProducts());
		discountFake.setCalculationMode(discountSdk.getCalculationMode());
		discountFake.setBenefitMode(discountSdk.getBenefitMode());

		return discountFake;
	}
}