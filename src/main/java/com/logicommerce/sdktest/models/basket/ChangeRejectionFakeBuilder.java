package com.logicommerce.sdktest.models.basket;

import com.logicommerce.sdk.enums.RejectionCode;
import com.logicommerce.sdk.models.basket.ChangeRejection;

public class ChangeRejectionFakeBuilder<T> {

	private T parentBuilder;
	private ChangeRejection.Target target;
	private int index;
	private RejectionCode code;
	private String detail;

	public ChangeRejectionFakeBuilder() {
		target = ChangeRejection.Target.ROW;
		index = 0;
		code = RejectionCode.ROW_NOT_BUYABLE;
		detail = null;
	}

	public ChangeRejectionFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public ChangeRejectionFakeBuilder<T> target(ChangeRejection.Target target) {
		this.target = target;
		return this;
	}

	public ChangeRejectionFakeBuilder<T> index(int index) {
		this.index = index;
		return this;
	}

	public ChangeRejectionFakeBuilder<T> code(RejectionCode code) {
		this.code = code;
		return this;
	}

	public ChangeRejectionFakeBuilder<T> detail(String detail) {
		this.detail = detail;
		return this;
	}

	public ChangeRejection build() {
		ChangeRejectionFake changeRejection = new ChangeRejectionFake();
		changeRejection.setTarget(target);
		changeRejection.setIndex(index);
		changeRejection.setCode(code);
		changeRejection.setDetail(detail);
		return changeRejection;
	}

	public T done() {
		return parentBuilder;
	}
}
