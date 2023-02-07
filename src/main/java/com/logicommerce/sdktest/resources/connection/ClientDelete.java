package com.logicommerce.sdktest.resources.connection;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

public class ClientDelete extends Client {

	public ClientDelete(ClientAttributes attributes) {
		super(attributes);
	}

	@Override
	protected HttpUriRequestBase getHttpBase(String url) {
		return new HttpDelete(url);
	}

}
