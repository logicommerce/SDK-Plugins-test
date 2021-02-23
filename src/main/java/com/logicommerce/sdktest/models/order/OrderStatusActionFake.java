package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.SettingOrderSubstatusActionType;
import com.logicommerce.sdk.models.order.OrderStatusAction;

public class OrderStatusActionFake implements OrderStatusAction {

	private Integer id;

	private SettingOrderSubstatusActionType actionType;

	private int actionId;

	private String parameter1;

	private String parameter2;

	private boolean done;

	private String sentText;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public SettingOrderSubstatusActionType getActionType() {
		return actionType;
	}

	@Override
	public int getActionId() {
		return actionId;
	}

	@Override
	public String getParameter1() {
		return parameter1;
	}

	@Override
	public String getParameter2() {
		return parameter2;
	}

	@Override
	public boolean isDone() {
		return done;
	}

	@Override
	public String getSentText() {
		return sentText;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setActionType(SettingOrderSubstatusActionType actionType) {
		this.actionType = actionType;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setSentText(String sentText) {
		this.sentText = sentText;
	}

}
