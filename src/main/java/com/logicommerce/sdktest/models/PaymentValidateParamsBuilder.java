package com.logicommerce.sdktest.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.models.payment.PaymentValidateParams;

public class PaymentValidateParamsBuilder {

	protected Map<String, String> params;

	protected String body;

	public PaymentValidateParamsBuilder() {
		params = new LinkedHashMap<>();
		body = "body DEFAULT";
	}

	public PaymentValidateParamsBuilder param(String name, String value) {
		params.put(name, value);
		return this;
	}

	public PaymentValidateParamsBuilder body(String body) {
		this.body = body;
		return this;
	}

	public PaymentValidateParams build() {
		PaymentValidateParamsFake paramsValidate = new PaymentValidateParamsFake();
		paramsValidate.setParams(params);
		paramsValidate.setBody(body);
		return paramsValidate;
	}

}
