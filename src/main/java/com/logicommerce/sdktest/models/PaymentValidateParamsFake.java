package com.logicommerce.sdktest.models;

import java.util.Map;
import com.logicommerce.sdk.models.payment.PaymentValidateParams;

public class PaymentValidateParamsFake implements PaymentValidateParams {
	
	private Map<String, String> params;
	
	private String body;
	
	@Override
	public Map<String, String> getParams() {
		return params;
	}
	
	@Override
	public String getBody() {
		return body;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
