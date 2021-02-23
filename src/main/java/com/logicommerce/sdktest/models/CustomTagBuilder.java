package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.CustomTag;

public class CustomTagBuilder<T> {

	private T parentBuilder;

	private String name;

	private String value;

	public CustomTagBuilder() {
		name = "name DEFAULT";
		value = "value DEFAULT";
	}

	public CustomTagBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CustomTagBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public CustomTagBuilder<T> value(String value) {
		this.value = value;
		return this;
	}
	
	public CustomTag build() {
		CustomTagFake customTag = new CustomTagFake();
		customTag.setName(name);
		customTag.setValue(value);
		return customTag;
	}
	
	public T done() {
		return parentBuilder;
	}
}
