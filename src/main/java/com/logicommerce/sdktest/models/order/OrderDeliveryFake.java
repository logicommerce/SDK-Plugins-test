package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.DeliveryType;
import com.logicommerce.sdk.enums.DocumentPickingDeliveryMode;
import com.logicommerce.sdk.models.order.GeographicalZone;
import com.logicommerce.sdk.models.order.OrderDelivery;
import com.logicommerce.sdk.models.order.OrderDeliveryPhysicalLocation;
import com.logicommerce.sdk.models.order.OrderShipment;
import com.logicommerce.sdk.models.order.ProviderPickupPointPickingDocumentDelivery;

public class OrderDeliveryFake implements OrderDelivery {

	private DeliveryType type;

	private OrderDeliveryPhysicalLocation physicalLocation;

	private List<OrderShipment> shipments;

	private GeographicalZone geographicalZone;
	
	private DocumentPickingDeliveryMode mode;
	
	private ProviderPickupPointPickingDocumentDelivery providerPickupPointPickingDocumentDelivery;

	@Override
	public GeographicalZone getGeographicalZone() {
		return geographicalZone;
	}

	@Override
	public OrderDeliveryPhysicalLocation getPhysicalLocation() {
		return physicalLocation;
	}

	@Override
	public List<OrderShipment> getShipments() {
		return shipments;
	}

	@Override
	public DeliveryType getType() {
		return type;
	}

	public void setType(DeliveryType type) {
		this.type = type;
	}

	public void setPhysicalLocation(OrderDeliveryPhysicalLocation physicalLocation) {
		this.physicalLocation = physicalLocation;
	}

	public void setShipments(List<OrderShipment> shipments) {
		this.shipments = shipments;
	}

	public void setGeographicalZone(GeographicalZone geographicalZone) {
		this.geographicalZone = geographicalZone;
	}

	@Override
	public DocumentPickingDeliveryMode getMode() {
		return mode;
	}

	@Override
	public ProviderPickupPointPickingDocumentDelivery getProviderPickupPointPickingDocumentDelivery() {
		return providerPickupPointPickingDocumentDelivery;
	}

	public void setMode(DocumentPickingDeliveryMode mode) {
		this.mode = mode;
	}

	public void setProviderPickupPointPickingDocumentDelivery(ProviderPickupPointPickingDocumentDelivery providerPickupPointPickingDocumentDelivery) {
		this.providerPickupPointPickingDocumentDelivery = providerPickupPointPickingDocumentDelivery;
	}
}
