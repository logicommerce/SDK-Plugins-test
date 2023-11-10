package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.builders.ShipmentAddressBuilder;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.models.order.OrderShipment;

public class OrderShipmentFakeBuilder<T> {

	private T parentBuilder;
	private Integer id;
	private String pId;
	private String status;
	private LocalDate incomingDate;
	private ExportStatusType exportStatusType;
	private String hash;
	private String documentNumber;
	private Integer substatus;
	private String trackingNumber;
	private String trackingUrl;
	private OrderShippingFakeBuilder<OrderShipmentFakeBuilder<T>> shipping;
	private ShipmentAddressFakeBuilder<OrderShipmentFakeBuilder<T>> originAddress;
	private ShipmentAddressFakeBuilder<OrderShipmentFakeBuilder<T>> destinationAddress;
	private List<OrderShipmentItemFakeBuilder<OrderShipmentFakeBuilder<T>>> items;
	private List<OrderShipmentStatusFakeBuilder<OrderShipmentFakeBuilder<T>>> statusList;


	public OrderShipmentFakeBuilder() {
		id = 0;
		pId = "pId DEFAULT";
		status = "status DEFAULT";
		incomingDate = LocalDate.now();
		exportStatusType = ExportStatusType.PENDING_TO_SEND;
		hash = "hash DEFAULT";
		documentNumber = "documentNumber DEFAULT";
		substatus = 0;
		trackingNumber = "trackingNumber DEFAULT";
		trackingUrl = "trackingUrl DEFAULT";
		shipping = new OrderShippingFakeBuilder<>(this);
		originAddress = new ShipmentAddressFakeBuilder<>(this);
		destinationAddress = new ShipmentAddressFakeBuilder<>(this);
		items = new ArrayList<>();
		statusList = new ArrayList<>();
	}

	public OrderShipmentFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public OrderShipmentFakeBuilder<T> id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderShipmentFakeBuilder<T> pId(String pId) {
		this.pId = pId;
		return this;
	}

	public OrderShipmentFakeBuilder<T> statusName(String status) {
		this.status = status;
		return this;
	}

	public OrderShipmentFakeBuilder<T> incomingDate(LocalDate incomingDate) {
		this.incomingDate = incomingDate;
		return this;
	}

	public OrderShipmentFakeBuilder<T> exportStatusType(ExportStatusType exportStatusType) {
		this.exportStatusType = exportStatusType;
		return this;
	}

	public OrderShipmentFakeBuilder<T> hash(String hash) {
		this.hash = hash;
		return this;
	}

	public OrderShipmentFakeBuilder<T> documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}

	public OrderShipmentFakeBuilder<T> substatus(Integer substatus) {
		this.substatus = substatus;
		return this;
	}

	public OrderShipmentFakeBuilder<T> trackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public OrderShipmentFakeBuilder<T> trackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
		return this;
	}

	public OrderShippingFakeBuilder<OrderShipmentFakeBuilder<T>> shipping() {
		return shipping;
	}

	public ShipmentAddressBuilder<OrderShipmentFakeBuilder<T>> originAddress() {
		return originAddress;
	}

	public ShipmentAddressBuilder<OrderShipmentFakeBuilder<T>> destinationAddress() {
		return destinationAddress;
	}

	public OrderShipmentItemFakeBuilder<OrderShipmentFakeBuilder<T>> item() {
		var item = new OrderShipmentItemFakeBuilder<OrderShipmentFakeBuilder<T>>(this);
		items.add(item);
		return item;
	}

	public OrderShipmentStatusFakeBuilder<OrderShipmentFakeBuilder<T>> status() {
		var statusItem = new OrderShipmentStatusFakeBuilder<OrderShipmentFakeBuilder<T>>(this);
		statusList.add(statusItem);
		return statusItem;
	}

	public OrderShipment build() {
		OrderShipmentFake shipmentFake = new OrderShipmentFake();
		shipmentFake.setId(id);
		shipmentFake.setPId(pId);
		shipmentFake.setStatus(status);
		shipmentFake.setIncomingDate(incomingDate);
		shipmentFake.setExportStatusType(exportStatusType);
		shipmentFake.setHash(hash);
		shipmentFake.setDocumentNumber(documentNumber);
		shipmentFake.setSubstatus(substatus);
		shipmentFake.setTrackingNumber(trackingNumber);
		shipmentFake.setTrackingUrl(trackingUrl);
		shipmentFake.setShipping(shipping.build());
		shipmentFake.setOriginAddress(originAddress.build());
		shipmentFake.setDestinationAddress(destinationAddress.build());
		shipmentFake.setItems(items.stream()
			.map(OrderShipmentItemFakeBuilder::build)
			.collect(Collectors.toList()));
		shipmentFake.setStatuses(statusList.stream()
			.map(OrderShipmentStatusFakeBuilder::build)
			.collect(Collectors.toList()));
		return shipmentFake;
	}

	public T done() {
		return parentBuilder;
	}
}
