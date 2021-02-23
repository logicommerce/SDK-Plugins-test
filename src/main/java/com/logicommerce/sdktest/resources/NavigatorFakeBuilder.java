package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.resources.Navigator;

public class NavigatorFakeBuilder {

	protected String userAgent;

	protected String referer;

	protected String language;
	
	protected String country;

	protected String currency;

	private String defaultCurrency;

	protected String pageType;

	protected Map<String, String> cookies;
	
	protected String url;
	
	protected String ip;

	public NavigatorFakeBuilder() {
		userAgent = "Fake User Agent;java";
		referer = "http://www.google.com";
		language = "en";
		country = "de";
		currency = "EUR";
		defaultCurrency = "EUR";
		pageType = "";
		cookies = new LinkedHashMap<>();
		url = "https://www.yourshop.com";
		ip = "127.0.0.1";
	}

	public NavigatorFakeBuilder userAgent(String userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	public NavigatorFakeBuilder referer(String referer) {
		this.referer = referer;
		return this;
	}

	public NavigatorFakeBuilder language(String language) {
		this.language = language;
		return this;
	}

	public NavigatorFakeBuilder country(String country) {
		this.country = country;
		return this;
	}

	public NavigatorFakeBuilder currency(String currency) {
		this.currency = currency;
		return this;
	}

	public NavigatorFakeBuilder defaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
		return this;
	}

	public NavigatorFakeBuilder pageType(String pageType) {
		this.pageType = pageType;
		return this;
	}

	public NavigatorFakeBuilder addCookie(String name, String value) {
		this.cookies.put(name, value);
		return this;
	}

	public NavigatorFakeBuilder url(String url) {
		this.url = url;
		return this;
	}

	public NavigatorFakeBuilder ip(String ip) {
		this.ip = ip;
		return this;
	}
	
	public Navigator build() {
		NavigatorFake navigator = new NavigatorFake();
		navigator.setUserAgent(userAgent);
		navigator.setReferer(referer);
		navigator.setLanguage(language);
		navigator.setCountry(country);
		navigator.setCurrency(currency);
		navigator.setDefaultCurrency(defaultCurrency);
		navigator.setPageType(pageType);
		navigator.setCookies(cookies);
		navigator.setUrl(url);
		navigator.setIp(ip);
		return navigator;
	}

}
