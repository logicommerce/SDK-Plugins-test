package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.OptionValueView;

public class OptionValueViewFakeBuilder<T> {

	private T parentBuilder;
	private int optionValueId;
	private String value;

	public OptionValueViewFakeBuilder() {
		optionValueId = 0;
		value = "value DEFAULT";
	}

	public OptionValueViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OptionValueViewFakeBuilder<T> optionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
		return this;
	}

	public OptionValueViewFakeBuilder<T> value(String value) {
		this.value = value;
		return this;
	}

	public OptionValueView build() {
		OptionValueViewFake optionValueView = new OptionValueViewFake();
		optionValueView.setOptionValueId(optionValueId);
		optionValueView.setValue(value);
		return optionValueView;
	}

	public T done() {
		return parentBuilder;
	}
}
