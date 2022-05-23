package com.logicommerce.sdktest.resources;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class InvalidCertificateTrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] certificates, String authType) throws CertificateException {
		// Pass
	}

	@Override
	public void checkServerTrusted(X509Certificate[] certificates, String authType) throws CertificateException {
		// Pass
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	}

}
