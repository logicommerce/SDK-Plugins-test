package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import com.logicommerce.sdk.builders.order.OrderItemStockBuilder;
import com.logicommerce.sdk.builders.order.OrderItemSubstractedStockBuilder;
import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemStock;

public class OrderItemStockFakeBuilder<T> extends OrderItemStockBuilder<T> {
	
	public OrderItemStockFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemStockFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 1;
		super.hash = "hash DEFAULT";
		super.incomingDate = LocalDate.now();
		super.previsionType = PrevisionType.AVAILABLE;
		super.warehouseGroupId = 1;
		super.warehouseId = 1;
	}

	@Override
	public OrderItemSubstractedStockBuilder<OrderItemStockBuilder<T>> substractedStock() {
		OrderItemSubstractedStockBuilder<OrderItemStockBuilder<T>> substractedStock = new OrderItemSubstractedStockFakeBuilder<>(this);
		substractedStocks.add(substractedStock);
		return substractedStock;
	}

	public OrderItemStock build() {
		OrderItemStock stockSdk = super.build();
		OrderItemStockFake stockFake = new OrderItemStockFake();
		stockFake.setHash(stockSdk.getHash());
		stockFake.setId(super.id);
		stockFake.setIncomingDate(stockSdk.getIncomingDate());
		stockFake.setOffsetDays(stockSdk.getOffsetDays());
		stockFake.setPrevisionType(stockSdk.getPrevisionType());
		stockFake.setPriority(stockSdk.getPriority());
		stockFake.setQuantity(stockSdk.getQuantity());
		stockFake.setReservedQuantity(stockSdk.getReservedQuantity());
		stockFake.setSubstractedStocks(stockSdk.getSubstractedStocks());
		stockFake.setWarehouseGroupId(stockSdk.getWarehouseGroupId());
		stockFake.setWarehouseId(stockSdk.getWarehouseId());
		return stockFake;
	}
}