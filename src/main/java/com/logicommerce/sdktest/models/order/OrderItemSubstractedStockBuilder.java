package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemSubstractedStock;

public class OrderItemSubstractedStockBuilder {

	private OrderItemStockBuilder parentBuilder;

	private Integer id;

	private PrevisionType previsionType;

	private Integer productCombinationStockId;

	private int quantity;

	public OrderItemSubstractedStockBuilder() {
		id = 1;
		previsionType = PrevisionType.AVAILABLE;
		productCombinationStockId = 1;
	}

	public OrderItemSubstractedStockBuilder(OrderItemStockBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderItemSubstractedStockBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderItemSubstractedStockBuilder previsionType(PrevisionType previsionType) {
		this.previsionType = previsionType;
		return this;
	}

	public OrderItemSubstractedStockBuilder productCombinationStockId(Integer productCombinationStockId) {
		this.productCombinationStockId = productCombinationStockId;
		return this;
	}

	public OrderItemSubstractedStockBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}


	public OrderItemSubstractedStock build() {
		OrderItemSubstractedStockFake substractedStock = new OrderItemSubstractedStockFake();
		substractedStock.setId(id);
		substractedStock.setPrevisionType(previsionType);
		substractedStock.setProductCombinationStockId(productCombinationStockId);
		substractedStock.setQuantity(quantity);
		return substractedStock;
	}

	public OrderItemStockBuilder done() {
		return parentBuilder;
	}

}
