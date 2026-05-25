package com.logicommerce.sdktest.resources;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import com.logicommerce.sdk.resources.SessionStorage;

public class SessionStorageFake implements SessionStorage {

	private Map<String, String> data;

	public SessionStorageFake() {
		data = new HashMap<>();
	}

	@Override
	public boolean hasSession() {
		return true;
	}

	@Override
	public boolean isAnonymous() {
		return false;
	}

	@Override
	public String getSessionToken() {
		return "token-test-1234";
	}

	@Override
	public Map<String, String> getSessionData() {
		return data;
	}

	@Override
	public void createNewSession(Duration ttl) {
		data = new HashMap<>();
	}

	@Override
	public void deleteSession() {
	}

	@Override
	public String get(String key) {
		return data.getOrDefault(key, "");
	}

	@Override
	public void set(String key, String value) {
		data.put(key, value);
	}

	@Override
	public void remove(String key) {
		data.remove(key);
	}

}
