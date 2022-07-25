package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Brand;

public class BrandFake implements Brand {

	private Integer id;
	private String pId;
	private String name;
	private String urlSeo;
	private String imageUrl;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getPId() {
		return pId;
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
	public String getImageUrl() {
		return imageUrl;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
