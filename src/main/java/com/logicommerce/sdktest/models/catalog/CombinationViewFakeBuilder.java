package com.logicommerce.sdktest.models.catalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.logicommerce.sdk.enums.StockStatus;
import com.logicommerce.sdk.models.catalog.CombinationView;

public class CombinationViewFakeBuilder<T> {

	private T parentBuilder;
	private List<Integer> optionValueIds;
	private String sku;
	private Map<String, String> barcodes;
	private PriceViewFakeBuilder<CombinationViewFakeBuilder<T>> price;
	private PriceViewFakeBuilder<CombinationViewFakeBuilder<T>> previousPrice;
	private StockStatus stockStatus;

	public CombinationViewFakeBuilder() {
		optionValueIds = new ArrayList<>();
		sku = "sku DEFAULT";
		barcodes = new LinkedHashMap<>();
	}

	public CombinationViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public CombinationViewFakeBuilder<T> optionValueIds(List<Integer> optionValueIds) {
		this.optionValueIds = optionValueIds;
		return this;
	}

	public CombinationViewFakeBuilder<T> sku(String sku) {
		this.sku = sku;
		return this;
	}

	public CombinationViewFakeBuilder<T> barcodes(Map<String, String> barcodes) {
		this.barcodes = barcodes;
		return this;
	}

	public PriceViewFakeBuilder<CombinationViewFakeBuilder<T>> price() {
		if (price == null) {
			price = new PriceViewFakeBuilder<>(this);
		}
		return price;
	}

	public PriceViewFakeBuilder<CombinationViewFakeBuilder<T>> previousPrice() {
		if (previousPrice == null) {
			previousPrice = new PriceViewFakeBuilder<>(this);
		}
		return previousPrice;
	}

	public CombinationViewFakeBuilder<T> stockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
		return this;
	}

	/**
	 * Builds the combination. Without an explicit {@link #stockStatus(StockStatus) stockStatus} it is
	 * {@link StockStatus#IN_STOCK}.
	 *
	 * @return the combination
	 */
	public CombinationView build() {
		return build(StockStatus.IN_STOCK);
	}

	CombinationView build(StockStatus defaultStockStatus) {
		CombinationViewFake combinationView = new CombinationViewFake();
		combinationView.setOptionValueIds(optionValueIds);
		combinationView.setSku(sku);
		combinationView.setBarcodes(barcodes);
		combinationView.setPrice(price == null ? null : price.build());
		combinationView.setPreviousPrice(previousPrice == null ? null : previousPrice.build());
		combinationView.setStockStatus(stockStatus == null ? defaultStockStatus : stockStatus);
		return combinationView;
	}

	boolean hasPrice() {
		return price != null;
	}

	public T done() {
		return parentBuilder;
	}
}
