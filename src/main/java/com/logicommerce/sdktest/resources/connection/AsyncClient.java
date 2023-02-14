package com.logicommerce.sdktest.resources.connection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClientConfig.Builder;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

public class AsyncClient {

	private static final String ACCEPT = "Accept";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String COOKIE = "Cookie";
	private static final String AUTHORIZATION = "Authorization";

	private ClientAttributes attributes;

	public AsyncClient(ClientAttributes attributes) {
		this.attributes = attributes;
	}

	public CompletableFuture<ClientResponse> get() {
		return send(getClient().prepareGet(attributes.getStringUrl()));
	}

	public CompletableFuture<ClientResponse> post(String body) {
		attributes.setBody(body);
		return send(getClient().preparePost(attributes.getStringUrl()));
	}

	public CompletableFuture<ClientResponse> put(String body) {
		attributes.setBody(body);
		return send(getClient().preparePut(attributes.getStringUrl()));
	}

	public CompletableFuture<ClientResponse> patch(String body) {
		attributes.setBody(body);
		return send(getClient().preparePatch(attributes.getStringUrl()));
	}

	public CompletableFuture<ClientResponse> delete() {
		return send(getClient().prepareDelete(attributes.getStringUrl()));
	}

	private AsyncHttpClient getClient() {
		Builder config = Dsl.config();
		if (attributes.hasTimeout()) {
			config.setRequestTimeout(attributes.getTimeout());
		}
		AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient(config);
		return asyncHttpClient;
	}

	private CompletableFuture<ClientResponse> send(BoundRequestBuilder request) {
		setAuthorization(request);
		setBody(request);
		setHeaders(request);
		return request.execute()
				.toCompletableFuture()
				.exceptionally(this::arrangeThrow)
				.thenApply(this::arrangeResponse);
	}

	private void setAuthorization(BoundRequestBuilder request) {
		if (attributes.hasAuthorization()) {
			request.addHeader(AUTHORIZATION, attributes.getAuthorization());
		}
	}

	private void setBody(BoundRequestBuilder request) {
		if (this.attributes.hasBody()) {
			request.setBody(this.attributes.getBody());
		}
	}

	private void setHeaders(BoundRequestBuilder request) {
		this.attributes.getHeaders().forEach(request::addHeader);
		request.addHeader(COOKIE, this.attributes.getCookies());
		request.addHeader(CONTENT_TYPE, this.attributes.getContentType());
		request.addHeader(ACCEPT, this.attributes.getAcceptType());
	}

	private ClientResponse arrangeResponse(Response response) {
		ClientResponse clientResponse = new ClientResponse(response.getStatusCode(), response.getResponseBody());
		HttpHeaders headers = response.getHeaders();
		Map<String, List<String>> responseHeaders = new HashMap<>();
		headers.forEach(entry -> responseHeaders.put(entry.getKey(), Arrays.asList(entry.getValue())));
		clientResponse.setHeaders(responseHeaders);
		return clientResponse;
	}

	private Response arrangeThrow(Throwable t) {
		AsyncErrorResponse response = new AsyncErrorResponse();
		response.setStatusCode(-1);
		response.setResponseBody(t.getMessage());
		return response;
	}
}
