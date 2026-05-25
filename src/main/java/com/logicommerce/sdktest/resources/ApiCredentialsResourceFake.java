package com.logicommerce.sdktest.resources;

import com.logicommerce.sdk.enums.ApiType;
import com.logicommerce.sdk.resources.ApiCredentialsResource;

public class ApiCredentialsResourceFake implements ApiCredentialsResource {

	@Override
	public String getAuthorizationHeader(ApiType apiType) {
		return "authorizationHeader-test-1234";
	}
}
