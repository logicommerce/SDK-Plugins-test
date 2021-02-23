package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.enums.BenefitMode;
import com.logicommerce.sdk.enums.CalculationMode;
import com.logicommerce.sdk.enums.DiscountApplyTo;
import com.logicommerce.sdk.enums.DiscountType;
import com.logicommerce.sdk.models.order.OrderDiscount;

public class OrderDiscountBuilder<T> {

	private T parentBuilder;

	private int discountType;

	private Integer id;

	private String name;

	private String description;

	private DiscountApplyTo applyTo;

	private DiscountType discountTypeValue;

	private Double discountValue;

	private Integer minCondition;

	private Integer maxCondition;

	private String ticketCode;

	private LocalDateTime expiryDate;

	private Double amount;

	private Integer discountId;

	private String triggeredBy;

	private boolean accumulateProducts;

	private CalculationMode calculationMode;

	private BenefitMode benefitMode;

	public OrderDiscountBuilder() {
		id = 0;
		name = "name DEFAULT";
		description = "description DEFAULT";
		applyTo = DiscountApplyTo.PRODUCT;
		discountTypeValue = DiscountType.AMOUNT;
		discountValue = 0d;
		minCondition = 0;
		maxCondition = 0;
		ticketCode = "ticketCode DEFAULT";
		expiryDate = LocalDateTime.now();
		amount = 0d;
		discountId = 0;
		triggeredBy = "triggeredBy DEFAULT";
		accumulateProducts = false;
		calculationMode = CalculationMode.FIXED_AMOUNT;
		benefitMode = BenefitMode.CHEAPEST;
	}

	public OrderDiscountBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderDiscountBuilder<T> discountType(int discountType) {
		this.discountType = discountType;
		return this;
	}
	
	public OrderDiscountBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderDiscountBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OrderDiscountBuilder<T> description(String description) {
		this.description = description;
		return this;
	}

	public OrderDiscountBuilder<T> applyTo(DiscountApplyTo applyTo) {
		this.applyTo = applyTo;
		return this;
	}

	public OrderDiscountBuilder<T> discountTypeValue(DiscountType discountTypeValue) {
		this.discountTypeValue = discountTypeValue;
		return this;
	}

	public OrderDiscountBuilder<T> discountValue(Double discountValue) {
		this.discountValue = discountValue;
		return this;
	}

	public OrderDiscountBuilder<T> minCondition(Integer minCondition) {
		this.minCondition = minCondition;
		return this;
	}

	public OrderDiscountBuilder<T> maxCondition(Integer maxCondition) {
		this.maxCondition = maxCondition;
		return this;
	}

	public OrderDiscountBuilder<T> ticketCode(String ticketCode) {
		this.ticketCode = ticketCode;
		return this;
	}

	public OrderDiscountBuilder<T> expiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}

	public OrderDiscountBuilder<T> amount(Double amount) {
		this.amount = amount;
		return this;
	}

	public OrderDiscountBuilder<T> discountId(Integer discountId) {
		this.discountId = discountId;
		return this;
	}

	public OrderDiscountBuilder<T> triggeredBy(String triggeredBy) {
		this.triggeredBy = triggeredBy;
		return this;
	}

	public OrderDiscountBuilder<T> accumulateProducts(boolean accumulateProducts) {
		this.accumulateProducts = accumulateProducts;
		return this;
	}

	public OrderDiscountBuilder<T> calculationMode(CalculationMode calculationMode) {
		this.calculationMode = calculationMode;
		return this;
	}

	public OrderDiscountBuilder<T> benefitMode(BenefitMode benefitMode) {
		this.benefitMode = benefitMode;
		return this;
	}

	public OrderDiscount build() {
		OrderDiscountFake discount = new OrderDiscountFake();
		discount.setDiscountType(discountType);
		discount.setId(id);
		discount.setName(name);
		discount.setDescription(description);
		discount.setApplyTo(applyTo);
		discount.setDiscountTypeValue(discountTypeValue);
		discount.setDiscountValue(discountValue);
		discount.setMinCondition(minCondition);
		discount.setMaxCondition(maxCondition);
		discount.setTicketCode(ticketCode);
		discount.setExpiryDate(expiryDate);
		discount.setAmount(amount);
		discount.setDiscountId(discountId);
		discount.setTriggeredBy(triggeredBy);
		discount.setAccumulateProducts(accumulateProducts);
		discount.setCalculationMode(calculationMode);
		discount.setBenefitMode(benefitMode);
		return discount;
	}

	public T done() {
		return parentBuilder;
	}

}
