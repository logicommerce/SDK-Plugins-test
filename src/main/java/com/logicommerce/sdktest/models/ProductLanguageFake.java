package com.logicommerce.sdktest.models;

import java.util.Map;
import com.logicommerce.sdk.models.ProductLanguage;

public class ProductLanguageFake implements ProductLanguage {

	private String name;

	private String urlSeo;
	
	private Map<String, String> linkAttributes;

	public ProductLanguageFake(ProductLanguageFakeBuilder builder) {
		name = builder.name;
		urlSeo = builder.urlSeo;
		linkAttributes = builder.linkAttributes;
	}

	@Override
	public void addLinkAttribute(String name, String value) {
		linkAttributes.put(name, value);
	}

	@Override
	public Map<String, String> getLinkAttributes() {
		return linkAttributes;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUrlSeo() {
		return urlSeo;
	}

	@Override
	public void setLinkAttributes(Map<String, String> linkAttributes) {
		this.linkAttributes = linkAttributes;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUrlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
	}

}
