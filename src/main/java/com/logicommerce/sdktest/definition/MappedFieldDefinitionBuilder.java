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

	private List<PropertyDefinitionValue> values;

	public MappedFieldDefinitionBuilder(T parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.values = new ArrayList<>();
	}

	public MappedFieldDefinitionBuilder<T> type(MappedItemType type) {
		this.type = type;
		return this;
	}

	public MappedFieldDefinitionBuilder<T> addValue(PropertyDefinitionValue value) {
		this.values.add(value);
		return this;
	}

	public MappedFieldDefinition build() {
		MappedFieldDefinitionImpl mappedFieldDefinition = new MappedFieldDefinitionImpl();
		mappedFieldDefinition.setType(type);
		mappedFieldDefinition.setValues(values);
		return mappedFieldDefinition;
	}

	public T done() {
		return parentBuilder;
	}


}
