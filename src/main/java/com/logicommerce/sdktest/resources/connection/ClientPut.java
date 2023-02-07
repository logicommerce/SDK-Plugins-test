package com.logicommerce.sdktest.resources.connection;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

public class ClientPut extends Client {

	public ClientPut(ClientAttributes attributes) {
		super(attributes);
	}

	@Override
	protected HttpUriRequestBase getHttpBase(String url) {
		return new HttpPut(url);
	}

}
