package com.logicommerce.sdktest.models.order;

import java.time.LocalDate;
import java.util.List;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.models.order.DocumentProviderPickupPoint;
import com.logicommerce.sdk.models.order.OrderShipment;
import com.logicommerce.sdk.models.order.OrderShipmentItem;
import com.logicommerce.sdk.models.order.OrderShipmentStatus;
import com.logicommerce.sdk.models.order.OrderShipping;
import com.logicommerce.sdk.models.order.ShipmentAddress;

public class OrderShipmentFake implements OrderShipment {

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
	private OrderShipping shipping;
	private ShipmentAddress originAddress;
	private ShipmentAddress destinationAddress;
	private ShipmentAddress destinationUserAddress;
	private List<OrderShipmentItem> items;
	private List<OrderShipmentStatus> statuses;
	private DocumentProviderPickupPoint providerPickupPoint;
	
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
	public LocalDate getIncomingDate() {
		return incomingDate;
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

	public void setIncomingDate(LocalDate incomingDate) {
		this.incomingDate = incomingDate;
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public ExportStatusType getExportStatusType() {
		return exportStatusType;
	}

	public void setOriginAddress(ShipmentAddress originAddress) {
		this.originAddress = originAddress;
	}

	public void setDestinationAddress(ShipmentAddress destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	@Override
	public String getTrackingNumber() {
		return trackingNumber;
	}

	@Override
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Override
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public Integer getSubstatus() {
		return substatus;
	}

	public void setSubstatus(Integer substatus) {
		this.substatus = substatus;
	}

	@Override
	public String getTrackingUrl() {
		return trackingUrl;
	}

	@Override
	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	@Override
	public DocumentProviderPickupPoint getProviderPickupPoint() {
		return providerPickupPoint;
	}

	@Override
	public void setProviderPickupPoint(DocumentProviderPickupPoint providerPickupPoint) {
		this.providerPickupPoint = providerPickupPoint;		
	}

	@Override
	public ShipmentAddress getDestinationUserAddress() {
		return destinationUserAddress;
	}
	
	public void setDestinationUserAddress(ShipmentAddress destinationUserAddress) {
		this.destinationUserAddress = destinationUserAddress;
	}

}
