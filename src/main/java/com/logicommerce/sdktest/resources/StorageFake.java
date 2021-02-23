package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.logicommerce.sdk.resources.Storage;

public class StorageFake implements Storage {

	private Map<String, String> data;

	public StorageFake() {
		this.data = new LinkedHashMap<>();
	}

	@Override
	public void clear() {
		this.data.clear();		
	}

	@Override
	public String get(String key) {
		return data.getOrDefault(key, "");
	}

	@Override
	public String remove(String key) {
		return data.remove(key);
	}

	@Override
	public String put(String key, String value) {
		data.put(key, value);
		return value;
	}

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
	public Set<Entry<String, String>> entrySet() {
		return data.entrySet();
	}

}
