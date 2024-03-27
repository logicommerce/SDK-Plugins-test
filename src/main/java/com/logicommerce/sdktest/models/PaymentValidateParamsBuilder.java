package com.logicommerce.sdktest.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.models.payment.PaymentValidateParams;

/**
 * The PaymentValidateParamsBuilder class is responsible for building PaymentValidateParams objects. It provides methods
 * to set parameters and body for the PaymentValidateParams object.
 * 
 * @see PaymentValidateParams
 * @deprecated
 */
@Deprecated
public class PaymentValidateParamsBuilder {

	protected Map<String, String> params;

	protected String body;

	/**
	 * Constructs a new PaymentValidateParamsBuilder object. Initializes the params map with a LinkedHashMap and sets
	 * the default body value.
	 */
	public PaymentValidateParamsBuilder() {
		params = new LinkedHashMap<>();
		body = "body DEFAULT";
	}

	/**
	 * Adds a parameter to the params map.
	 * 
	 * @param name the name of the parameter
	 * @param value the value of the parameter
	 * @return the PaymentValidateParamsBuilder object
	 */
	public PaymentValidateParamsBuilder param(String name, String value) {
		params.put(name, value);
		return this;
	}

	/**
	 * Sets the body value for the PaymentValidateParams object.
	 * 
	 * @param body the body value
	 * @return the PaymentValidateParamsBuilder object
	 */
	public PaymentValidateParamsBuilder body(String body) {
		this.body = body;
		return this;
	}

	/**
	 * Builds and returns a PaymentValidateParams object with the set parameters and body.
	 * 
	 * @return the built PaymentValidateParams object
	 */
	public PaymentValidateParams build() {
		PaymentValidateParamsFake paramsValidate = new PaymentValidateParamsFake();
		paramsValidate.setParams(params);
		paramsValidate.setBody(body);
		return paramsValidate;
	}

}
