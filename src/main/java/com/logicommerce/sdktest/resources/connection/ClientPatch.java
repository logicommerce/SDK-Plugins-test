package com.logicommerce.sdktest.resources.connection;

import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

public class ClientPatch extends Client {

	public ClientPatch(ClientAttributes attributes) {
		super(attributes);
	}

	@Override
	protected HttpUriRequestBase getHttpBase(String url) {
		return new HttpPatch(url);
	}

}
