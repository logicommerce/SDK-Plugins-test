package com.logicommerce.sdktest.models.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.catalog.OptionView;

public class OptionViewFakeBuilder<T> {

	private T parentBuilder;
	private int optionId;
	private String name;
	private List<OptionValueViewFakeBuilder<OptionViewFakeBuilder<T>>> values;

	public OptionViewFakeBuilder() {
		optionId = 0;
		name = "name DEFAULT";
		values = new ArrayList<>();
	}

	public OptionViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OptionViewFakeBuilder<T> optionId(int optionId) {
		this.optionId = optionId;
		return this;
	}

	public OptionViewFakeBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public OptionValueViewFakeBuilder<OptionViewFakeBuilder<T>> value() {
		OptionValueViewFakeBuilder<OptionViewFakeBuilder<T>> value = new OptionValueViewFakeBuilder<>(this);
		values.add(value);
		return value;
	}

	public OptionView build() {
		OptionViewFake optionView = new OptionViewFake();
		optionView.setOptionId(optionId);
		optionView.setName(name);
		optionView.setValues(values.stream().map(OptionValueViewFakeBuilder::build).collect(Collectors.toList()));
		return optionView;
	}

	public T done() {
		return parentBuilder;
	}
}
