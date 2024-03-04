package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.definition.MappedFieldDefinition;
import com.logicommerce.sdk.definition.PropertyDefinitionValue;
import com.logicommerce.sdk.definition.implementations.MappedFieldDefinitionImpl;
import com.logicommerce.sdk.enums.MappedItemType;

public class MappedFieldDefinitionBuilder<T> {

	private T parentBuilder;

	private MappedItemType type;

	private List<String> fields;

	private List<PropertyDefinitionValue> values;

	public MappedFieldDefinitionBuilder(T parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.fields = new ArrayList<>();
		this.values = new ArrayList<>();
	}

	public MappedFieldDefinitionBuilder<T> type(MappedItemType type) {
		this.type = type;
		return this;
	}

	@Deprecated(since = "1.3.3", forRemoval = true)
	public MappedFieldDefinitionBuilder<T> addField(String field) {
		this.fields.add(field);
		return this;
	}

	public MappedFieldDefinitionBuilder<T> addValue(PropertyDefinitionValue value) {
		this.values.add(value);
		return this;
	}

	public MappedFieldDefinition build() {
		MappedFieldDefinitionImpl mappedFieldDefinition = new MappedFieldDefinitionImpl();
		mappedFieldDefinition.setType(type);
		mappedFieldDefinition.setFields(fields);
		mappedFieldDefinition.setValues(values);
		return mappedFieldDefinition;
	}

	public T done() {
		return parentBuilder;
	}


}
