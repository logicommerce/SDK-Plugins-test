package com.logicommerce.sdktest.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.models.RequestParams;

/**
 * A builder class for creating fake RequestParams objects.
 * 
 * @since 1.3.5
 */
public class RequestParamsFakeBuilder {

	protected Map<String, String> params;

	protected String body;

	/**
	 * Constructs a new RequestParamsFakeBuilder with default values.
	 */
	public RequestParamsFakeBuilder() {
		params = new LinkedHashMap<>();
		body = "body DEFAULT";
	}

	/**
	 * Adds a parameter to the builder.
	 *
	 * @param name the name of the parameter
	 * @param value the value of the parameter
	 * @return the RequestParamsFakeBuilder instance
	 */
	public RequestParamsFakeBuilder param(String name, String value) {
		params.put(name, value);
		return this;
	}

	/**
	 * Sets the parameters of the builder.
	 *
	 * @param params the parameters value
	 * @return the RequestParamsFakeBuilder instance
	 */
	public RequestParamsFakeBuilder params(Map<String, String> params) {
		this.params = params;
		return this;
	}

	/**
	 * Sets the body of the builder.
	 *
	 * @param body the body value
	 * @return the RequestParamsFakeBuilder instance
	 */
	public RequestParamsFakeBuilder body(String body) {
		this.body = body;
		return this;
	}

	/**
	 * Builds a RequestParams object with the current builder state.
	 *
	 * @return the created RequestParams object
	 */
	public RequestParams build() {
		RequestParamsFake requestParams = new RequestParamsFake();
		requestParams.setParams(params);
		requestParams.setBody(body);
		return requestParams;
	}
}
