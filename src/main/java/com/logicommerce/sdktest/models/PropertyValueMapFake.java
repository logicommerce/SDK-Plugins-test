package com.logicommerce.sdktest.models;

import java.util.Map;
import java.util.Set;
import com.logicommerce.sdk.models.PropertyValueMap;

public class PropertyValueMapFake implements PropertyValueMap {

	private Map<String, Object> map;

	public PropertyValueMapFake() {
		this(null);
	}

	public PropertyValueMapFake(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public <T> T get(String key, Class<T> type) {
		if (map != null) {
			if (!map.containsKey(key)) {
				return null;
			}
			Object value = map.get(key);
			if (type.isInstance(value)) {
				return type.cast(value);
			}
		}
		return null;
	}

	@Override
	public Object getRaw(String key) {
		if (map != null) {
			return map.get(key);
		}
		return null;
	}

	@Override
	public boolean containsKey(String key) {
		if (map != null) {
			return map.containsKey(key);
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return map == null || map.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		if (map != null) {
			return map.keySet();
		}
		return null;
	}

}
