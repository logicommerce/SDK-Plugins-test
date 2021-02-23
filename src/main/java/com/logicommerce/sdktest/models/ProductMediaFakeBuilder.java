package com.logicommerce.sdktest.models;

public class ProductMediaFakeBuilder {
	
	private ProductFakeBuilder parentBuilder;

	protected String smallImage;
	
	protected String mediumImage;

	protected String largeImage;
	
	public ProductMediaFakeBuilder() {
		smallImage = "//test.test/smallImage.jpg";
		mediumImage = "//test.test/mediumImage.jpg";
		largeImage = "//test.test/largeImage.jpg";
	}
	
	public ProductMediaFakeBuilder(ProductFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public ProductMediaFakeBuilder smallImage(String smallImage) {
		this.smallImage = smallImage;
		return this;
	}
	
	public ProductMediaFakeBuilder urlSeo(String mediumImage) {
		this.mediumImage = mediumImage;
		return this;
	}
	
	public ProductMediaFakeBuilder largeImage(String largeImage) {
		this.largeImage = largeImage;
		return this;
	}
	
	public ProductMediaFake build() {
		return new ProductMediaFake(this);
	}
	
	public ProductFakeBuilder done() {
		return parentBuilder;
	}
}
