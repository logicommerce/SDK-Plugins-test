package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.List;
import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemStock;
import com.logicommerce.sdk.models.order.OrderItemSubstractedStock;

public class OrderItemStockFake implements OrderItemStock {

	private String hash;

	private Integer id;

	private LocalDate incomingDate;

	private int offsetDays;

	private PrevisionType previsionType;

	private int priority;

	private int quantity;

	private int reservedQuantity;

	private List<OrderItemSubstractedStock> substractedStocks;

	private Integer warehouseGroupId;

	private Integer warehouseId;

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public LocalDate getIncomingDate() {
		return incomingDate;
	}

	@Override
	public int getOffsetDays() {
		return offsetDays;
	}

	@Override
	public PrevisionType getPrevisionType() {
		return previsionType;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public int getReservedQuantity() {
		return reservedQuantity;
	}

	@Override
	public List<OrderItemSubstractedStock> getSubstractedStocks() {
		return substractedStocks;
	}

	@Override
	public Integer getWarehouseGroupId() {
		return warehouseGroupId;
	}

	@Override
	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIncomingDate(LocalDate incomingDate) {
		this.incomingDate = incomingDate;
	}

	public void setOffsetDays(int offsetDays) {
		this.offsetDays = offsetDays;
	}

	public void setPrevisionType(PrevisionType previsionType) {
		this.previsionType = previsionType;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setReservedQuantity(int reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public void setSubstractedStocks(List<OrderItemSubstractedStock> substractedStocks) {
		this.substractedStocks = substractedStocks;
	}

	public void setWarehouseGroupId(Integer warehouseGroupId) {
		this.warehouseGroupId = warehouseGroupId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

}
