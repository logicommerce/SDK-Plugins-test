package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.PriceRange;

public class PriceRangeFakeBuilder<T> {

	private T parentBuilder;
	private PriceViewFakeBuilder<PriceRangeFakeBuilder<T>> min;
	private PriceViewFakeBuilder<PriceRangeFakeBuilder<T>> max;

	public PriceRangeFakeBuilder() {
		min = new PriceViewFakeBuilder<>(this);
		max = new PriceViewFakeBuilder<>(this);
	}

	public PriceRangeFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public PriceViewFakeBuilder<PriceRangeFakeBuilder<T>> min() {
		return min;
	}

	public PriceViewFakeBuilder<PriceRangeFakeBuilder<T>> max() {
		return max;
	}

	public PriceRange build() {
		PriceRangeFake priceRange = new PriceRangeFake();
		priceRange.setMin(min.build());
		priceRange.setMax(max.build());
		return priceRange;
	}

	public T done() {
		return parentBuilder;
	}
}
