package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.builders.order.OrderItemSubstractedStockBuilder;
import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemSubstractedStock;

public class OrderItemSubstractedStockFakeBuilder<T> extends OrderItemSubstractedStockBuilder<T> {

	public OrderItemSubstractedStockFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderItemSubstractedStockFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 1;
		super.previsionType = PrevisionType.AVAILABLE;
		super.productCombinationStockId = 1;
		super.quantity = 0;
	}
	
	public OrderItemSubstractedStock build() {
		OrderItemSubstractedStock substractedStock = super.build();
		OrderItemSubstractedStockFake substractedStockFake = new OrderItemSubstractedStockFake();
		substractedStockFake.setId(super.id);
		substractedStockFake.setPrevisionType(substractedStock.getPrevisionType());
		substractedStockFake.setProductCombinationStockId(substractedStock.getProductCombinationStockId());
		substractedStockFake.setQuantity(substractedStock.getQuantity());

		return substractedStockFake;
	}
}
