package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Product;

public class ProductFakeBuilder {

	protected Integer id;
	
	protected ProductLanguageFakeBuilder language;
	
	protected ProductCodesBuilder<ProductFakeBuilder> codes;
	
	protected ProductMediaFakeBuilder mainImages;
	
	public ProductFakeBuilder() {
		id = 0;
		language = new ProductLanguageFakeBuilder(this);
		codes = new ProductCodesBuilder<>(this);
		mainImages = new ProductMediaFakeBuilder(this);
	}
	
	public ProductFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}
	
	public ProductLanguageFakeBuilder language() {
		return language;
	}
	
	public ProductMediaFakeBuilder mainImages() {
		return mainImages;
	}
	
	public ProductCodesBuilder<ProductFakeBuilder> codes(){
		return codes;
	}
	
	public Product build() {
		ProductFake product = new ProductFake();
		product.setId(id);
		product.setLanguage(language.build());
		product.setCodes(codes.build());
		product.setImages(mainImages.build());
		return product;
	}
}
