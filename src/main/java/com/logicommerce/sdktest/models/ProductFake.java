package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Product;
import com.logicommerce.sdk.models.ProductCodes;
import com.logicommerce.sdk.models.ProductLanguage;
import com.logicommerce.sdk.models.ProductMedia;

public class ProductFake implements Product {

	private Integer id;
	
	private ProductCodes codes;
	
	private ProductLanguage language;
	
	private ProductMedia mainImages;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public ProductCodes getCodes() {
		return codes;
	}

	@Override
	public ProductLanguage getLanguage() {
		return language;
	}

	@Override
	public ProductMedia getImages() {
		return mainImages;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCodes(ProductCodes codes) {
		this.codes = codes;
	}

	public void setLanguage(ProductLanguage language) {
		this.language = language;
	}
	
	public void setImages(ProductMedia mainImages) {
		this.mainImages = mainImages;
	}
}