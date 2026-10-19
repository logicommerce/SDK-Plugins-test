package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.enums.VoucherCodeStatus;
import com.logicommerce.sdk.models.basket.VoucherCodeResult;

public class VoucherCodeResultFake implements VoucherCodeResult {

	private String code;

	private VoucherCodeStatus status;

	private String errorCode;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public VoucherCodeStatus getStatus() {
		return status;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(VoucherCodeStatus status) {
		this.status = status;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
