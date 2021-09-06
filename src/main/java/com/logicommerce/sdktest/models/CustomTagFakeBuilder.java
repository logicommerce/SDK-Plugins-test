package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.CustomTagBuilder;

public class CustomTagFakeBuilder<T> extends CustomTagBuilder<T> {

	public CustomTagFakeBuilder() {
		super();
		defaultValues();
	}

	public CustomTagFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.name = "name DEFAULT";
		super.value = "value DEFAULT";
	}
}