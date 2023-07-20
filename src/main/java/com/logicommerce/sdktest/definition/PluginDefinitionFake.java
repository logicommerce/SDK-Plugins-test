package com.logicommerce.sdktest.definition;

import java.util.List;
import com.logicommerce.sdk.definition.ConnectorDefinition;
import com.logicommerce.sdk.definition.PluginDefinition;
import com.logicommerce.sdk.definition.PluginDefinitionException;
import com.logicommerce.sdk.enums.ConnectorType;

public class PluginDefinitionFake extends ConfigDefinitionFake implements PluginDefinition {

	private String name;

	private String description;

	private String author;

	private String version;

	private List<ConnectorDefinition> connectors;

	private boolean multipleAccount;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public List<ConnectorDefinition> getConnectorDefinitions() {
		return connectors;
	}

	@Override
	public boolean getMultipleAccount() {
		return multipleAccount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ConnectorDefinition> T getConnectorDefinition(ConnectorType connectorType) {
		return (T) connectors.stream()
			.filter(connector -> connector.getType().equals(connectorType))
			.findFirst()
			.orElse(null);
	}

	@Override
	public <T extends ConnectorDefinition> void addConnectorDefinition(T connectorDefinition) throws PluginDefinitionException {
		if (getConnectorDefinition(connectorDefinition.getType()) != null) {
			throw new PluginDefinitionException(getClass(), "Connector is already defined");
		}
		getConnectorDefinitions().add(connectorDefinition);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setConnectorDefinitions(List<ConnectorDefinition> connectors) {
		this.connectors = connectors;
	}

	public void setMultipleAccount(boolean multipleAccount) {
		this.multipleAccount = multipleAccount;
	}

}
