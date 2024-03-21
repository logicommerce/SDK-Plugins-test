package com.logicommerce.sdktest.models;

import java.util.Map;
import com.logicommerce.sdk.models.payment.PaymentValidateParams;

/**
 * A fake implementation of the PaymentValidateParams interface. This class is used for testing purposes.
 * 
 * @see PaymentValidateParams
 * @deprecated
 */
@Deprecated
public class PaymentValidateParamsFake implements PaymentValidateParams {

	private Map<String, String> params;

	private String body;

	/**
	 * Retrieves the parameters for the payment validation.
	 * 
	 * @return The parameters as a map of key-value pairs.
	 */
	@Override
	public Map<String, String> getParams() {
		return params;
	}

	/**
	 * Retrieves the body for the payment validation.
	 * 
	 * @return The body as a string.
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * Sets the parameters for the payment validation.
	 * 
	 * @param params The parameters as a map of key-value pairs.
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	/**
	 * Sets the body for the payment validation.
	 * 
	 * @param body The body as a string.
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
