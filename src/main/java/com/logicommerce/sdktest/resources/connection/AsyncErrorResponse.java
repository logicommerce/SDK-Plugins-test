package com.logicommerce.sdktest.resources.connection;

import java.io.InputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.cookie.Cookie;
import org.asynchttpclient.Response;
import org.asynchttpclient.uri.Uri;

public class AsyncErrorResponse implements Response {
	
	private int statusCode;
	private String responseBody;

	@Override
	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String getStatusText() {
		return null;
	}

	@Override
	public byte[] getResponseBodyAsBytes() {
		return new byte[0];
	}

	@Override
	public ByteBuffer getResponseBodyAsByteBuffer() {
		return null;
	}

	@Override
	public InputStream getResponseBodyAsStream() {
		return null;
	}

	@Override
	public String getResponseBody(Charset charset) {
		return null;
	}

	@Override
	public String getResponseBody() {
		return this.responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public Uri getUri() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public String getHeader(CharSequence name) {
		return null;
	}

	@Override
	public List<String> getHeaders(CharSequence name) {
		return new ArrayList<>();
	}

	@Override
	public HttpHeaders getHeaders() {
		return null;
	}

	@Override
	public boolean isRedirected() {
		return false;
	}

	@Override
	public List<Cookie> getCookies() {
		return new ArrayList<>();
	}

	@Override
	public boolean hasResponseStatus() {
		return true;
	}

	@Override
	public boolean hasResponseHeaders() {
		return false;
	}

	@Override
	public boolean hasResponseBody() {
		return true;
	}

	@Override
	public SocketAddress getRemoteAddress() {
		return null;
	}

	@Override
	public SocketAddress getLocalAddress() {
		return null;
	}
}
