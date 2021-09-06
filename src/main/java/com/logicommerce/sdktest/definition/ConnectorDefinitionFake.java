package com.logicommerce.sdktest.definition;

import java.util.Map;
import com.logicommerce.sdk.definition.ConnectorDefinition;
import com.logicommerce.sdk.enums.ConnectorType;

public class ConnectorDefinitionFake extends ConfigDefinitionFake implements ConnectorDefinition {

	private ConnectorType type;

	private Map<String, Object> additionalData;

	@Override
	public ConnectorType getType() {
		return type;
	}

	@Override
	public Map<String, Object> getAdditionalData() {
		return additionalData;
	}

	public void setType(ConnectorType type) {
		this.type = type;
	}

	public void setAdditionalData(Map<String, Object> additionalData) {
		this.additionalData = additionalData;
	}
}