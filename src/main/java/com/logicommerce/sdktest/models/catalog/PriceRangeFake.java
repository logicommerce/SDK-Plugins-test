package com.logicommerce.sdktest.models.catalog;

import com.logicommerce.sdk.models.catalog.PriceRange;
import com.logicommerce.sdk.models.catalog.PriceView;

public class PriceRangeFake implements PriceRange {

	private PriceView min;

	private PriceView max;

	@Override
	public PriceView getMin() {
		return min;
	}

	@Override
	public PriceView getMax() {
		return max;
	}

	public void setMin(PriceView min) {
		this.min = min;
	}

	public void setMax(PriceView max) {
		this.max = max;
	}
}
