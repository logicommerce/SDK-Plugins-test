package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.models.order.AdditionalItem;
import com.logicommerce.sdk.models.order.CreditNote;

public class CreditNoteFake extends DocumentFake implements CreditNote {

	private List<AdditionalItem> additionalItems;

	@Override
	public List<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}

	public void setAdditionalItems(List<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}

}
