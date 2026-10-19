package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.OptionValueView;

public class OptionValueViewFake implements OptionValueView {

	private int optionValueId;

	private String value;

	@Override
	public int getOptionValueId() {
		return optionValueId;
	}

	@Override
	public String getValue() {
		return value;
	}

	public void setOptionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
