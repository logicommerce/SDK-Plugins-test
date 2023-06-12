package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Cookie;

public class CookieFake implements Cookie {

	private String value;
	private String name;
	private int ttl;
	private boolean httpOnly;
	private boolean secure;

	public CookieFake() {

	}

	public CookieFake(String name, String value, int ttl) {
		setName(name);
		setValue(value);
		setTtl(ttl);
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getTtl() {
		return ttl;
	}

	@Override
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	@Override
	public boolean getHttpOnly() {
		return httpOnly;
	}

	@Override
	public boolean getSecure() {
		return secure;
	}

	@Override
	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

	@Override
	public void setSecure(boolean secure) {
		this.secure = secure;
	}

}
