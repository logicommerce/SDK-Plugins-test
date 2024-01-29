package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.models.order.AdditionalItem;
import com.logicommerce.sdk.models.order.ReturnDocument;

public class ReturnDocumentFake extends DocumentFake implements ReturnDocument {

	private List<AdditionalItem> additionalItems;

	@Override
	public List<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}

	public void setAdditionalItems(List<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}

}
