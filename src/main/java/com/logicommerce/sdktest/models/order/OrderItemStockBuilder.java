package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemStock;

public class OrderItemStockBuilder {

	private OrderItemBuilder parentBuilder;

	private String hash;

	private Integer id;

	private LocalDate incomingDate;

	private int offsetDays;

	private PrevisionType previsionType;

	private int priority;

	private int quantity;

	private int reservedQuantity;

	private List<OrderItemSubstractedStockBuilder> substractedStocks;

	private Integer warehouseGroupId;

	private Integer warehouseId;

	public OrderItemStockBuilder() {
		hash = "hash DEFAULT";
		id = 1;
		incomingDate = LocalDate.now();
		previsionType = PrevisionType.AVAILABLE;
		substractedStocks = new ArrayList<>();
		warehouseGroupId = 1;
		warehouseId = 1;
	}

	public OrderItemStockBuilder(OrderItemBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemStockBuilder hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderItemStockBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemStockBuilder incomingDate(LocalDate incomingDate) {
		this.incomingDate = incomingDate;
		return this;
	}

	public OrderItemStockBuilder offsetDays(int offsetDays) {
		this.offsetDays = offsetDays;
		return this;
	}

	public OrderItemStockBuilder previsionType(PrevisionType previsionType) {
		this.previsionType = previsionType;
		return this;
	}

	public OrderItemStockBuilder priority(int priority) {
		this.priority = priority;
		return this;
	}

	public OrderItemStockBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderItemStockBuilder reservedQuantity(int reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
		return this;
	}

	public OrderItemSubstractedStockBuilder substractedStock() {
		OrderItemSubstractedStockBuilder substractedStock = new OrderItemSubstractedStockBuilder(this);
		substractedStocks.add(substractedStock);
		return substractedStock;
	}

	public OrderItemStockBuilder warehouseGroupId(Integer warehouseGroupId) {
		this.warehouseGroupId = warehouseGroupId;
		return this;
	}

	public OrderItemStockBuilder warehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
		return this;
	}


	public OrderItemStock build() {
		OrderItemStockFake stock = new OrderItemStockFake();
		stock.setHash(hash);
		stock.setId(id);
		stock.setIncomingDate(incomingDate);
		stock.setOffsetDays(offsetDays);
		stock.setPrevisionType(previsionType);
		stock.setPriority(priority);
		stock.setQuantity(quantity);
		stock.setReservedQuantity(reservedQuantity);
		stock.setSubstractedStocks(substractedStocks.stream().map(OrderItemSubstractedStockBuilder::build).collect(Collectors.toList()));
		stock.setWarehouseGroupId(warehouseGroupId);
		stock.setWarehouseId(warehouseId);
		return stock;
	}

	public OrderItemBuilder done() {
		return parentBuilder;
	}

}
