package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.RowCodesBuilder;

public class RowCodesFakeBuilder<T> extends RowCodesBuilder<T> {

	public RowCodesFakeBuilder() {
		super();
		defaultValues();
	}

	public RowCodesFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	private void defaultValues() {
		super.pId = "default_pId";
		super.ean = "ean DEFAULT";
		super.isbn = "isbn DEFAULT";
		super.jan = "jan DEFAULT";
		super.manufacturerSku = "manufacturerSku DEFAULT";
		super.sku = "sku DEFAULT";
		super.upc = "upc DEFAULT";		
	}
}
