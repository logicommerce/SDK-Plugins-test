package com.logicommerce.sdktest.definition;

import com.logicommerce.sdk.definition.DefinitionLanguages;
import com.logicommerce.sdk.definition.PropertyDefinitionValue;

public class PropertyDefinitionValueFake implements PropertyDefinitionValue {

	private String value;

	private DefinitionLanguages languages;

	@Override
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public DefinitionLanguages getLanguages() {
		return languages;
	}

	public void setLanguages(DefinitionLanguages languages) {
		this.languages = languages;
	}
}
