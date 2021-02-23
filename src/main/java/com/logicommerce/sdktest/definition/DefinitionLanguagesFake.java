package com.logicommerce.sdktest.definition;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.definition.DefinitionLanguages;

public class DefinitionLanguagesFake implements DefinitionLanguages {

	private static final String LANGUAGE_DEFAULT = "en";

	private Map<String, String> names;

	public DefinitionLanguagesFake() {
		names = new LinkedHashMap<>();
	}

	@Override
	public Map<String, String> getNames() {
		return names;
	}

	@Override
	public String getName(String language) {
		if (names.containsKey(language))
			return names.get(language);
		if (names.containsKey(LANGUAGE_DEFAULT))
			return names.get(LANGUAGE_DEFAULT);
		return null;
	}

	public void setName(String language, String name) {
		names.put(language, name);
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

}
