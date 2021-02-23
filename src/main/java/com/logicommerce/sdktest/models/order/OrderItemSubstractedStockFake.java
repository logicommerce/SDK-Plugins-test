package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.enums.PrevisionType;
import com.logicommerce.sdk.models.order.OrderItemSubstractedStock;

public class OrderItemSubstractedStockFake implements OrderItemSubstractedStock {

	private Integer id;

	private PrevisionType previsionType;

	private Integer productCombinationStockId;

	private int quantity;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public PrevisionType getPrevisionType() {
		return previsionType;
	}

	@Override
	public Integer getProductCombinationStockId() {
		return productCombinationStockId;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrevisionType(PrevisionType previsionType) {
		this.previsionType = previsionType;
	}

	public void setProductCombinationStockId(Integer productCombinationStockId) {
		this.productCombinationStockId = productCombinationStockId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
