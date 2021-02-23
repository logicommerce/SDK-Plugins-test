package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.SettingOrderSubstatusActionType;
import com.logicommerce.sdk.models.order.OrderStatusAction;

public class OrderStatusActionBuilder<T> {

	private T parentBuilder;

	private Integer id;

	private SettingOrderSubstatusActionType actionType;

	private int actionId;

	private String parameter1;

	private String parameter2;

	private boolean done;

	private String sentText;

	public OrderStatusActionBuilder() {
		id = 0;
		actionType = SettingOrderSubstatusActionType.SEND_MAIL;
		actionId = 0;
		parameter1 = "parameter1 DEFAULT";
		parameter2 = "parameter2 DEFAULT";
		done = false;
		sentText = "sentText DEFAULT";
	}

	public OrderStatusActionBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderStatusActionBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderStatusActionBuilder<T> actionType(SettingOrderSubstatusActionType actionType) {
		this.actionType = actionType;
		return this;
	}

	public OrderStatusActionBuilder<T> actionId(int actionId) {
		this.actionId = actionId;
		return this;
	}

	public OrderStatusActionBuilder<T> parameter1(String parameter1) {
		this.parameter1 = parameter1;
		return this;
	}

	public OrderStatusActionBuilder<T> parameter2(String parameter2) {
		this.parameter2 = parameter2;
		return this;
	}

	public OrderStatusActionBuilder<T> done(boolean done) {
		this.done = done;
		return this;
	}

	public OrderStatusActionBuilder<T> sentText(String sentText) {
		this.sentText = sentText;
		return this;
	}

	public OrderStatusAction build() {
		OrderStatusActionFake action = new OrderStatusActionFake();
		action.setId(id);
		action.setActionType(actionType);
		action.setActionId(actionId);
		action.setParameter1(parameter1);
		action.setParameter2(parameter2);
		action.setDone(done);
		action.setSentText(sentText);
		return action;
	}

	public T done() {
		return parentBuilder;
	}
}
