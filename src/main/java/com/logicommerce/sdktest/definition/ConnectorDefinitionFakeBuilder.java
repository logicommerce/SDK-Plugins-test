package com.logicommerce.sdktest.definition;

import com.logicommerce.sdk.definition.ConnectorDefinition;
import com.logicommerce.sdk.enums.ConnectorType;

public class ConnectorDefinitionFakeBuilder extends ConfigDefinitionFakeBuilder<ConnectorDefinitionFakeBuilder> {

	private PluginDefinitionFakeBuilder parentBuilder;
	
	protected ConnectorType type;

	public ConnectorDefinitionFakeBuilder type(ConnectorType type) {
		this.type = type;
		return this;
	}

	protected ConnectorDefinitionFakeBuilder() {
		super();
	}

	protected ConnectorDefinitionFakeBuilder(PluginDefinitionFakeBuilder parentBuilder) {
		super();
		this.parentBuilder = parentBuilder;
	}

	public ConnectorDefinition build() {
		ConnectorDefinitionFake connector = new ConnectorDefinitionFake();
		setAttributes(connector);
		connector.setType(type);
		return connector;
	}

	@Override
	protected ConnectorDefinitionFakeBuilder returnThis() {
		return this;
	}

	public PluginDefinitionFakeBuilder done() {
		return parentBuilder;
	}
}
