package com.logicommerce.sdktest.resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.logicommerce.sdk.resources.Response;

public class ResponseFakeBuilder {

	protected String response;

	protected int statusCode;

	protected Map<String, List<String>> headers;

	public ResponseFakeBuilder() {
		response = "";
		statusCode = 200;
		headers = new LinkedHashMap<>();
	}

	public ResponseFakeBuilder response(String response) {
		this.response = response;
		return this;
	}

	public ResponseFakeBuilder statusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public ResponseFakeBuilder header(String name, List<String> headersValue) {
		this.headers.put(name, headersValue);
		return this;
	}
	
	public Response build() {
		return new ResponseFake(this);
	}

}
