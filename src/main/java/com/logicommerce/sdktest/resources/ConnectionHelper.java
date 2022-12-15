package com.logicommerce.sdktest.resources;

import com.logicommerce.sdk.resources.Connection;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdk.resources.Response;
import com.logicommerce.sdktest.resources.connection.ClientConnection;
import com.logicommerce.sdktest.resources.connection.ClientResponse;
import com.logicommerce.sdktest.resources.connection.ConnectionException;

public class ConnectionHelper implements Connection {

	private ClientConnection clientConnection;


	@Override
	public Connection init(String endPoint) {
		this.clientConnection = new ClientConnection(endPoint);
		return this;
	}

	@Override
	public Connection authorization(String authorization) {
		this.clientConnection.authorization(authorization);
		return this;
	}

	@Override
	public Connection path(String path) {
		this.clientConnection.path(path);
		return this;
	}

	@Override
	public Connection contentType(String contentType) {
		this.clientConnection.contentType(contentType);
		return this;
	}

	@Override
	public Connection acceptType(String acceptType) {
		this.clientConnection.acceptType(acceptType);
		return this;
	}

	@Override
	public Connection params(String params) {
		this.clientConnection.params(params);
		return this;
	}

	@Override
	public Connection header(String name, String value) {
		this.clientConnection.header(name, value);
		return this;
	}

	@Override
	public Connection cookie(String name, String value) {
		this.clientConnection.cookie(name, value);
		return this;
	}

	@Override
	public Connection queryParam(String name, String value) {
		this.clientConnection.queryParam(name, value);
		return this;
	}

	@Override
	public Connection timeout(Integer timeout) {
		this.clientConnection.timeout(timeout);
		return this;
	}

	@Override
	public Response get() throws PluginResourceException {
		try {
			return arrangeResponse(this.clientConnection.get());
		} catch (ConnectionException e) {
			throw new PluginResourceException(this.getClass(), e);
		}
	}

	@Override
	public Response post(String body) throws PluginResourceException {
		try {
			return arrangeResponse(this.clientConnection.post(body));
		} catch (ConnectionException e) {
			throw new PluginResourceException(this.getClass(), e);
		}
	}

	@Override
	public Response put(String body) throws PluginResourceException {
		try {
			return arrangeResponse(this.clientConnection.put(body));
		} catch (ConnectionException e) {
			throw new PluginResourceException(this.getClass(), e);
		}
	}

	@Override
	public Response patch(String body) throws PluginResourceException {
		try {
			return arrangeResponse(this.clientConnection.patch(body));
		} catch (ConnectionException e) {
			throw new PluginResourceException(this.getClass(), e);
		}
	}

	@Override
	public Response delete() throws PluginResourceException {
		try {
			return arrangeResponse(this.clientConnection.delete());
		} catch (ConnectionException e) {
			throw new PluginResourceException(this.getClass(), e);
		}
	}

	private Response arrangeResponse(ClientResponse clientResponse) {
		ResponseFake response = new ResponseFake();
		response.setHeaders(clientResponse.getHeaders());
		response.setStatusCode(clientResponse.getStatusCode());
		response.setResponse(clientResponse.getResponse());
		return response;
	}

}
