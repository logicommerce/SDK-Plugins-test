package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.models.order.OrderShipment;

public class OrderShipmentBuilder <T> {

	private T parentBuilder;

	private Integer id;

	private String pId;

	private String status;

	private LocalDate incommingDate;

	private List<OrderShipmentItemBuilder<T>> items;

	private List<OrderShipmentStatusBuilder<T>> statuses;

	private OrderShippingBuilder<T> shipping;
	
	private ExportStatusType exportStatusType;

	public OrderShipmentBuilder() {
		id = 0;
		pId = "pId DEFAULT";
		status = "status DEFAULT";
		incommingDate = LocalDate.now();
		items = new ArrayList<>();
		statuses = new ArrayList<>();
		shipping = new OrderShippingBuilder<T>(this);
		exportStatusType = ExportStatusType.PENDING_TO_SEND;
	}

	public OrderShipmentBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShipmentBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShipmentBuilder<T> pId(String pId) {
		this.pId = pId;
		return this;
	}

	public OrderShipmentBuilder<T> status(String status) {
		this.status = status;
		return this;
	}

	public OrderShipmentBuilder<T> incommingDate(LocalDate incommingDate) {
		this.incommingDate = incommingDate;
		return this;
	}

	public OrderShipmentItemBuilder<T> item() {
		OrderShipmentItemBuilder<T> item = new OrderShipmentItemBuilder<T>(this);
		items.add(item);
		return item;
	}

	public OrderShipmentStatusBuilder<T> status() {
		OrderShipmentStatusBuilder<T> statusItem = new OrderShipmentStatusBuilder<T>(this);
		statuses.add(statusItem);
		return statusItem;
	}
	
	public OrderShipmentBuilder<T> exportStatusType(ExportStatusType exportStatusType) {
		this.exportStatusType = exportStatusType;
		return this;
	}

	public OrderShippingBuilder<T> shipping() {
		return shipping;
	}

	public OrderShipment build() {
		OrderShipmentFake shipment = new OrderShipmentFake();
		shipment.setId(id);
		shipment.setPId(pId);
		shipment.setStatus(status);
		// TODO Add origin and destination address
		shipment.setIncommingDate(incommingDate);
		shipment.setItems(items.stream().map(OrderShipmentItemBuilder::build).collect(Collectors.toList()));
		shipment.setStatuses(statuses.stream().map(OrderShipmentStatusBuilder::build).collect(Collectors.toList()));
		shipment.setShipping(shipping.build());
		shipment.setExportStatusType(exportStatusType);
		return shipment;
	}

	public T done() {
		return parentBuilder;
	}

}
