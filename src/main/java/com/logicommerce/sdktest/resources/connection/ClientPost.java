package com.logicommerce.sdktest.resources.connection;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

public class ClientPost extends Client {

	public ClientPost(ClientAttributes attributes) {
		super(attributes);
	}

	@Override
	protected HttpUriRequestBase getHttpBase(String url) {
		return new HttpPost(url);
	}

}
