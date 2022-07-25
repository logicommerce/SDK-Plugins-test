package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.CustomTag;
import com.logicommerce.sdk.models.ElementProperty;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdk.models.order.OrderAdditionalInformation;
import com.logicommerce.sdk.models.order.OrderCurrency;
import com.logicommerce.sdk.models.order.OrderDelivery;
import com.logicommerce.sdk.models.order.OrderDiscount;
import com.logicommerce.sdk.models.order.OrderInformation;
import com.logicommerce.sdk.models.order.OrderItem;
import com.logicommerce.sdk.models.order.OrderPaymentSystem;
import com.logicommerce.sdk.models.order.OrderStatus;
import com.logicommerce.sdk.models.order.OrderTax;
import com.logicommerce.sdk.models.order.OrderTotal;
import com.logicommerce.sdk.models.order.OrderUser;
import com.logicommerce.sdk.models.order.OrderVoucher;
import com.logicommerce.sdktest.models.ElementPropertyFake;

public class OrderFake implements Order {

	private String comment;
	private List<CustomTag> customTags;
	private OrderUser user;
	private OrderTotal totals;
	private List<OrderVoucher> vouchers;
	private List<OrderItem> items;
	private OrderPaymentSystem paymentSystem;
	private List<OrderAdditionalInformation> additionalInformation;
	private List<OrderCurrency> currencies;
	private LocalDateTime date;
	private LocalDateTime deliveryDate;
	private List<OrderDiscount> discounts;
	private String documentNumber;
	private ExportStatusType exportStatus;
	private Integer id;
	private String pId;
	private LocalDateTime paymentDate;
	private OrderStatusType status;
	private List<OrderStatus> statuses;
	private int substatusId;
	private boolean paid;
	private boolean reverseChargeVat;
	private OrderInformation information;
	private List<OrderTax> taxes;
	private List<ElementProperty> properties;
	private OrderDelivery orderDelivery;
	private Integer languageId;
	private Integer documentId;

	@Override
	public List<OrderAdditionalInformation> getAdditionalInformation() {
		return additionalInformation;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public List<OrderCurrency> getCurrencies() {
		return currencies;
	}

	@Override
	public List<CustomTag> getCustomTags() {
		return customTags;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	@Override
	public List<OrderDiscount> getDiscounts() {
		return discounts;
	}

	@Override
	public String getDocumentNumber() {
		return documentNumber;
	}

	@Override
	public ExportStatusType getExportStatus() {
		return exportStatus;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public List<OrderItem> getItems() {
		return items;
	}

	@Override
	public String getPId() {
		return pId;
	}

	@Override
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	@Override
	public OrderInformation getInformation() {
		return information;
	}

	@Override
	public OrderPaymentSystem getPaymentSystem() {
		return paymentSystem;
	}

	@Override
	public OrderStatusType getStatus() {
		return status;
	}

	@Override
	public List<OrderStatus> getStatuses() {
		return statuses;
	}

	@Override
	public int getSubstatusId() {
		return substatusId;
	}

	@Override
	public List<OrderTax> getTaxes() {
		return taxes;
	}

	@Override
	public OrderTotal getTotals() {
		return totals;
	}

	@Override
	public OrderUser getUser() {
		return user;
	}

	@Override
	public List<OrderVoucher> getVouchers() {
		return vouchers;
	}

	@Override
	public boolean isPaid() {
		return paid;
	}

	@Override
	public boolean isReverseChargeVat() {
		return reverseChargeVat;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCustomTags(List<CustomTag> customTags) {
		this.customTags = customTags;
	}

	public void setUser(OrderUser user) {
		this.user = user;
	}

	public void setTotals(OrderTotal totals) {
		this.totals = totals;
	}

	public void setVouchers(List<OrderVoucher> vouchers) {
		this.vouchers = vouchers;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void setPaymentSystem(OrderPaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public void setAdditionalInformation(List<OrderAdditionalInformation> additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public void setCurrencies(List<OrderCurrency> currencies) {
		this.currencies = currencies;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setDiscounts(List<OrderDiscount> discounts) {
		this.discounts = discounts;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setExportStatus(ExportStatusType exportStatus) {
		this.exportStatus = exportStatus;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setStatus(OrderStatusType status) {
		this.status = status;
	}

	public void setStatuses(List<OrderStatus> statuses) {
		this.statuses = statuses;
	}

	public void setSubstatusId(int substatusId) {
		this.substatusId = substatusId;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void setReverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
	}

	public void setInformation(OrderInformation information) {
		this.information = information;
	}

	public void setTaxes(List<OrderTax> taxes) {
		this.taxes = taxes;
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
	public void addProperty(String name, String value) {
		addProperty(new ElementPropertyFake(name, value));
	}

	@Override
	public OrderDelivery getDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(OrderDelivery orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

	@Override
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public Integer getDocumentId() {
		return documentId;
	}

	public void setProperties(List<ElementProperty> properties) {
		this.properties = properties;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

}
