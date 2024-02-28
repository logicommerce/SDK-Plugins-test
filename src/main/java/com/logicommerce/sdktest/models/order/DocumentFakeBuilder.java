package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdktest.models.CustomTagFakeBuilder;
import com.logicommerce.sdktest.models.HeadquarterFakeBuilder;

public abstract class DocumentFakeBuilder<T extends DocumentFakeBuilder<T>> {

	private String comment;

	private HeadquarterFakeBuilder<T> headquarter;

	private List<CustomTagFakeBuilder<T>> customTags;

	private Integer languageId;

	private OrderUserFakeBuilder<T> user;

	private OrderTotalFakeBuilder<T> totals;

	private List<OrderVoucherFakeBuilder<T>> vouchers;

	private List<OrderItemFakeBuilder<T>> items;

	private OrderDeliveryFakeBuilder<T> delivery;

	private OrderInformationFakeBuilder<T> information;

	private OrderPaymentSystemFakeBuilder<T> paymentSystem;

	private List<OrderAdditionalInformationFakeBuilder<T>> additionalInformation;

	private List<OrderCurrencyFakeBuilder<T>> currencies;

	private LocalDateTime date;

	private LocalDateTime deliveryDate;

	private List<OrderDiscountFakeBuilder<T>> discounts;

	private String documentNumber;

	private ExportStatusType exportStatus;

	private Integer id;

	private String pId;

	private LocalDateTime paymentDate;

	private List<OrderStatusFakeBuilder<T>> statuses;

	private boolean paid;

	private boolean reverseChargeVat;

	private List<OrderTaxFakeBuilder<T>> taxes;

	public DocumentFakeBuilder() {
		comment = "comment DEFAULT";
		languageId = 1;
		headquarter = new HeadquarterFakeBuilder<>(returnThis());
		user = new OrderUserFakeBuilder<>(returnThis());
		totals = new OrderTotalFakeBuilder<>(returnThis());
		delivery = new OrderDeliveryFakeBuilder<>(returnThis());
		information = new OrderInformationFakeBuilder<>(returnThis());
		paymentSystem = new OrderPaymentSystemFakeBuilder<>(returnThis());
		date = LocalDateTime.now();
		deliveryDate = LocalDateTime.now();
		documentNumber = "documentNumber DEFAULT";
		exportStatus = ExportStatusType.PENDING_TO_CONFIRM;
		id = 0;
		pId = "pId DEFAULT";
		paymentDate = LocalDateTime.now();
		paid = false;
		reverseChargeVat = false;
		customTags = new ArrayList<>();
		vouchers = new ArrayList<>();
		items = new ArrayList<>();
		additionalInformation = new ArrayList<>();
		currencies = new ArrayList<>();
		discounts = new ArrayList<>();
		statuses = new ArrayList<>();
		taxes = new ArrayList<>();
	}

	public HeadquarterFakeBuilder<T> headquarter() {
		return headquarter;
	}

	public T comment(String comment) {
		this.comment = comment;
		return returnThis();
	}

	public CustomTagFakeBuilder<T> customTag() {
		CustomTagFakeBuilder<T> customTag = new CustomTagFakeBuilder<>(returnThis());
		customTags.add(customTag);
		return customTag;
	}

	public T language(Integer languageId) {
		this.languageId = languageId;
		return returnThis();
	}

	public OrderUserFakeBuilder<T> user() {
		return user;
	}

	public OrderTotalFakeBuilder<T> totals() {
		return totals;
	}

	public OrderVoucherFakeBuilder<T> voucher() {
		OrderVoucherFakeBuilder<T> voucher = new OrderVoucherFakeBuilder<>(returnThis());
		vouchers.add(voucher);
		return voucher;
	}

	public OrderItemFakeBuilder<T> item() {
		OrderItemFakeBuilder<T> item = new OrderItemFakeBuilder<>(returnThis());
		items.add(item);
		return item;
	}

	public OrderDeliveryFakeBuilder<T> delivery() {
		return delivery;
	}

