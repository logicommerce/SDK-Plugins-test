package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.logicommerce.sdk.resources.Response;

public class ResponseFake implements Response {

	private String response;

	private int statusCode;

	private Map<String, List<String>> headers;
	
	public ResponseFake() {
		headers = new LinkedHashMap<>();
	}

	public ResponseFake(ResponseFakeBuilder builder) {
		response = builder.response;
		statusCode = builder.statusCode;
		headers = builder.headers;
	}

	@Override
	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}
	
	public void addHeader(String key, List<String> header) {
		this.headers.put(key, header);
	}
}
