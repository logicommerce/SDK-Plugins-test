package com.logicommerce.sdktest.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.definition.ConnectorDefinition;

public class PluginDefinitionFakeBuilder extends ConfigDefinitionFakeBuilder<PluginDefinitionFakeBuilder> {

	private String name;
	private String description;
	private String author;
	private String version;
	private List<ConnectorDefinitionFakeBuilder> connectorDefinitions;
	private boolean multipleAccount;
	private boolean userGroupsFilter;
	private boolean accountGroupsFilter;
	private boolean countryZonesFilter;


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

	public PluginDefinitionFakeBuilder multipleAccount(boolean multipleAccount) {
		this.multipleAccount = multipleAccount;
		return returnThis();
	}

	@Deprecated(since = "2.2.0", forRemoval = true)
	public PluginDefinitionFakeBuilder userGroupsFilter(boolean userGroupsFilter) {
		this.userGroupsFilter = userGroupsFilter;
		return returnThis();
	}

	public PluginDefinitionFakeBuilder accountGroupsFilter(boolean accountGroupsFilter) {
		this.accountGroupsFilter = accountGroupsFilter;
		return returnThis();
	}

	public PluginDefinitionFakeBuilder countryZonesFilter(boolean countryZonesFilter) {
		this.countryZonesFilter = countryZonesFilter;
		return returnThis();
	}


	public PluginDefinitionFake build() {
		PluginDefinitionFake pluginDefinition = new PluginDefinitionFake();
		pluginDefinition.setName(name);
		pluginDefinition.setDescription(description);
		pluginDefinition.setAuthor(author);
		pluginDefinition.setVersion(version);
		pluginDefinition.setConnectorDefinitions(getConnectorDefinitions());
		pluginDefinition.setMultipleAccount(multipleAccount);
		pluginDefinition.setUserGroupsFilter(userGroupsFilter);
		pluginDefinition.setAccountGroupsFilter(accountGroupsFilter);
		pluginDefinition.setCountryZonesFilter(countryZonesFilter);
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
