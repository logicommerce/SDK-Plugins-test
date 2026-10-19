package com.logicommerce.sdktest.models.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.DiscountApplyTo;
import com.logicommerce.sdk.models.basket.AppliedDiscountView;

public class AppliedDiscountViewFakeBuilder<T> {

	private T parentBuilder;
	private int discountId;
	private String name;
	private String code;
	private DiscountApplyTo applyTo;
	private long amount;
	private List<RowAllocationFakeBuilder<AppliedDiscountViewFakeBuilder<T>>> rows;

	public AppliedDiscountViewFakeBuilder() {
		discountId = 0;
		name = "name DEFAULT";
		code = null;
		applyTo = DiscountApplyTo.TOTAL;
		amount = 0;
		rows = new ArrayList<>();
	}

	public AppliedDiscountViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public AppliedDiscountViewFakeBuilder<T> discountId(int discountId) {
		this.discountId = discountId;
		return this;
	}

	public AppliedDiscountViewFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public AppliedDiscountViewFakeBuilder<T> code(String code) {
		this.code = code;
		return this;
	}

	public AppliedDiscountViewFakeBuilder<T> applyTo(DiscountApplyTo applyTo) {
		this.applyTo = applyTo;
		return this;
	}

	public AppliedDiscountViewFakeBuilder<T> amount(long amount) {
		this.amount = amount;
		return this;
	}

	public RowAllocationFakeBuilder<AppliedDiscountViewFakeBuilder<T>> row() {
		RowAllocationFakeBuilder<AppliedDiscountViewFakeBuilder<T>> row = new RowAllocationFakeBuilder<>(this);
		rows.add(row);
		return row;
	}

	public AppliedDiscountView build() {
		AppliedDiscountViewFake appliedDiscountView = new AppliedDiscountViewFake();
		appliedDiscountView.setDiscountId(discountId);
		appliedDiscountView.setName(name);
		appliedDiscountView.setCode(code);
		appliedDiscountView.setApplyTo(applyTo);
		appliedDiscountView.setAmount(amount);
		appliedDiscountView.setRows(rows.stream().map(RowAllocationFakeBuilder::build).collect(Collectors.toList()));
		return appliedDiscountView;
	}

	public T done() {
		return parentBuilder;
	}
}
