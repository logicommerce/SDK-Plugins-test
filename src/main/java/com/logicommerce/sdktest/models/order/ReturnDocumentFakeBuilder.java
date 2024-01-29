package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReturnDocumentFakeBuilder extends DocumentFakeBuilder<ReturnDocumentFakeBuilder> {

	private List<AdditionalItemFakeBuilder> additionalItems;

	public ReturnDocumentFakeBuilder() {
		super();
		additionalItems = new ArrayList<>();
	}

	public AdditionalItemFakeBuilder additionalItem() {
		AdditionalItemFakeBuilder additionalItem = new AdditionalItemFakeBuilder(this);
		additionalItems.add(additionalItem);
		return additionalItem;
	}

	public ReturnDocumentFake build() {
		ReturnDocumentFake creditNoteFake = new ReturnDocumentFake();
		creditNoteFake.setAdditionalItems(additionalItems.stream()
			.map(AdditionalItemFakeBuilder::build)
			.collect(Collectors.toList()));
		setFields(creditNoteFake);
		return creditNoteFake;
	}

	@Override
	public ReturnDocumentFakeBuilder returnThis() {
		return this;
	}
}
