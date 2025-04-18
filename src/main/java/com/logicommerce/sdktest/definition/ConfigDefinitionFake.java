package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.definition.ConfigDefinition;
import com.logicommerce.sdk.definition.DefinitionLanguages;
import com.logicommerce.sdk.definition.MappedFieldDefinition;
import com.logicommerce.sdk.definition.PluginActionDefinition;
import com.logicommerce.sdk.definition.PropertyDefinition;

public abstract class ConfigDefinitionFake implements ConfigDefinition {

	private DefinitionLanguages summary;

	private List<PropertyDefinition> properties;

	private boolean hasAdditionalProperties;

	private List<PropertyDefinition> additionalProperties;

	private List<MappedFieldDefinition> mappedFields;

	private List<PluginActionDefinition> pluginActions;

	@Override
	public DefinitionLanguages getSummary() {
		return summary;
	}

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

	@Override
	public void addMappedField(MappedFieldDefinition mappedField) {
		if (mappedFields == null) {
			mappedFields = new ArrayList<>();
		}
		mappedFields.add(mappedField);
	}

	public void setSummary(DefinitionLanguages summary) {
		this.summary = summary;
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


	@Override
	public List<PluginActionDefinition> getPluginActions() {
		if (pluginActions == null) {
			pluginActions = new ArrayList<>();
		}
		return pluginActions;
	}

	@Override
	public void addPluginAction(PluginActionDefinition pluginActions) {
		getPluginActions().add(pluginActions);
	}
}
