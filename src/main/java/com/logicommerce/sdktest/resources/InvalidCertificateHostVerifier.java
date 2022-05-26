package com.logicommerce.sdktest.resources;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class InvalidCertificateHostVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String hostname, SSLSession session) {
		return hostname.equalsIgnoreCase(session.getPeerHost());
	}

}