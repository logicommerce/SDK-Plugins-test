package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.List;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.models.order.OrderShipment;
import com.logicommerce.sdk.models.order.OrderShipmentItem;
import com.logicommerce.sdk.models.order.OrderShipmentStatus;
import com.logicommerce.sdk.models.order.OrderShipping;
import com.logicommerce.sdk.models.order.ShipmentAddress;

public class OrderShipmentFake implements OrderShipment {

	private Integer id;
	private String pId;
	private String status;
	private LocalDate incommingDate;
	private List<OrderShipmentItem> items;
	private List<OrderShipmentStatus> statuses;
	private OrderShipping shipping;
	private ExportStatusType exportStatusType;
	private String hash;
	private ShipmentAddress originAddress;
	private ShipmentAddress destinationAddress;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getPId() {
		return pId;
	}

	@Override
	public ShipmentAddress getOriginAddress() {
		return originAddress;
	}

	@Override
	public ShipmentAddress getDestinationAddress() {
		return destinationAddress;
	}

	@Override
	public LocalDate getIncommingDate() {
		return incommingDate;
	}

	@Override
	public List<OrderShipmentItem> getItems() {
		return items;
	}

	@Override
	public List<OrderShipmentStatus> getStatuses() {
		return statuses;
	}

	@Override
	public OrderShipping getShipping() {
		return shipping;
	}

	@Override
	public ExportStatusType getExportStatus() {
		return exportStatusType;
	}

	@Override
	public String getHash() {
		return hash;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public void setIncommingDate(LocalDate incommingDate) {
		this.incommingDate = incommingDate;
	}

	public void setItems(List<OrderShipmentItem> items) {
		this.items = items;
	}

	public void setStatuses(List<OrderShipmentStatus> statuses) {
		this.statuses = statuses;
	}

	public void setShipping(OrderShipping shipping) {
		this.shipping = shipping;
	}

	public void setExportStatusType(ExportStatusType exportStatusType) {
		this.exportStatusType = exportStatusType;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

}
