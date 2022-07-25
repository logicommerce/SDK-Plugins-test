package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Category;

public class CategoryFake implements Category {

	private Integer id;
	private String name;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
