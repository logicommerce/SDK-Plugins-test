package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.definition.ConfigDefinition;
import com.logicommerce.sdk.definition.MappedFieldDefinition;
import com.logicommerce.sdk.definition.PropertyDefinition;

public abstract class ConfigDefinitionFake implements ConfigDefinition {

	private List<PropertyDefinition> properties;

	private boolean hasAdditionalProperties;

	private List<PropertyDefinition> additionalProperties;

	private List<MappedFieldDefinition> mappedFields;

	@Override
	public List<PropertyDefinition> getProperties() {
		if (properties == null) {
			properties = new ArrayList<>();
		}
		return properties;
	}

	@Override
	public void addProperty(PropertyDefinition property) {
		getProperties().add(property);
	}

	@Override
	public boolean hasAdditionalProperties() {
		return hasAdditionalProperties;
	}

	@Override
	public List<PropertyDefinition> getAdditionalProperties() {
		if (additionalProperties == null) {
			additionalProperties = new ArrayList<>();
		}
		return additionalProperties;
	}

	@Override
	public void addAdditionalProperty(PropertyDefinition property) {
		getAdditionalProperties().add(property);
	}

	@Override
	public List<MappedFieldDefinition> getMappedFields() {
		if (mappedFields == null) {
			mappedFields = new ArrayList<>();
		}
		return mappedFields;
	}


	@Override
	public void addMappedField(MappedFieldDefinition mappedField) {
		getMappedFields().add(mappedField);
	}

	public void setProperties(List<PropertyDefinition> properties) {
		this.properties = properties;
	}

	public void setHasAdditionalProperties(boolean hasAdditionalProperties) {
		this.hasAdditionalProperties = hasAdditionalProperties;
	}

	public void setAdditionalProperties(List<PropertyDefinition> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public void setMappedFields(List<MappedFieldDefinition> mappedFields) {
		this.mappedFields = mappedFields;
	}

}
