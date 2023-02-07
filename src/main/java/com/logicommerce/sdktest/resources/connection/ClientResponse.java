package com.logicommerce.sdktest.resources.connection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientResponse {

	private String response;

	private int statusCode;

	private Map<String, List<String>> headers;

	public ClientResponse(int statusCode, String response) {
		this.statusCode = statusCode;
		this.response = response;
	}

	public String getResponse() {
		return this.response;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}

	public void addHeader(String name, List<String> values) {
		if (this.headers == null) {
			this.headers = new HashMap<>();
		}
		this.headers.put(name, values);
	}
}
