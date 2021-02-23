package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdktest.models.CustomTagBuilder;

public class OrderBuilder {

	private String comment;

	private List<CustomTagBuilder<OrderBuilder>> customTags;

	private Integer languageId;

	private OrderUserBuilder user;

	private OrderTotalBuilder totals;

	private List<OrderVoucherBuilder> vouchers;

	private List<OrderItemBuilder> items;
	
	private OrderDeliveryBuilder delivery;

	private OrderInformationBuilder information;

	private OrderPaymentSystemBuilder paymentSystem;

	private List<OrderAdditionalInformationBuilder> additionalInformation;

	private List<OrderCurrencyBuilder> currencies;

	private LocalDateTime date;

	private LocalDateTime deliveryDate;

	private List<OrderDiscountBuilder<OrderBuilder>> discounts;

	private String documentNumber;

	private ExportStatusType exportStatus;

	private Integer id;

	private String pId;

	private LocalDateTime paymentDate;

	private OrderStatusType status;

	private List<OrderStatusBuilder> statuses;

	private int substatusId;

	private boolean paid;

	private boolean reverseChargeVat;
	
	private List<OrderTaxBuilder<OrderBuilder>> taxes;

	public OrderBuilder() {
		comment = "comment DEFAULT";
		customTags = new ArrayList<>();
		languageId = 1;
		user = new OrderUserBuilder(this);
		totals = new OrderTotalBuilder(this);
		vouchers = new ArrayList<>();
		items = new ArrayList<>();
		delivery = new OrderDeliveryBuilder(this);
		information = new OrderInformationBuilder(this);
		paymentSystem = new OrderPaymentSystemBuilder(this);
		additionalInformation = new ArrayList<>();
		currencies = new ArrayList<>();
		date = LocalDateTime.now();
		deliveryDate = LocalDateTime.now();
		discounts = new ArrayList<>();
		documentNumber = "documentNumber DEFAULT";
		exportStatus = ExportStatusType.PENDING_TO_CONFIRM;
		id = 0;
		pId = "pId DEFAULT";
		paymentDate = LocalDateTime.now();
		status = OrderStatusType.INCOMING;
		statuses = new ArrayList<>();
		substatusId = 0;
		paid = false;
		reverseChargeVat = false;
		taxes = new ArrayList<>();
	}

	public OrderBuilder comment(String comment) {
		this.comment = comment;
		return this;
	}

	public CustomTagBuilder<OrderBuilder> customTag() {
		CustomTagBuilder<OrderBuilder> customTag = new CustomTagBuilder<>(this);
		customTags.add(customTag);
		return customTag;
	}

	public OrderBuilder language(Integer languageId) {
		this.languageId = languageId;
		return this;
	}

	public OrderUserBuilder user() {
		return user;
	}

	public OrderTotalBuilder totals() {
		return totals;
	}

	public OrderVoucherBuilder voucher() {
		OrderVoucherBuilder voucher = new OrderVoucherBuilder(this);
		vouchers.add(voucher);
		return voucher;
	}

	public OrderItemBuilder item() {
		OrderItemBuilder item = new OrderItemBuilder(this);
		items.add(item);
		return item;
	}
	
	public OrderDeliveryBuilder delivery() {
		return delivery;
	}	

	public OrderInformationBuilder information() {
		return information;
	}

	public OrderPaymentSystemBuilder paymentSystem() {
		return paymentSystem;
	}

	public OrderAdditionalInformationBuilder additionalInformation() {
		OrderAdditionalInformationBuilder additionalInfo = new OrderAdditionalInformationBuilder(this);
		additionalInformation.add(additionalInfo);
		return additionalInfo;
	}

	public OrderCurrencyBuilder currency() {
		OrderCurrencyBuilder currency = new OrderCurrencyBuilder(this);
		currencies.add(currency);
		return currency;
	}

	public OrderBuilder date(LocalDateTime date) {
		this.date = date;
		return this;
	}

	public OrderBuilder deliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public OrderDiscountBuilder<OrderBuilder> discounts() {
		OrderDiscountBuilder<OrderBuilder> discount = new OrderDiscountBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public OrderBuilder documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}

	public OrderBuilder exportStatus(ExportStatusType exportStatus) {
		this.exportStatus = exportStatus;
		return this;
	}

	public OrderBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public OrderBuilder pId(String pId) {
		this.pId = pId;
		return this;
	}

	public OrderBuilder paymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
		return this;
	}

	public OrderBuilder status(OrderStatusType status) {
		this.status = status;
		return this;
	}

	public OrderStatusBuilder statuses() {
		OrderStatusBuilder statusItem = new OrderStatusBuilder(this);
		statuses.add(statusItem);
		return statusItem;
	}

	public OrderBuilder substatusId(int substatusId) {
		this.substatusId = substatusId;
		return this;
	}

	public OrderBuilder paid(boolean paid) {
		this.paid = paid;
		return this;
	}

	public OrderBuilder reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return this;
	}
	
	public OrderTaxBuilder<OrderBuilder> tax() {
		OrderTaxBuilder<OrderBuilder> tax = new OrderTaxBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	public Order build() {
		OrderFake order = new OrderFake();
		order.setComment(comment);
		order.setCustomTags(customTags.stream().map(CustomTagBuilder::build).collect(Collectors.toList()));
		order.setLanguageId(languageId);
		order.setUser(user.build());
		order.setTotals(totals.build());
		order.setVouchers(vouchers.stream().map(OrderVoucherBuilder::build).collect(Collectors.toList()));
		order.setItems(items.stream().map(OrderItemBuilder::build).collect(Collectors.toList()));
		order.setInformation(information.build());
		order.setPaymentSystem(paymentSystem.build());
		order.setAdditionalInformation(additionalInformation.stream().map(OrderAdditionalInformationBuilder::build).collect(Collectors.toList()));
		order.setCurrencies(currencies.stream().map(OrderCurrencyBuilder::build).collect(Collectors.toList()));
		order.setDate(date);
		order.setDeliveryDate(deliveryDate);
		order.setDiscounts(discounts.stream().map(OrderDiscountBuilder::build).collect(Collectors.toList()));
		order.setDocumentNumber(documentNumber);
		order.setExportStatus(exportStatus);
		order.setId(id);
		order.setPId(pId);
		order.setPaymentDate(paymentDate);
		order.setOrderDelivery(delivery.build());
		order.setStatus(status);
		order.setStatuses(statuses.stream().map(OrderStatusBuilder::build).collect(Collectors.toList()));
		order.setSubstatusId(substatusId);
		order.setPaid(paid);
		order.setReverseChargeVat(reverseChargeVat);
		order.setTaxes(taxes.stream().map(OrderTaxBuilder::build).collect(Collectors.toList()));
		return order;
	}

}