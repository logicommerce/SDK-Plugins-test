package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.List;
import com.logicommerce.sdk.models.order.OrderBaseStatus;
import com.logicommerce.sdk.models.order.OrderStatusAction;

public class OrderBaseStatusFake<T> implements OrderBaseStatus<T> {

	private List<OrderStatusAction> actions;

	private LocalDateTime currentDateTime;

	private Integer id;

	private T status;

	private int substatusId;

	@Override
	public List<OrderStatusAction> getActions() {
		return actions;
	}

	@Override
	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public T getStatus() {
		return status;
	}

	@Override
	public int getSubstatusId() {
		return substatusId;
	}

	public void setActions(List<OrderStatusAction> actions) {
		this.actions = actions;
	}

	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStatus(T status) {
		this.status = status;
	}

	public void setSubstatusId(int substatusId) {
		this.substatusId = substatusId;
	}

}
