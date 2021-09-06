package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderStatusActionBuilder;
import com.logicommerce.sdk.enums.SettingOrderSubstatusActionType;
import com.logicommerce.sdk.models.order.OrderStatusAction;

public class OrderStatusActionFakeBuilder<T> extends OrderStatusActionBuilder<T> {

	public OrderStatusActionFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderStatusActionFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.actionType = SettingOrderSubstatusActionType.SEND_MAIL;
		super.actionId = 0;
		super.parameter1 = "parameter1 DEFAULT";
		super.parameter2 = "parameter2 DEFAULT";
		super.done = false;
		super.sentText = "sentText DEFAULT";
	}

	@Override
	public OrderStatusAction build() {
		OrderStatusAction action = super.build();
		OrderStatusActionFake actionFake = new OrderStatusActionFake();
		actionFake.setId(super.id);
		actionFake.setActionType(action.getActionType());
		actionFake.setActionId(action.getActionId());
		actionFake.setParameter1(action.getParameter1());
		actionFake.setParameter2(action.getParameter2());
		actionFake.setDone(action.isDone());
		actionFake.setSentText(action.getSentText());
		return actionFake;
	}
}
