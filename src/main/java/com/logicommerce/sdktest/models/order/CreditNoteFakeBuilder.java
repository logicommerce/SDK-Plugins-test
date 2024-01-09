package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreditNoteFakeBuilder extends DocumentFakeBuilder<CreditNoteFakeBuilder> {

	private List<AdditionalItemFakeBuilder> additionalItems;

	public CreditNoteFakeBuilder() {
		super();
		additionalItems = new ArrayList<>();
	}

	public AdditionalItemFakeBuilder additionalItem() {
		AdditionalItemFakeBuilder additionalItem = new AdditionalItemFakeBuilder(this);
		additionalItems.add(additionalItem);
		return additionalItem;
	}

	public CreditNoteFake build() {
		CreditNoteFake creditNoteFake = new CreditNoteFake();
		creditNoteFake.setAdditionalItems(additionalItems.stream()
			.map(AdditionalItemFakeBuilder::build)
			.collect(Collectors.toList()));
		setFields(creditNoteFake);
		return creditNoteFake;
	}

	@Override
	public CreditNoteFakeBuilder returnThis() {
		return this;
	}
}
