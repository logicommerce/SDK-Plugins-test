package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.enums.AdditionalItemType;
import com.logicommerce.sdk.models.order.AdditionalItem;
import com.logicommerce.sdk.models.order.OrderTax;

public class AdditionalItemFakeBuilder {

	private CreditNoteFakeBuilder parentBuilder;
	private Integer id;
	private String name;
	private String comment;
	private AdditionalItemType type;
	private double amount;
	private List<OrderTax> taxes;

	public AdditionalItemFakeBuilder() {
		name = "name default";
		comment = "comment default";
		type = AdditionalItemType.VOUCHER;
		taxes = new ArrayList<>();
	}

	public AdditionalItemFakeBuilder(CreditNoteFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public AdditionalItemFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public AdditionalItemFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public AdditionalItemFakeBuilder comment(String comment) {
		this.comment = comment;
		return this;
	}

	public AdditionalItemFakeBuilder type(AdditionalItemType type) {
		this.type = type;
		return this;
	}

	public AdditionalItemFakeBuilder amount(double amount) {
		this.amount = amount;
		return this;
	}

	public AdditionalItemFakeBuilder taxes(List<OrderTax> taxes) {
		this.taxes = taxes;
		return this;
	}

	public AdditionalItem build() {
		AdditionalItemFake additionalItem = new AdditionalItemFake();
		additionalItem.setId(id);
		additionalItem.setName(name);
		additionalItem.setComment(comment);
		additionalItem.setType(type);
		additionalItem.setAmount(amount);
		additionalItem.setTaxes(taxes);
		return additionalItem;
	}

	public CreditNoteFakeBuilder done() {
		return parentBuilder;
	}
}
