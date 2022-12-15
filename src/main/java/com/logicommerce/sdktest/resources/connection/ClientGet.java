package com.logicommerce.sdktest.resources.connection;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

public class ClientGet extends Client {

	public ClientGet(ClientAttributes attributes) {
		super(attributes);
	}

	@Override
	protected HttpUriRequestBase getHttpBase(String url) {
		return new HttpGet(url);
	}

}
