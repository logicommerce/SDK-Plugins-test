package com.logicommerce.sdktest.resources;

import com.logicommerce.sdk.resources.Connection;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdk.resources.Response;

public class ConnectionFake implements Connection {

	@Override
	public Connection init(String endPoint) {
		return this;
	}

	@Override
	public Response get() throws PluginResourceException {
		return null;
	}

	@Override
	public Response post(String body) throws PluginResourceException {
		return null;
	}

	@Override
	public Response put(String body) throws PluginResourceException {
		return null;
	}

	@Override
	public Response patch(String body) throws PluginResourceException {
		return null;
	}

	@Override
	public Response delete() throws PluginResourceException {
		return null;
	}

	@Override
	public Connection authorization(String authorization) {
		return this;
	}

	@Override
	public Connection path(String path) {
		return this;
	}

	@Override
	public Connection contentType(String contentType) {
		return this;
	}

	@Override
	public Connection acceptType(String acceptType) {
		return this;
	}

	@Override
	public Connection params(String params) {
		return this;
	}

	@Override
	public Connection header(String name, String value) {
		return this;
	}

	@Override
	public Connection cookie(String name, String value) {
		return this;
	}

	@Override
	public Connection timeout(Integer arg0) {
		return this;
	}

	@Override
	public Connection queryParam(String name, String value) {
		return this;
	}

}
