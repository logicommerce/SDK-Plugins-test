package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import com.logicommerce.sdk.resources.Navigator;

public class NavigatorFake implements Navigator {

	private String userAgent;

	private String referer;

	private String language;

	private String country;

	private String currency;

	private String defaultCurrency;

	private String pageType;

	private Map<String, String> cookies;

	private String url;
	
	private String ip;

	public NavigatorFake() {
		cookies = new LinkedHashMap<>();
	}

	@Override
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	@Override
	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	@Override
	public String getCookie(String name) {
		return cookies.get(name);
	}

	@Override
	public void setCookie(String name, String value) {
		cookies.put(name, value);
	}

	@Override
	public String getCookies() {
		return cookies.entrySet().stream()
				.map(e -> e.getKey() + "=" + e.getValue())
				.collect(Collectors.joining("; "));
	}

	@Override
	public void removeCookie(String name) {
		if (cookies.containsKey(name))
			cookies.remove(name);
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@Override
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
