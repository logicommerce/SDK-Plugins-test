package com.logicommerce.sdktest.definition;

import java.util.List;
import com.logicommerce.sdk.definition.DefinitionLanguages;
import com.logicommerce.sdk.definition.PropertyDefinition;
import com.logicommerce.sdk.definition.PropertyDefinitionPermission;
import com.logicommerce.sdk.definition.PropertyDefinitionValue;

public class PropertyDefinitionFake implements PropertyDefinition {

	private String identifier;

	private String type;

	private boolean required;

	private String defaultValue;

	private DefinitionLanguages languages;

	private DefinitionLanguages hint;

	private List<PropertyDefinitionValue> values;

	private boolean languageValue;

	private boolean multipleValue;

	private String entryValueMode;

	private String reference;

	private List<PropertyDefinitionPermission> permissions;

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
	public DefinitionLanguages getHint() {
		return hint;
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

	@Override
	public boolean isMultipleValue() {
		return multipleValue;
	}

	@Override
	public String getReference() {
		return reference;
	}

	@Override
	public List<PropertyDefinitionPermission> getPermissions() {
		return permissions;
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

	public void setHint(DefinitionLanguages hint) {
		this.hint = hint;
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

	public void setMultipleValue(boolean multipleValue) {
		this.multipleValue = multipleValue;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setPermissions(List<PropertyDefinitionPermission> permissions) {
		this.permissions = permissions;
	}

}
