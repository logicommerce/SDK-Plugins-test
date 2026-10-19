package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.enums.RejectionCode;
import com.logicommerce.sdk.models.basket.ChangeRejection;

public class ChangeRejectionFake implements ChangeRejection {

	private ChangeRejection.Target target;

	private int index;

	private RejectionCode code;

	private String detail;

	@Override
	public ChangeRejection.Target getTarget() {
		return target;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public RejectionCode getCode() {
		return code;
	}

	@Override
	public String getDetail() {
		return detail;
	}

	public void setTarget(ChangeRejection.Target target) {
		this.target = target;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setCode(RejectionCode code) {
		this.code = code;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
