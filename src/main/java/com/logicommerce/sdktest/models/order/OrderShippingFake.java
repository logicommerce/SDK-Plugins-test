package com.logicommerce.sdktest.models.order;

import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.enums.ShippingCalculation;
import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.ElementProperyImpl;
import com.logicommerce.sdk.models.order.OrderDiscount;
import com.logicommerce.sdk.models.order.OrderItemTax;
import com.logicommerce.sdk.models.order.OrderShipping;
import com.logicommerce.sdk.models.order.OrderShippingTracking;

public class OrderShippingFake implements OrderShipping {

	private Integer id;

	private int shippingTypeId;

	private String name;

	private Double price;

	private String shippingTypeName;

	private Integer shippingSectionId;

	private ShippingCalculation shippingCalculation;

	private String shipperPId;

	private String shippingTypePId;

	private List<OrderItemTax> taxes;

	private List<OrderDiscount> discounts;

	private List<ElementProperty> properties;

	private OrderShippingTracking tracking;

	private boolean cashOnDelivery;

	private int shipperId;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public int getShippingTypeId() {
		return shippingTypeId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public String getShippingTypeName() {
		return shippingTypeName;
	}

	@Override
	public Integer getShippingSectionId() {
		return shippingSectionId;
	}

	@Override
	public ShippingCalculation getShippingCalculation() {
		return shippingCalculation;
	}

	@Override
	public String getShipperPId() {
		return shipperPId;
	}

	@Override
	public String getShippingTypePId() {
		return shippingTypePId;
	}

	@Override
	public List<OrderItemTax> getTaxes() {
		return taxes;
	}

	@Override
	public List<OrderDiscount> getDiscounts() {
		return discounts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setShippingTypeId(int shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setShippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
	}

	public void setShippingSectionId(Integer shippingSectionId) {
		this.shippingSectionId = shippingSectionId;
	}

	public void setShippingCalculation(ShippingCalculation shippingCalculation) {
		this.shippingCalculation = shippingCalculation;
	}

	public void setShipperPId(String shipperPId) {
		this.shipperPId = shipperPId;
	}

	public void setShippingTypePId(String shippingTypePId) {
		this.shippingTypePId = shippingTypePId;
	}

	public void setTaxes(List<OrderItemTax> taxes) {
		this.taxes = taxes;
	}

	public void setDiscounts(List<OrderDiscount> discounts) {
		this.discounts = discounts;
	}

	@Override
	public List<ElementProperty> getProperties() {
		return properties;
	}

	@Override
	public void addProperty(ElementProperty property) {
		if (properties == null) {
			properties = new ArrayList<>();
		}
		properties.add(property);		
	}

	@Override
	public OrderShippingTracking getTracking() {
		return tracking;
	}

	@Override
	public void setTracking(OrderShippingTracking tracking) {
		this.tracking = tracking;
	}

	@Override
	public void addProperty(String name, String value) {
		addProperty(new ElementProperyImpl(name, value));
	}

	@Override
	public boolean isCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	@Override
	public int getShipperId() {
		return shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}

}
