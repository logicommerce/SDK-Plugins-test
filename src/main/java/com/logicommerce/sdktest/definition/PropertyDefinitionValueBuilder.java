package com.logicommerce.sdktest.definition;

import com.logicommerce.sdk.definition.PropertyDefinitionValue;

public class PropertyDefinitionValueBuilder<T> {

	private T parentBuilder;
	
	private String value;

	private DefinitionLanguagesFakeBuilder<PropertyDefinitionValueBuilder<T>> languages;
	
	public PropertyDefinitionValueBuilder() {
		value = "value DEFAULT";
		languages = new DefinitionLanguagesFakeBuilder<>(this);
	}
	
	public PropertyDefinitionValueBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public PropertyDefinitionValueBuilder<T> value(String value) {
		this.value = value;
		return this;
	}
	
	public DefinitionLanguagesFakeBuilder<PropertyDefinitionValueBuilder<T>> languages() {
		return languages;
	}
	
	public PropertyDefinitionValue build() {
		PropertyDefinitionValueFake propertyValue = new PropertyDefinitionValueFake();
		propertyValue.setValue(value);
		propertyValue.setLanguages(languages.build());
		return propertyValue;
	}
	
	public T done() {
		return parentBuilder;
	}
}
