package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import com.logicommerce.sdk.resources.PluginAccountData;

public class PluginAccountDataFake implements PluginAccountData {

	private Map<String, Map<String, String>> data = new LinkedHashMap<>();
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean containsKey(String key) {
		return data.containsKey(key);
	}

	@Override
	public Map<String, String> get(String key) {
		return data.get(key);
	}

	@Override
	public Map<String, String> put(String key, Map<String, String> value) {
		return data.put(key, value);
	}

	@Override
	public Map<String, String> remove(String key) {
		return data.remove(key);
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public Set<Entry<String, Map<String, String>>> entrySet() {
		return data.entrySet().stream().collect(Collectors.toSet());
	}

}
