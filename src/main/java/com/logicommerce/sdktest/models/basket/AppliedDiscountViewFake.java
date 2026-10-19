package com.logicommerce.sdktest.models.basket;

import java.util.List;
import com.logicommerce.sdk.enums.DiscountApplyTo;
import com.logicommerce.sdk.models.basket.AppliedDiscountView;
import com.logicommerce.sdk.models.basket.RowAllocation;

public class AppliedDiscountViewFake implements AppliedDiscountView {

	private int discountId;

	private String name;

	private String code;

	private DiscountApplyTo applyTo;

	private long amount;

	private List<RowAllocation> rows;

	@Override
	public int getDiscountId() {
		return discountId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public DiscountApplyTo getApplyTo() {
		return applyTo;
	}

	@Override
	public long getAmount() {
		return amount;
	}

	@Override
	public List<RowAllocation> getRows() {
		return rows;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setApplyTo(DiscountApplyTo applyTo) {
		this.applyTo = applyTo;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setRows(List<RowAllocation> rows) {
		this.rows = rows;
	}
}
