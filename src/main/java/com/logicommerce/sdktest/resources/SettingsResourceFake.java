package com.logicommerce.sdktest.resources;

import com.logicommerce.sdk.resources.SettingsResource;

public class SettingsResourceFake implements SettingsResource {

	@Override
	public Integer getCommerceId() {
		return 1;
	}

	@Override
	public String getApiBackUrl() {
		return "https://test.com/backUrl";
	}

	@Override
	public String getApiFrontUrl() {
		return "https://test.com/frontUrl";
	}

	@Override
	public Integer getEnvironmentId() {
		return 2;
	}
}
