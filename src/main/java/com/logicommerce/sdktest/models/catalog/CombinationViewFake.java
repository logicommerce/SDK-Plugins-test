package com.logicommerce.sdktest.models.catalog;

import java.util.List;
import java.util.Map;
import com.logicommerce.sdk.enums.StockStatus;
import com.logicommerce.sdk.models.catalog.CombinationView;
import com.logicommerce.sdk.models.catalog.PriceView;

public class CombinationViewFake implements CombinationView {

	private List<Integer> optionValueIds;

	private String sku;

	private Map<String, String> barcodes;

	private PriceView price;

	private PriceView previousPrice;

	private StockStatus stockStatus;

	@Override
	public List<Integer> getOptionValueIds() {
		return optionValueIds;
	}

	@Override
	public String getSku() {
		return sku;
	}

	@Override
	public Map<String, String> getBarcodes() {
		return barcodes;
	}

	@Override
	public PriceView getPrice() {
		return price;
	}

	@Override
	public PriceView getPreviousPrice() {
		return previousPrice;
	}

	@Override
	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setOptionValueIds(List<Integer> optionValueIds) {
		this.optionValueIds = optionValueIds;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setBarcodes(Map<String, String> barcodes) {
		this.barcodes = barcodes;
	}

	public void setPrice(PriceView price) {
		this.price = price;
	}

	public void setPreviousPrice(PriceView previousPrice) {
		this.previousPrice = previousPrice;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}
}
