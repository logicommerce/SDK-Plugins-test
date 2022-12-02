package com.logicommerce.sdktest.resources;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.Cookie;
import com.logicommerce.sdk.resources.Navigator;
import com.logicommerce.sdktest.models.CookieFake;

public class NavigatorFake implements Navigator {

	private String userAgent;

	private String referer;

	private String language;

	private String country;

	private String currency;

	private String defaultCurrency;

	private String pageType;

	private Map<String, Cookie> cookies;

	private String url;

	private String ip;

	private URL storeUrl;

	private String baseUrl;

	private String cdnAssets;

	private String cdnImages;

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

	public void setCookies(Map<String, Cookie> cookies) {
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

	@Override
	public URL getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(URL storeUrl) {
		this.storeUrl = storeUrl;
	}

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public String getCdnAssets() {
		return cdnAssets;
	}

	public void setCdnAssets(String cdnAssets) {
		this.cdnAssets = cdnAssets;
	}

	@Override
	public String getCdnImages() {
		return cdnImages;
	}

	public void setCdnImages(String cdnImages) {
		this.cdnImages = cdnImages;
	}


	@Override
	public String getCookies() {
		return cookies.entrySet().stream()
				.map(e -> e.getKey() + "=" + e.getValue())
				.collect(Collectors.joining("; "));
	}

	@Override
	public void removeCookie(String name) {
		if (cookies.containsKey(name)) {
			cookies.remove(name);
		}
	}

	@Override
	public Cookie getCookie(String name) {
		return cookies.get(name);
	}

	@Override
	public void setCookie(Cookie cookie) {
		cookies.put(cookie.getName(), cookie);
	}

	@Override
	public void setCookie(String name, String value, int ttl) {
		Cookie cookie = new CookieFake(name, value, ttl);
		cookies.put(name, cookie);
	}

}
