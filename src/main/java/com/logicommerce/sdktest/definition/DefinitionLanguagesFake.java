package com.logicommerce.sdktest.definition;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.definition.DefinitionLanguages;

public class DefinitionLanguagesFake implements DefinitionLanguages {

	private static final String LANGUAGE_DEFAULT = "en";

	private Map<String, String> values;

	public DefinitionLanguagesFake() {
		values = new LinkedHashMap<>();
	}

	@Override
	public Map<String, String> getValues() {
		return values;
	}

	@Override
	public String getValue(String language) {
		if (values.containsKey(language)) {
			return values.get(language);
		}
		if (values.containsKey(LANGUAGE_DEFAULT)) {
			return values.get(LANGUAGE_DEFAULT);
		}
		return null;
	}

	public void setValue(String language, String name) {
		values.put(language, name);
	}

	public void setValues(Map<String, String> names) {
		this.values = names;
	}

}
