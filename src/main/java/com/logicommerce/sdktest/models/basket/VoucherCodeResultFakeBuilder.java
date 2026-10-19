package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.enums.VoucherCodeStatus;
import com.logicommerce.sdk.models.basket.VoucherCodeResult;

public class VoucherCodeResultFakeBuilder<T> {

	private T parentBuilder;
	private String code;
	private VoucherCodeStatus status;
	private String errorCode;

	public VoucherCodeResultFakeBuilder() {
		code = "code DEFAULT";
		status = VoucherCodeStatus.APPLIED;
		errorCode = null;
	}

	public VoucherCodeResultFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public VoucherCodeResultFakeBuilder<T> code(String code) {
		this.code = code;
		return this;
	}

	public VoucherCodeResultFakeBuilder<T> status(VoucherCodeStatus status) {
		this.status = status;
		return this;
	}

	public VoucherCodeResultFakeBuilder<T> errorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public VoucherCodeResult build() {
		VoucherCodeResultFake voucherCodeResult = new VoucherCodeResultFake();
		voucherCodeResult.setCode(code);
		voucherCodeResult.setStatus(status);
		voucherCodeResult.setErrorCode(errorCode);
		return voucherCodeResult;
	}

	public T done() {
		return parentBuilder;
	}
}
