package com.logicommerce.sdktest.resources;

import java.util.concurrent.CompletableFuture;
import com.logicommerce.sdk.resources.AsyncConnection;
import com.logicommerce.sdk.resources.Response;
import com.logicommerce.sdktest.resources.connection.AsyncClient;
import com.logicommerce.sdktest.resources.connection.ClientAttributes;
import com.logicommerce.sdktest.resources.connection.ClientResponse;

public class AsyncConnectionHelper implements AsyncConnection {

	private ClientAttributes attributes;

	@Override
	public AsyncConnection init(String endPoint) {
		this.attributes = new ClientAttributes();
		this.attributes.setEndPoint(endPoint);
		return this;
	}

	@Override
	public CompletableFuture<Response> get() {
		return getClient().get()
				.thenApply(this::arrangeResponse);
	}

	@Override
	public CompletableFuture<Response> post(String body) {
		return getClient().post(body)
				.thenApply(this::arrangeResponse);
	}

	@Override
	public CompletableFuture<Response> put(String body) {
		return getClient().put(body)
				.thenApply(this::arrangeResponse);
	}

	@Override
	public CompletableFuture<Response> patch(String body) {
		return getClient().patch(body)
				.thenApply(this::arrangeResponse);
	}

	@Override
	public CompletableFuture<Response> delete() {
		return getClient().delete()
				.thenApply(this::arrangeResponse);
	}

	public AsyncClient getClient() {
		return new AsyncClient(attributes);
	}

	@Override
	public AsyncConnection authorization(String authorization) {
		this.attributes.setAuthorization(authorization);
		return this;
	}

	@Override
	public AsyncConnection path(String path) {
		this.attributes.setPath(path);
		return this;
	}

	@Override
	public AsyncConnection contentType(String contentType) {
		this.attributes.setContentType(contentType);
		return this;
	}

	@Override
	public AsyncConnection acceptType(String acceptType) {
		this.attributes.setAcceptType(acceptType);
		return this;
	}

	@Override
	public AsyncConnection header(String name, String value) {
		this.attributes.setHeader(name, value);
		return this;
	}

	@Override
	public AsyncConnection cookie(String name, String value) {
		this.attributes.setCookie(name, value);
		return this;
	}

	@Override
	public AsyncConnection queryParam(String name, String value) {
		this.attributes.setQueryParam(name, value);
		return this;
	}

	@Override
	public AsyncConnection params(String params) {
		this.attributes.setParams(params);
		return this;
	}

	@Override
	public AsyncConnection timeout(Integer timeout) {
		this.attributes.setTimeout(timeout);
		return this;
	}

	private Response arrangeResponse(ClientResponse clientResponse) {
		ResponseFake response = new ResponseFake();
		response.setHeaders(clientResponse.getHeaders());
		response.setStatusCode(clientResponse.getStatusCode());
		response.setResponse(clientResponse.getResponse());
		return response;
	}
	
}
