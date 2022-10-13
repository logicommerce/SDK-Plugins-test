package com.logicommerce.sdktest.models.order;

import java.time.LocalDateTime;
import com.logicommerce.sdk.builders.order.OrderSdkBuilder;
import com.logicommerce.sdk.enums.ExportStatusType;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdktest.models.CustomTagFakeBuilder;

public class OrderFakeBuilder extends OrderSdkBuilder {

	public OrderFakeBuilder() {
		defaultValues();
	}

	private void defaultValues() {
		super.comment = "comment DEFAULT";
		super.languageId = 1;
		super.user = new OrderUserFakeBuilder<>(this);
		super.totals = new OrderTotalFakeBuilder<>(this);
		super.delivery = new OrderDeliveryFakeBuilder<>(this);
		super.information = new OrderInformationFakeBuilder<>(this);
		super.paymentSystem = new OrderPaymentSystemFakeBuilder<>(this);
		super.date = LocalDateTime.now();
		super.deliveryDate = LocalDateTime.now();
		super.documentNumber = "documentNumber DEFAULT";
		super.exportStatus = ExportStatusType.PENDING_TO_CONFIRM;
		super.id = 0;
		super.pId = "pId DEFAULT";
		super.paymentDate = LocalDateTime.now();
		super.status = OrderStatusType.INCOMING;
		super.substatusId = 0;
		super.paid = false;
		super.reverseChargeVat = false;
	}

	@Override
	public CustomTagFakeBuilder<OrderSdkBuilder> customTag() {
		CustomTagFakeBuilder<OrderSdkBuilder> customTag = new CustomTagFakeBuilder<>(this);
		customTags.add(customTag);
		return customTag;
	}

	@Override
	public OrderVoucherFakeBuilder<OrderSdkBuilder> voucher() {
		OrderVoucherFakeBuilder<OrderSdkBuilder> voucher = new OrderVoucherFakeBuilder<>(this);
		vouchers.add(voucher);
		return voucher;
	}

	@Override
	public OrderItemFakeBuilder<OrderSdkBuilder> item() {
		OrderItemFakeBuilder<OrderSdkBuilder> item = new OrderItemFakeBuilder<>(this);
		items.add(item);
		return item;
	}

	@Override
	public OrderAdditionalInformationFakeBuilder<OrderSdkBuilder> additionalInformation() {
		OrderAdditionalInformationFakeBuilder<OrderSdkBuilder> additionalInfo = new OrderAdditionalInformationFakeBuilder<>(this);
		additionalInformation.add(additionalInfo);
		return additionalInfo;
	}

	@Override
	public OrderCurrencyFakeBuilder<OrderSdkBuilder> currencies() {
		OrderCurrencyFakeBuilder<OrderSdkBuilder> currency = new OrderCurrencyFakeBuilder<>(this);
		currencies.add(currency);
		return currency;
	}

	@Override
	public OrderDiscountFakeBuilder<OrderSdkBuilder> discounts() {
		OrderDiscountFakeBuilder<OrderSdkBuilder> discount = new OrderDiscountFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	@Override
	public OrderStatusFakeBuilder<OrderSdkBuilder> statuses() {
		OrderStatusFakeBuilder<OrderSdkBuilder> statusItem = new OrderStatusFakeBuilder<>(this);
		statuses.add(statusItem);
		return statusItem;
	}

	@Override
	public OrderTaxFakeBuilder<OrderSdkBuilder> tax() {
		OrderTaxFakeBuilder<OrderSdkBuilder> tax = new OrderTaxFakeBuilder<>(this);
		taxes.add(tax);
		return tax;
	}

	@Override
	public Order build() {
		Order order = super.build();
		OrderFake orderFake = new OrderFake();
		orderFake.setComment(order.getComment());
		orderFake.setCustomTags(order.getCustomTags());
		orderFake.setLanguageId(order.getLanguageId());
		orderFake.setUser(order.getUser());
		orderFake.setTotals(order.getTotals());
		orderFake.setVouchers(order.getVouchers());
		orderFake.setItems(order.getItems());
		orderFake.setInformation(order.getInformation());
		orderFake.setPaymentSystem(order.getPaymentSystem());
		orderFake.setAdditionalInformation(order.getAdditionalInformation());
		orderFake.setCurrencies(order.getCurrencies());
		orderFake.setDate(order.getDate());
		orderFake.setDeliveryDate(order.getDeliveryDate());
		orderFake.setDiscounts(order.getDiscounts());
		orderFake.setDocumentNumber(order.getDocumentNumber());
		orderFake.setExportStatus(order.getExportStatus());
		orderFake.setId(super.id);
		orderFake.setPId(order.getPId());
		orderFake.setPaymentDate(order.getPaymentDate());
		orderFake.setOrderDelivery(order.getDelivery());
		orderFake.setStatus(order.getStatus());
		orderFake.setStatuses(order.getStatuses());
		orderFake.setSubstatusId(order.getSubstatusId());
		orderFake.setPaid(order.isPaid());
		orderFake.setReverseChargeVat(order.isReverseChargeVat());
		orderFake.setTaxes(order.getTaxes());
		return orderFake;
	}
}