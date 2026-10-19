package com.logicommerce.sdktest.models.catalog;

import java.util.List;
import com.logicommerce.sdk.models.catalog.OptionValueView;
import com.logicommerce.sdk.models.catalog.OptionView;

public class OptionViewFake implements OptionView {

	private int optionId;

	private String name;

	private List<OptionValueView> values;

	@Override
	public int getOptionId() {
		return optionId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<OptionValueView> getValues() {
		return values;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValues(List<OptionValueView> values) {
		this.values = values;
	}
}
