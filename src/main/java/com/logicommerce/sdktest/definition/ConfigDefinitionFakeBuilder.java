package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ConfigDefinitionFakeBuilder<T extends ConfigDefinitionFakeBuilder<T>> {

	private List<PropertyDefinitionFakeBuilder<T>> properties;
	
	private boolean hasAdditionalProperties;
	
	private List<PropertyDefinitionFakeBuilder<T>> additionalProperties;

	private List<MappedFieldDefinitionBuilder<T>> mappedFields;


	protected ConfigDefinitionFakeBuilder() {
		properties = new ArrayList<>();
		additionalProperties = new ArrayList<>();
		mappedFields = new ArrayList<>();
	}

	public PropertyDefinitionFakeBuilder<T> property() {
		PropertyDefinitionFakeBuilder<T> property = new PropertyDefinitionFakeBuilder<>(returnThis());
		properties.add(property);
		return property;
	}

	public T hasAdditionalProperties(boolean hasAdditionalProperties) {
		this.hasAdditionalProperties = hasAdditionalProperties;
		return returnThis();
	}
	
	public PropertyDefinitionFakeBuilder<T> additionalProperty() {
		PropertyDefinitionFakeBuilder<T> additionalProperty = new PropertyDefinitionFakeBuilder<>(returnThis());
		properties.add(additionalProperty);
		return additionalProperty;
	}

	public MappedFieldDefinitionBuilder<T> mappedField() {
		MappedFieldDefinitionBuilder<T> mappedField = new MappedFieldDefinitionBuilder<>(returnThis());
		mappedFields.add(mappedField);
		return mappedField;
	}
	
	public void setAttributes(ConfigDefinitionFake configDefinition) {
		configDefinition.setProperties(properties.stream().map(PropertyDefinitionFakeBuilder::build).collect(Collectors.toList()));
		configDefinition.setHasAdditionalProperties(hasAdditionalProperties);
		configDefinition.setAdditionalProperties(additionalProperties.stream().map(PropertyDefinitionFakeBuilder::build).collect(Collectors.toList()));
		configDefinition.setMappedFields(mappedFields.stream().map(MappedFieldDefinitionBuilder::build).collect(Collectors.toList()));
	}
	
	protected abstract T returnThis();

}
