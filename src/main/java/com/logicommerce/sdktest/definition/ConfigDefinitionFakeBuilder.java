package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.definition.implementations.MappedFieldDefinitionImpl;

public abstract class ConfigDefinitionFakeBuilder<T extends ConfigDefinitionFakeBuilder<T>> {

	private List<PropertyDefinitionFakeBuilder<T>> properties;

	private boolean hasAdditionalProperties;

	private List<PropertyDefinitionFakeBuilder<T>> additionalProperties;

	private List<MappedFieldDefinitionImpl.Builder<T>> mappedFields;


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

	public MappedFieldDefinitionImpl.Builder<T> mappedField() {
		MappedFieldDefinitionImpl.Builder<T> mappedField = new MappedFieldDefinitionImpl.Builder<>(returnThis());
		mappedFields.add(mappedField);
		return mappedField;
	}

	public void setAttributes(ConfigDefinitionFake configDefinition) {
		configDefinition
			.setProperties(properties.stream().map(PropertyDefinitionFakeBuilder::build).collect(Collectors.toList()));
		configDefinition.setHasAdditionalProperties(hasAdditionalProperties);
		configDefinition.setAdditionalProperties(
			additionalProperties.stream().map(PropertyDefinitionFakeBuilder::build).collect(Collectors.toList()));
		configDefinition.setMappedFields(
			mappedFields.stream().map(MappedFieldDefinitionImpl.Builder::build).collect(Collectors.toList()));
	}

	protected abstract T returnThis();

}
