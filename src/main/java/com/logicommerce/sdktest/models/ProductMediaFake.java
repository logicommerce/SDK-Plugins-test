package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.ProductMedia;

public class ProductMediaFake implements ProductMedia {

	private String smallImage;
	
	private String mediumImage;

	private String largeImage;
	
	public ProductMediaFake(ProductMediaFakeBuilder builder) {
		smallImage = builder.smallImage;
		mediumImage = builder.mediumImage;
		largeImage = builder.largeImage;
	}

	@Override
	public String getMediumImage() {
		return smallImage;
	}

	@Override
	public String getSmallImage() {
		return mediumImage;
	}

	@Override
	public String getlargeImage() {
		return largeImage;
	}
}