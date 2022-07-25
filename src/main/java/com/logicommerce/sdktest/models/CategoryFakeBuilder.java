package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Category;

public class CategoryFakeBuilder {

	private CartItemFakeBuilder parentBuilder;
	private Integer id;
	private String name;

	public CategoryFakeBuilder() {
		id = 1;
		name = "name DEFAULT";
	}

	public CategoryFakeBuilder(CartItemFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CategoryFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public CategoryFakeBuilder name(String name) {
		this.name = name;
		return this;
	}

	public Category build() {
		CategoryFake category = new CategoryFake();
		category.setId(id);
		category.setName(name);
		return category;
	}

	public CartItemFakeBuilder done() {
		return parentBuilder;
	}
}
