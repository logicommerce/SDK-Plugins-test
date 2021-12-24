package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.definition.PropertyDefinitionValue;

public class PropertyDefinitionFakeBuilder<T> {

	private T parentBuider;

	private String identifier;

	private String type;

	private Boolean required;

	private String defaultValue;

	private DefinitionLanguagesFakeBuilder<PropertyDefinitionFakeBuilder<T>> languages;

	private List<PropertyDefinitionValueBuilder<PropertyDefinitionFakeBuilder<T>>> values;
	
	private String reference;

	public PropertyDefinitionFakeBuilder() {
		values = new ArrayList<>();
	}

	public PropertyDefinitionFakeBuilder(T parentBuilder) {
		this();
		this.parentBuider = parentBuilder;
	}

	public PropertyDefinitionFakeBuilder<T> identifier(String identifier) {
		this.identifier = identifier;
		return this;
	}

	public PropertyDefinitionFakeBuilder<T> type(String type) {
		this.type = type;
		return this;
	}

	public PropertyDefinitionFakeBuilder<T> required(Boolean required) {
		this.required = required;
		return this;
	}

	public PropertyDefinitionFakeBuilder<T> defaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public DefinitionLanguagesFakeBuilder<PropertyDefinitionFakeBuilder<T>> languages() {
		languages = new DefinitionLanguagesFakeBuilder<>(this);
		return languages;
	}

	public PropertyDefinitionValueBuilder<PropertyDefinitionFakeBuilder<T>> addValue() {
		PropertyDefinitionValueBuilder<PropertyDefinitionFakeBuilder<T>> value = new PropertyDefinitionValueBuilder<>(this);
		values.add(value);
		return value;
	}
	
	public PropertyDefinitionFakeBuilder<T> reference(String reference) {
		this.reference = reference;
		return this;
	}

	public PropertyDefinitionFake build() {
		PropertyDefinitionFake propertyDefinition = new PropertyDefinitionFake();
		propertyDefinition.setDefaultValue(defaultValue);
		propertyDefinition.setLanguages(languages.build());
		propertyDefinition.setIdentifier(identifier);
		propertyDefinition.setRequired(required);
		propertyDefinition.setType(type);
		propertyDefinition.setValues(getValues());
		propertyDefinition.setReference(reference);
		return propertyDefinition;
	}

	private List<PropertyDefinitionValue> getValues() {
		return values.stream()
				.map(PropertyDefinitionValueBuilder::build)
				.collect(Collectors.toList());
	}

	public T done() {
		return parentBuider;
	}

}
