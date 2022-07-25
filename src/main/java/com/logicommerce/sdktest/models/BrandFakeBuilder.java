package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Brand;

public class BrandFakeBuilder {

	private CartItemFakeBuilder parentBuilder;
	private Integer id;
	private String pId;
	private String name;
	private String urlSeo;
	private String imageUrl;

	public BrandFakeBuilder() {
		id = 1;
		pId = "pId DEFAULT";
		name = "name DEFAULT";
		urlSeo = "urlSeo DEFAULT";
		imageUrl = "imageUrl DEFAULT";
	}

	public BrandFakeBuilder(CartItemFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public BrandFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public BrandFakeBuilder pId(String pId) {
		this.pId = pId;
		return this;
	}

	public BrandFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public BrandFakeBuilder urlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
		return this;
	}

	public BrandFakeBuilder imageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public Brand build() {
		BrandFake brand = new BrandFake();
		brand.setId(id);
		brand.setPId(pId);
		brand.setName(name);
		brand.setUrlSeo(urlSeo);
		brand.setImageUrl(imageUrl);
		return brand;
	}

	public CartItemFakeBuilder done() {
		return parentBuilder;
	}
}