	public OrderInformationFakeBuilder<T> information() {
		return information;
	}

	public OrderPaymentSystemFakeBuilder<T> paymentSystem() {
		return paymentSystem;
	}

	public OrderAdditionalInformationFakeBuilder<T> additionalInformation() {
		OrderAdditionalInformationFakeBuilder<T> additionalInfo =
			new OrderAdditionalInformationFakeBuilder<>(returnThis());
		additionalInformation.add(additionalInfo);
		return additionalInfo;
	}

	public OrderCurrencyFakeBuilder<T> currencies() {
		OrderCurrencyFakeBuilder<T> currency = new OrderCurrencyFakeBuilder<>(returnThis());
		currencies.add(currency);
		return currency;
	}

	public T date(LocalDateTime date) {
		this.date = date;
		return returnThis();
	}

	public T deliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
		return returnThis();
	}

	public OrderDiscountFakeBuilder<T> discounts() {
		OrderDiscountFakeBuilder<T> discount = new OrderDiscountFakeBuilder<>(returnThis());
		discounts.add(discount);
		return discount;
	}

	public T documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return returnThis();
	}

	public T exportStatus(ExportStatusType exportStatus) {
		this.exportStatus = exportStatus;
		return returnThis();
	}

	public T id(Integer id) {
		this.id = id;
		return returnThis();
	}

	public T pId(String pId) {
		this.pId = pId;
		return returnThis();
	}

	public T paymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
		return returnThis();
	}

	public OrderStatusFakeBuilder<T> statuses() {
		OrderStatusFakeBuilder<T> statusItem = new OrderStatusFakeBuilder<>(returnThis());
		statuses.add(statusItem);
		return statusItem;
	}

	public T paid(boolean paid) {
		this.paid = paid;
		return returnThis();
	}

	public T reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return returnThis();
	}

	public OrderTaxFakeBuilder<T> tax() {
		OrderTaxFakeBuilder<T> tax = new OrderTaxFakeBuilder<>(returnThis());
		taxes.add(tax);
		return tax;
	}

	public void setFields(DocumentFake document) {
		document.setHeadquarter(headquarter.build());
		document.setComment(comment);
		document.setCustomTags(customTags.stream().map(CustomTagFakeBuilder::build).collect(Collectors.toList()));
		document.setLanguageId(languageId);
		document.setUser(user.build());
		document.setTotals(totals.build());
		document.setVouchers(vouchers.stream().map(OrderVoucherFakeBuilder::build).collect(Collectors.toList()));
		document.setItems(items.stream().map(OrderItemFakeBuilder::build).collect(Collectors.toList()));
		document.setInformation(information.build());
		document.setPaymentSystem(paymentSystem.build());
		document.setAdditionalInformation(additionalInformation.stream()
			.map(OrderAdditionalInformationFakeBuilder::build)
			.collect(Collectors.toList()));
		document.setCurrencies(currencies.stream().map(OrderCurrencyFakeBuilder::build).collect(Collectors.toList()));
		document.setDate((date == null) ? LocalDateTime.now() : date);
		document.setDeliveryDate(deliveryDate);
		document.setDiscounts(discounts.stream().map(OrderDiscountFakeBuilder::build).collect(Collectors.toList()));
		document.setDocumentNumber(documentNumber);
		document.setExportStatus(exportStatus);
		document.setId(id);
		document.setPId(pId);
		document.setPaymentDate(paymentDate);
		document.setOrderDelivery(delivery.build());
		document.setStatuses(statuses.stream().map(OrderStatusFakeBuilder::build).collect(Collectors.toList()));
		document.setPaid(paid);
		document.setReverseChargeVat(reverseChargeVat);
		document.setTaxes(taxes.stream().map(OrderTaxFakeBuilder::build).collect(Collectors.toList()));
	}

	/**
	 * <p>
	 * returnThis.
	 * </p>
	 *
	 * @return a T object
	 */
	public abstract T returnThis();

}
