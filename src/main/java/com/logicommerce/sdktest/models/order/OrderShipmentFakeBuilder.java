package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import com.logicommerce.sdk.builders.ShipmentAddressBuilder;
import com.logicommerce.sdk.builders.order.OrderShipmentBuilder;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.models.order.OrderShipment;

public class OrderShipmentFakeBuilder<T> extends OrderShipmentBuilder<T> {

	public OrderShipmentFakeBuilder() {
		super();
		defaultValues();
	}

	public OrderShipmentFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}
	
	private void defaultValues() {
		super.id = 0;
		super.pId = "pId DEFAULT";
		super.status = "status DEFAULT";
		super.incomingDate = LocalDate.now();
		super.exportStatusType = ExportStatusType.PENDING_TO_SEND;
		super.shipping = new OrderShippingFakeBuilder<>(this);
		super.originAddress = new ShipmentAddressFakeBuilder<>(this);
		super.destinationAddress = new ShipmentAddressFakeBuilder<>(this);
	}

	@Override	
	public ShipmentAddressBuilder<OrderShipmentBuilder<T>> originAddress() {
		ShipmentAddressBuilder<OrderShipmentBuilder<T>> originAddress = new ShipmentAddressFakeBuilder<>(this); 
		this.originAddress = originAddress;
		return originAddress;
	}
	
	@Override
	public ShipmentAddressBuilder<OrderShipmentBuilder<T>> destinationAddress() {
		ShipmentAddressBuilder<OrderShipmentBuilder<T>> destinationAddress = new ShipmentAddressFakeBuilder<>(this); 
		this.destinationAddress = destinationAddress;
		return destinationAddress;
	}

	public OrderShipmentItemFakeBuilder<OrderShipmentBuilder<T>> item() {
		OrderShipmentItemFakeBuilder<OrderShipmentBuilder<T>> item = new OrderShipmentItemFakeBuilder<>(this);
		items.add(item);
		return item;
	}

	public OrderShipmentStatusFakeBuilder<OrderShipmentBuilder<T>> status() {
		OrderShipmentStatusFakeBuilder<OrderShipmentBuilder<T>> statusItem = new OrderShipmentStatusFakeBuilder<>(this);
		statuses.add(statusItem);
		return statusItem;
	}

	@Override
	public OrderShippingFakeBuilder<OrderShipmentBuilder<T>> shipping() {
		OrderShippingFakeBuilder<OrderShipmentBuilder<T>> shipping_ = new OrderShippingFakeBuilder<>(this);
		shipping = shipping_;
		return shipping_;
	}

	@Override
	public OrderShipment build() {
		OrderShipment shipment = super.build();
		OrderShipmentFake shipmentFake = new OrderShipmentFake();
		shipmentFake.setId(super.id);
		shipmentFake.setPId(shipment.getPId());
		shipmentFake.setStatus(shipment.getStatus());
		shipmentFake.setDestinationAddress(shipment.getDestinationAddress());
		shipmentFake.setOriginAddress(shipment.getOriginAddress());
		shipmentFake.setIncomingDate(shipment.getIncomingDate());
		shipmentFake.setItems(shipment.getItems());
		shipmentFake.setStatuses(shipment.getStatuses());
		shipmentFake.setShipping(shipment.getShipping());
		shipmentFake.setExportStatusType(shipment.getExportStatus());

		return shipmentFake;
	}
}