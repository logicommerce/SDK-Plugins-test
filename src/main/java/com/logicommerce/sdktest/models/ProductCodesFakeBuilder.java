package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.builders.ProductCodesBuilder;

public class ProductCodesFakeBuilder<T> extends ProductCodesBuilder<T>{

	public ProductCodesFakeBuilder() {
		super();
		defaultValues();
	}

	public ProductCodesFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.ean = "ean DEFAULT";
		super.isbn = "isbn DEFAULT";
		super.jan = "jan DEFAULT";
		super.manufacturerSku = "manufacturerSku DEFAULT";
		super.sku = "sku DEFAULT";
		super.upc = "upc DEFAULT";		
	}
}