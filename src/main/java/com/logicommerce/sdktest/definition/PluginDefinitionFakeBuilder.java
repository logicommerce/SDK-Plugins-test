package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.definition.ConnectorDefinition;

public class PluginDefinitionFakeBuilder extends ConfigDefinitionFakeBuilder<PluginDefinitionFakeBuilder>{

	private String name;

	private String description;

	private String author;

	private String version;

	private List<ConnectorDefinitionFakeBuilder> connectorDefinitions;

	public PluginDefinitionFakeBuilder() {
		connectorDefinitions = new ArrayList<>();
	}

	public PluginDefinitionFakeBuilder name(String name) {
		this.name = name;
		return returnThis();
	}

	public PluginDefinitionFakeBuilder description(String description) {
		this.description = description;
		return returnThis();
	}

	public PluginDefinitionFakeBuilder author(String author) {
		this.author = author;
		return returnThis();
	}

	public PluginDefinitionFakeBuilder version(String version) {
		this.version = version;
		return returnThis();
	}

	public ConnectorDefinitionFakeBuilder connectorDefinition() {
		ConnectorDefinitionFakeBuilder connectorDefinition = new ConnectorDefinitionFakeBuilder(returnThis());
		connectorDefinitions.add(connectorDefinition);
		return connectorDefinition;
	}

	public PluginDefinitionFake build() {
		PluginDefinitionFake pluginDefinition = new PluginDefinitionFake();
		pluginDefinition.setName(name);
		pluginDefinition.setDescription(description);
		pluginDefinition.setAuthor(author);
		pluginDefinition.setVersion(version);
		pluginDefinition.setConnectorDefinitions(getConnectorDefinitions());
		setAttributes(pluginDefinition);
		return pluginDefinition;
	}

	private List<ConnectorDefinition> getConnectorDefinitions() {
		return connectorDefinitions.stream()
				.map(ConnectorDefinitionFakeBuilder::build)
				.collect(Collectors.toList());
	}

	@Override
	protected PluginDefinitionFakeBuilder returnThis() {
		return this;
	}

}
