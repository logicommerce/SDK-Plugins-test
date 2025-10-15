package com.logicommerce.sdktest.resources;

import java.util.HashMap;
import java.util.Map;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdk.resources.SecretsResource;

public class SecretsResourceFake implements SecretsResource {

	private Map<String, String> secrets = new HashMap<>();
	
	@Override
	public Map<String, String> getSecrets() throws PluginResourceException {
		return secrets;
	}

	public void addSecret(String key, String value) {
		secrets.put(key, value);
	}
}
