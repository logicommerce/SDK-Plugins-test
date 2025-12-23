package com.logicommerce.sdktest.resources.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

public abstract class Client {

	private static final String ACCEPT = "Accept";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String COOKIE = "Cookie";
	private static final String AUTHORIZATION = "Authorization";

	private HttpUriRequestBase http;

	private ClientAttributes attributes;

	protected Client(ClientAttributes attributes) {
		this.http = getHttpBase(attributes.getStringUrl());
		this.attributes = attributes;
	}

	protected abstract HttpUriRequestBase getHttpBase(String url);

	public ClientResponse send() throws ConnectionException {
		try (CloseableHttpClient client = createClient()) {
			setAuthorization();
			setBody();
			setHeaders();
			CloseableHttpResponse response = client.execute(this.http);
			HttpEntity entity = response.getEntity();
			return new ClientResponse(response.getCode(), getResponse(entity));
		} catch (IOException e) {
			throw new ConnectionException(getClass(), e);
		}
	}

	private void setHeaders() {
		this.attributes.getHeaders().forEach(this::setHeader);
		this.setHeader(COOKIE, this.attributes.getCookies());
		this.setHeader(CONTENT_TYPE, this.attributes.getContentType());
		this.setHeader(ACCEPT, this.attributes.getAcceptType());
	}

	private void setHeader(String key, String value) {
		this.http.setHeader(key, value);
	}

	private void setAuthorization() {
		if (this.attributes.hasAuthorization()) {
			this.setHeader(AUTHORIZATION, this.attributes.getAuthorization());
		}
	}

	private void setBody() {
		if (this.attributes.hasBody()) {
			StringEntity entity = new StringEntity(this.attributes.getBody());
			this.http.setEntity(entity);
		}
	}

	private String getResponse(HttpEntity entity) throws IOException {
		if (entity.getContentLength() <= 0) {
			try {
				return EntityUtils.toString(entity);
			} catch (IOException | ParseException e) {
				return null;
			}
		}
		InputStream content = entity.getContent();
		InputStreamReader in = new InputStreamReader(content, this.attributes.getCharset());
		try (BufferedReader reader = new BufferedReader(in)) {
			return reader.lines().collect(Collectors.joining(""));
		} catch (IOException e) {
			return null;
		}
	}

	private CloseableHttpClient createClient() throws ConnectionException {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		if (this.attributes.hasTimeout()) {
			RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(this.attributes.getTimeout(), TimeUnit.MILLISECONDS)
					.setConnectionRequestTimeout(this.attributes.getTimeout(), TimeUnit.MILLISECONDS)
					.build();
			httpClientBuilder.setDefaultRequestConfig(config);
		}
		if (this.attributes.hasCertificate()) {
			PoolingHttpClientConnectionManager connectionManager = getConnectionManager();
			httpClientBuilder.setConnectionManager(connectionManager);
		}
		return httpClientBuilder.build();
	}

	private PoolingHttpClientConnectionManager getConnectionManager() throws ConnectionException {
		return PoolingHttpClientConnectionManagerBuilder.create()
			.setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
				.setSslContext(createSSLContext(this.attributes.getKeyStore()))
				.build())
			.build();
	}

	private SSLContext createSSLContext(KeyStore keyStore) throws ConnectionException {
		KeyManagerFactory kmf = null;
		try {
			kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(keyStore, "".toCharArray());
		} catch (NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException e) {
			throw new ConnectionException(this.getClass(), e);
		}
		try {
			SSLContext sslContext = SSLContext.getInstance(this.attributes.getSslProtocol());
			sslContext.init(kmf.getKeyManagers(), null, null);
			return sslContext;
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			throw new ConnectionException(this.getClass(), e);
		}
	}
}
