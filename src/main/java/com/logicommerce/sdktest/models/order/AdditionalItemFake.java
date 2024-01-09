package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.AdditionalItemType;
import com.logicommerce.sdk.models.order.AdditionalItem;
import com.logicommerce.sdk.models.order.OrderTax;

public class AdditionalItemFake implements AdditionalItem {

	private Integer id;
	private String name;
	private String comment;
	private AdditionalItemType type;
	private double amount;
	private List<OrderTax> taxes;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public AdditionalItemType getType() {
		return type;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public List<OrderTax> getTaxes() {
		return taxes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setType(AdditionalItemType type) {
		this.type = type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTaxes(List<OrderTax> taxes) {
		this.taxes = taxes;
	}

}
