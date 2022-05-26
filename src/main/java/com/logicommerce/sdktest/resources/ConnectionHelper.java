package com.logicommerce.sdktest.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import com.logicommerce.sdk.resources.Connection;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdk.resources.Response;

public class ConnectionHelper implements Connection {

	private ConnectionAttributes attributes;

	private static final String SSL_PROTOCOL = "TLS";
	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";
	private static final String PATCH = "PATCH";
	private static final String ACCEPT = "Accept";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String COOKIE = "Cookie";
	private static final String AUTHORIZATION = "Authorization";
	private static final String X_HTTP_METHOD_OVERRIDE = "X-HTTP-Method-Override";

	private static final int BAD_REQUEST = 400;

	@Override
	public Connection init(String endPoint) {
		this.attributes = new ConnectionAttributes();
		attributes.setEndPoint(endPoint);
		return this;
	}

	@Override
	public Response get() throws PluginResourceException {
		return send(GET);
	}

	@Override
	public Response post(String body) throws PluginResourceException {
		attributes.setBody(body);
		return send(POST);
	}

	@Override
	public Response put(String body) throws PluginResourceException {
		attributes.setBody(body);
		return send(PUT);
	}

	@Override
	public Response patch(String body) throws PluginResourceException {
		attributes.setBody(body);
		return send(PATCH);
	}

	@Override
	public Response delete() throws PluginResourceException {
		return send(DELETE);
	}

	private Response send(String method) throws PluginResourceException {
		attributes.setMethod(method);
		HttpURLConnection connection;
		ResponseFake response = new ResponseFake();
		try {
			connection = getConnection(attributes.getUrl());
			setConnectionValues(connection);
			response.setStatusCode(connection.getResponseCode());
			response.setHeaders(connection.getHeaderFields());
			response.setResponse(processResponse(connection));
			connection.disconnect();
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			throw new PluginResourceException(e);
		}
		return response;
	}

	private HttpURLConnection getConnection(URL url) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		if (!attributes.isSSLConnection()) {
			return (HttpURLConnection) url.openConnection();
		}
		setSSLContect();
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setHostnameVerifier(new InvalidCertificateHostVerifier());
		return connection;
	}

	private void setSSLContect() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext ctx = SSLContext.getInstance(SSL_PROTOCOL);
		ctx.init(null, new TrustManager[] {new InvalidCertificateTrustManager()}, null);
		SSLContext.setDefault(ctx);
	}

	private void setConnectionValues(HttpURLConnection connection) throws IOException {
		if (attributes.getMethod().equals(PATCH)) {
			connection.setRequestMethod(POST);
			attributes.setHeader(X_HTTP_METHOD_OVERRIDE, PATCH);
		} else {
			connection.setRequestMethod(attributes.getMethod());
		}
		setRequestProperties(connection);
		connection.setDoOutput(true);
		connection.setConnectTimeout(attributes.getTimeout());
		if (attributes.hasBody()) {
			OutputStream os = connection.getOutputStream();
			byte[] input = attributes.getBody().getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}
	}

	private void setRequestProperties(HttpURLConnection connection) {
		if (attributes.hasAuthorization()) {
			connection.setRequestProperty(AUTHORIZATION, attributes.getAuthorization());
		}
		attributes.getHeaders().forEach(connection::setRequestProperty);
		connection.setRequestProperty(COOKIE, attributes.getCookies());
		connection.setRequestProperty(CONTENT_TYPE, attributes.getContentType());
		connection.setRequestProperty(ACCEPT, attributes.getAcceptType());
	}

	private String processResponse(HttpURLConnection connection) throws IOException {
		InputStream inputStream;
		if (connection.getResponseCode() < BAD_REQUEST) {
			inputStream = connection.getInputStream();
		} else {
			inputStream = connection.getErrorStream();
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder responseBuilder = new StringBuilder();
		String readLine = null;
		while ((readLine = in.readLine()) != null) {
			responseBuilder.append(readLine);
		}
		in.close();
		return responseBuilder.toString();
	}

	@Override
	public Connection authorization(String authorization) {
		attributes.setAuthorization(authorization);
		return this;
	}

	@Override
	public Connection path(String path) {
		attributes.setPath(path);
		return this;
	}

	@Override
	public Connection contentType(String contentType) {
		attributes.setContentType(contentType);
		return this;
	}

	@Override
	public Connection acceptType(String acceptType) {
		attributes.setAcceptType(acceptType);
		return this;
	}

	@Override
	public Connection params(String params) {
		attributes.setParams(params);
		return this;
	}

	@Override
	public Connection header(String name, String value) {
		attributes.setHeader(name, value);
		return this;
	}

	@Override
	public Connection cookie(String name, String value) {
		attributes.setCookie(name, value);
		return this;
	}

	@Override
	public Connection timeout(Integer timeout) {
		attributes.setTimeout(timeout);
		return this;
	}

	@Override
	public Connection queryParam(String name, String value) {
		attributes.setQueryParam(name, value);
		return this;
	}

}
