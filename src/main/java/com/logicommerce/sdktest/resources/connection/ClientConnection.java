package com.logicommerce.sdktest.resources.connection;

import java.nio.charset.Charset;
import java.security.KeyStore;

public class ClientConnection {

	private ClientAttributes attributes;

	public ClientConnection(String endPoint) {
		this.attributes = new ClientAttributes();
		attributes.setEndPoint(endPoint);
	}

	public ClientConnection authorization(String authorization) {
		validateArgs(authorization);
		attributes.setAuthorization(authorization);
		return this;
	}

	public ClientConnection path(String path) {
		validateArgs(path);
		attributes.setPath(path);
		return this;
	}

	public ClientConnection contentType(String contentType) {
		validateArgs(contentType);
		attributes.setContentType(contentType);
		return this;
	}

	public ClientConnection acceptType(String acceptType) {
		validateArgs(acceptType);
		attributes.setAcceptType(acceptType);
		return this;
	}

	public ClientConnection params(String params) {
		validateArgs(params);
		attributes.setParams(params);
		return this;
	}

	public ClientConnection header(String name, String value) {
		validateArgs(name, value);
		attributes.setHeader(name, value);
		return this;
	}

	public ClientConnection cookie(String name, String value) {
		validateArgs(name, value);
		attributes.setCookie(name, value);
		return this;
	}

	public ClientConnection queryParam(String name, String value) {
		validateArgs(name, value);
		attributes.setQueryParam(name, value);
		return this;
	}

	public ClientConnection timeout(Integer timeout) {
		validateArgs(timeout);
		attributes.setTimeout(timeout);
		return this;
	}
	
	public ClientConnection charset(Charset charset) {
		validateArgs(charset);
		attributes.setCharset(charset);
		return this;
	}


	public ClientResponse get() throws ConnectionException {
		return send(new ClientGet(attributes));
	}

	public ClientResponse post(String body) throws ConnectionException {
		validateArgs(body);
		attributes.setBody(body);
		return send(new ClientPost(attributes));
	}

	public ClientResponse put(String body) throws ConnectionException {
		validateArgs(body);
		attributes.setBody(body);
		return send(new ClientPut(attributes));
	}

	public ClientResponse patch(String body) throws ConnectionException {
		validateArgs(body);
		attributes.setBody(body);
		return send(new ClientPatch(attributes));
	}

	public ClientResponse delete() throws ConnectionException {
		return send(new ClientDelete(attributes));
	}

	private ClientResponse send(Client client) throws ConnectionException {
		return client.send();
	}

	private void validateArgs(Object... args) {
		if (args == null) {
			throw new IllegalArgumentException();
		}
		for (Object arg : args) {
			if (arg == null) {
				throw new IllegalArgumentException();
			}
		}
	}

	public ClientConnection sslProtocol(String sslProtocol) {
		validateArgs(sslProtocol);
		attributes.setSslProtocol(sslProtocol);
		return this;
	}

	public ClientConnection keyStore(KeyStore keyStore) {
		attributes.setKeyStore(keyStore);
		return this;
	}

}
