package com.logicommerce.sdktest.resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConnectionAttributes {

	private String authorization = "";

	private String path = "";

	private String contentType = "application/json";

	private String acceptType = "application/json";

	private final Map<String, String> headers = new HashMap<>();

	private final Map<String, String> cookies = new HashMap<>();

	private final Map<String, String> queryParams = new HashMap<>();

	private String endPoint = "";

	private String method = "";

	private String params = "";

	private String body = "";

	private Integer timeout = 3000;

	protected boolean hasAuthorization() {
		return getAuthorization() != null && !getAuthorization().isBlank();
	}

	protected URL getUrl() throws MalformedURLException {
		String strUrl = String.format("%s/%s?%s", getEndPoint(), getPath(), getParams());
		if (getPath().isEmpty()) {
			strUrl = String.format("%s?%s", getEndPoint(), getParams());
		}
		if (getPath().isEmpty() && getParams().isEmpty()) {
			strUrl = String.format("%s", getEndPoint());
		}
		return new URL(strUrl);
	}

	protected boolean isSSLConnection() {
		if (hasAuthorization()) {
			return true;
		}
		Pattern pattern = Pattern.compile("^https", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(getEndPoint());
		return matcher.find();
	}

	protected boolean hasBody() {
		if (getMethod().equalsIgnoreCase("GET") || getMethod().equalsIgnoreCase("DELETE")) {
			return false;
		}
		return getBody() != null && !getBody().isBlank();
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (path.charAt(0) == '/') {
			path = path.substring(1);
		}
		this.path = path;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAcceptType() {
		return acceptType;
	}

	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeader(String name, String value) {
		headers.put(name, value);
	}

	public String getCookies() {
		return cookies.entrySet()
				.stream()
				.map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
				.collect(Collectors.joining("; "));
	}

	public void setCookie(String name, String value) {
		cookies.put(name, value);
	}

	public void setQueryParam(String name, String value) {
		queryParams.put(name, value);
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		if (endPoint.endsWith("/")) {
			endPoint = endPoint.substring(0, endPoint.length() - 1);
		}
		this.endPoint = endPoint;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		if (queryParams.isEmpty()) {
			return params;
		}
		return queryParams.entrySet().stream()
			.map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
			.collect(Collectors.joining("&"));
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
}
