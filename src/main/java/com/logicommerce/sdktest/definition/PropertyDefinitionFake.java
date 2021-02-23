package com.logicommerce.sdktest.definition;

import java.util.List;
import com.logicommerce.sdk.definition.DefinitionLanguages;
import com.logicommerce.sdk.definition.PropertyDefinition;
import com.logicommerce.sdk.definition.PropertyDefinitionValue;

public class PropertyDefinitionFake implements PropertyDefinition {

	private String identifier;

	private String type;

	private boolean required;

	private String defaultValue;

	private DefinitionLanguages languages;

	private List<PropertyDefinitionValue> values;

	private boolean languageValue;

	private String entryValueMode;

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	@Override
	public DefinitionLanguages getLanguages() {
		return languages;
	}

	@Override
	public List<PropertyDefinitionValue> getValues() {
		return values;
	}

	@Override
	public boolean isLanguageValue() {
		return languageValue;
	}

	@Override
	public String getEntryValueMode() {
		return entryValueMode;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setLanguages(DefinitionLanguages languages) {
		this.languages = languages;
	}

	public void setValues(List<PropertyDefinitionValue> values) {
		this.values = values;
	}

	public void setLanguageValue(boolean languageValue) {
		this.languageValue = languageValue;
	}

	public void setEntryValueMode(String entryValueMode) {
		this.entryValueMode = entryValueMode;
	}
	
}
