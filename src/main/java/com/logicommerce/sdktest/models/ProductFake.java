package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Product;
import com.logicommerce.sdk.models.ProductLanguage;
import com.logicommerce.sdk.models.ProductMedia;
import com.logicommerce.sdk.models.RowCodes;

public class ProductFake implements Product {

	private Integer id;
	
	private RowCodes codes;
	
	private ProductLanguage language;
	
	private ProductMedia mainImages;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public RowCodes getCodes() {
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
	
	public void setCodes(RowCodes codes) {
		this.codes = codes;
	}

	public void setLanguage(ProductLanguage language) {
		this.language = language;
	}
	
	public void setImages(ProductMedia mainImages) {
		this.mainImages = mainImages;
	}
}