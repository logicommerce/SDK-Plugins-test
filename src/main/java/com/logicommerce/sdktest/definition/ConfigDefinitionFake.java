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
		return properties;
	}

	@Override
	public void addProperty(PropertyDefinition property) {
		if (properties == null) {
			properties = new ArrayList<>();
		}
		properties.add(property);
	}

	@Override
	public boolean hasAdditionalProperties() {
		return hasAdditionalProperties;
	}

	@Override
	public List<PropertyDefinition> getAdditionalProperties() {
		return additionalProperties;
	}

	@Override
	public void addAdditionalProperty(PropertyDefinition property) {
		if (additionalProperties == null) {
			additionalProperties = new ArrayList<>();
		}
		additionalProperties.add(property);
	}

	@Override
	public List<MappedFieldDefinition> getMappedFields() {
		return mappedFields;
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
