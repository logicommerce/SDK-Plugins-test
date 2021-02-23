package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.ElementProperty;

public class ElementPropertyBuilder<T> {

	private T parentBuilder;

	private String name;

	private String value;

	public ElementPropertyBuilder() {
		name = "name DEFAULT";
		value = "value DEFAULT";
	}

	public ElementPropertyBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public ElementPropertyBuilder<T> name(String name) {
		this.name = name;
		return this;
	}

	public ElementPropertyBuilder<T> value(String value) {
		this.value = value;
		return this;
	}
	
	public ElementProperty build() {
		ElementProperty elementProperty = new ElementPropertyFake();
		elementProperty.setName(name);
		elementProperty.setValue(value);
		return elementProperty;
	}
	
	public T done() {
		return parentBuilder;
	}
}
