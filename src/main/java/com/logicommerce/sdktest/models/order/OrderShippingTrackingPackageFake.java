package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.logicommerce.sdk.models.order.OrderShippingTrackingPackage;
import com.logicommerce.sdk.models.order.OrderShippingTrackingPackageActivity;

public class OrderShippingTrackingPackageFake implements OrderShippingTrackingPackage {

	private Integer id;

	private Double weight;

	private String weightUnits;

	private LocalDateTime lastUpdate;

	private List<OrderShippingTrackingPackageActivity> activities;
	
	@Override
	public void addActivty(OrderShippingTrackingPackageActivity activity) {
		if (activities == null) {
			activities = new ArrayList<>();
		}
		activities.add(activity);		
	}

	@Override
	public List<OrderShippingTrackingPackageActivity> getActivities() {
		return activities;
	}
	
	public void setActivities(List<OrderShippingTrackingPackageActivity> activities) {
		this.activities = activities;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public Double getWeight() {
		return weight;
	}

	@Override
	public String getWeightUnits() {
		return weightUnits;
	}

	@Override
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
	}
}