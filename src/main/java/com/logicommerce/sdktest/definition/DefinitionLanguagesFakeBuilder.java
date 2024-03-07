package com.logicommerce.sdktest.definition;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.definition.DefinitionLanguages;

public class DefinitionLanguagesFakeBuilder<T> {

	private T parentBuilder;

	private Map<String, String> values;

	public DefinitionLanguagesFakeBuilder() {
		values = new LinkedHashMap<>();
	}

	public DefinitionLanguagesFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public DefinitionLanguagesFakeBuilder<T> name(String language, String value) {
		values.put(language, value);
		return this;
	}

	public DefinitionLanguages build() {
		DefinitionLanguagesFake languages = new DefinitionLanguagesFake();
		languages.setValues(values);
		return languages;
	}

	public T done() {
		return parentBuilder;
	}
}
