package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.logicommerce.sdk.models.order.OrderShippingTrackingPackageActivity;
import com.logicommerce.sdktest.models.ElementPropertyBuilder;

public class OrderShippingTrackingPackageActivityBuilder<T> {

	private T parentBuilder;
	
	private Integer id;
	
	private LocalDateTime dateTime;

	private String description;

	private String status;

	private List<ElementPropertyBuilder<T>> properties;

	public OrderShippingTrackingPackageActivityBuilder() {
		super();
		this.id = 0;
		this.dateTime = LocalDateTime.now();
		this.description = "TEST description";
		this.status = "TEST status";
		this.properties = new ArrayList<>();
	}

	public OrderShippingTrackingPackageActivityBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}
	
	public OrderShippingTrackingPackageActivityBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}
	
	public OrderShippingTrackingPackageActivityBuilder<T> description(String description) {
		this.description = description;
		return this;
	}

	public OrderShippingTrackingPackageActivityBuilder<T> status(String status) {
		this.status = status;
		return this;
	}
	
	public OrderShippingTrackingPackageActivityBuilder<T> dateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}
	
	public OrderShippingTrackingPackageActivity build() {
		OrderShippingTrackingPackageActivityFake trackingPagageActivity = new OrderShippingTrackingPackageActivityFake();		
		trackingPagageActivity.setDateTime(dateTime);
		trackingPagageActivity.setDescription(description);
		trackingPagageActivity.setId(id);
		trackingPagageActivity.setStatus(status);
		trackingPagageActivity.setProperties(properties.stream().map(ElementPropertyBuilder<T>::build).collect(Collectors.toList()));
		
		return trackingPagageActivity;
	}

	public T done() {
		return parentBuilder;
	}
}