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
	private boolean userGroupsFilter;
	private boolean accountGroupsFilter;
	private boolean countryZonesFilter;

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

	@Deprecated(since = "2.2.0", forRemoval = true)
	@Override
	public boolean getUserGroupsFilter() {
		return userGroupsFilter;
	}

	@Override
	public boolean getCountryZonesFilter() {
		return countryZonesFilter;
	}

	@Override
	public boolean getAccountGroupsFilter() {
		return accountGroupsFilter;
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

	public void setUserGroupsFilter(boolean userGroupsFilter) {
		this.userGroupsFilter = userGroupsFilter;
	}

	public void setCountryZonesFilter(boolean countryZonesFilter) {
		this.countryZonesFilter = countryZonesFilter;
	}

	public void setAccountGroupsFilter(boolean accountGroupsFilter) {
		this.accountGroupsFilter = accountGroupsFilter;
	}
}
