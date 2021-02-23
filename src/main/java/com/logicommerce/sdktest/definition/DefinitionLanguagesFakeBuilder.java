package com.logicommerce.sdktest.definition;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.definition.DefinitionLanguages;

public class DefinitionLanguagesFakeBuilder<T> {

	private T parentBuilder;

	private Map<String, String> names;

	public DefinitionLanguagesFakeBuilder() {
		names = new LinkedHashMap<>();
	}

	public DefinitionLanguagesFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public DefinitionLanguagesFakeBuilder<T> name(String language, String name) {
		names.put(language, name);
		return this;
	}

	public DefinitionLanguages build() {
		DefinitionLanguagesFake languages = new DefinitionLanguagesFake();
		languages.setNames(names);
		return languages;
	}

	public T done() {
		return parentBuilder;
	}
}
