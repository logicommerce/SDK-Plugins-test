package com.logicommerce.sdktest.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.models.ProductLanguage;

public class ProductLanguageFakeBuilder {
	
	private ProductFakeBuilder parentBuilder;

	protected String name;
	
	protected String urlSeo;
	
	protected Map<String, String> linkAttributes;
	
	public ProductLanguageFakeBuilder() {
		name = "name DEFAULT";
		urlSeo = "urlSeo DEFAULT";
		linkAttributes = new LinkedHashMap<>();
	}
	
	public ProductLanguageFakeBuilder(ProductFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public ProductLanguageFakeBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public ProductLanguageFakeBuilder urlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
		return this;
	}
	
	public ProductLanguageFakeBuilder linkAttribute(String name, String value) {
		linkAttributes.put(name, value);
		return this;
	}
	
	public ProductLanguage build() {
		return new ProductLanguageFake(this);
	}
	
	public ProductFakeBuilder done() {
		return parentBuilder;
	}
}
