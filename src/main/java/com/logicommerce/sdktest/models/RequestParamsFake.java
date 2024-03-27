package com.logicommerce.sdktest.models;

import java.util.Map;
import com.logicommerce.sdk.models.RequestParams;

/**
 * A fake implementation of the RequestParams interface.
 * 
 * @since 1.3.5
 */
public class RequestParamsFake implements RequestParams {

	private Map<String, String> params;

	private String body;

	/**
	 * Retrieves the request parameters.
	 *
	 * @return The map of request parameters.
	 */
	@Override
	public Map<String, String> getParams() {
		return params;
	}

	/**
	 * Retrieves the request body.
	 *
	 * @return The request body.
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * Sets the request parameters.
	 *
	 * @param params The map of request parameters.
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	/**
	 * Sets the request body.
	 *
	 * @param body The request body.
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
