package com.logicommerce.sdktest.models.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.enums.CartItemType;
import com.logicommerce.sdk.enums.OrderShipmentStatusType;
import com.logicommerce.sdk.enums.OrderStatusType;
import com.logicommerce.sdk.enums.RMAStatusType;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdk.models.order.OrderItem;
import com.logicommerce.sdk.models.order.OrderPurchaseCurrencyAmounts;
import com.logicommerce.sdk.models.order.OrderShipmentItem;
import com.logicommerce.sdk.models.order.OrderShipmentStatus;
import com.logicommerce.sdk.models.order.OrderStatus;

class OrderFakeBuilderTest {

	private static final String PERMALINK = "https://test.com/storeUrl/orders/1?token=abc";

	@Test
	void testResourceOnlyPropertiesAreNullByDefault() {
		Order order = new OrderFakeBuilder().build();

		assertNull(order.isTaxesIncluded());
		assertNull(order.getPurchaseCurrencyAmounts());
		assertNull(order.getRMAs());
		assertNull(order.getCreditNotes());
		assertNull(order.getPermalinkUrl());
	}

	@Test
	void testResourceOnlyProperties() {
		// @formatter:off
		Order order = new OrderFakeBuilder()
			.status(OrderStatusType.PENDING_APPROVAL)
			.taxesIncluded(true)
			.permalinkUrl(PERMALINK)
			.purchaseCurrencyAmounts()
				.currencyCode("USD")
				.item()
					.hash("row-1")
					.total(1500)
					.discount()
						.discountId(4)
						.amount(500)
						.done()
					.done()
				.totals()
					.total(1500)
					.done()
				.creditNote()
					.creditNoteId(9)
					.total(1500)
					.done()
				.done()
			.rma()
				.id(2)
				.status(RMAStatusType.ACCEPTED)
				.item()
					.hash("row-1")
					.quantity(1)
					.done()
				.done()
			.creditNote()
				.id(9)
				.done()
			.build();
		// @formatter:on

		assertEquals(OrderStatusType.PENDING_APPROVAL, order.getStatus());
		assertTrue(order.isTaxesIncluded());
		assertEquals(PERMALINK, order.getPermalinkUrl());
		OrderPurchaseCurrencyAmounts amounts = order.getPurchaseCurrencyAmounts();
		assertEquals("USD", amounts.getCurrencyCode());
		assertEquals(500, amounts.getItems().get(0).getDiscounts().get(0).getAmount());
		assertEquals(1500, amounts.getTotals().getTotal());
		assertEquals(9, amounts.getCreditNotes().get(0).getCreditNoteId());
		assertEquals(RMAStatusType.ACCEPTED, order.getRMAs().get(0).getStatus());
		assertEquals("row-1", order.getRMAs().get(0).getItems().get(0).getHash());
		assertEquals(9, order.getCreditNotes().get(0).getId());
	}

	@Test
	void testBundleItemsAndShipmentItemHash() {
		// @formatter:off
		OrderItem bundle = new OrderItemFakeBuilder<>()
			.type(CartItemType.BUNDLE)
			.bundleItem()
				.type(CartItemType.BUNDLE_ITEM)
				.hash("bundle-item-1")
				.done()
			.build();
		// @formatter:on

		assertEquals(CartItemType.BUNDLE, bundle.getType());
		assertEquals(CartItemType.BUNDLE_ITEM, bundle.getBundleItems().get(0).getType());
		assertNull(new OrderItemFakeBuilder<>().build().getBundleItems());
		assertEquals("bundle-item-1", new OrderShipmentItemFakeBuilder<>().hash("bundle-item-1").build().getHash());
	}

	@Test
	void testShipmentItemNameAndHashAreNullByDefault() {
		OrderShipmentItem item = new OrderShipmentItemFakeBuilder<>().build();

		assertNull(item.getHash());
		assertNull(item.getName());
		assertEquals("Shirt", new OrderShipmentItemFakeBuilder<>().name("Shirt").build().getName());
	}

	@Test
	void testStatusFromStatus() {
		OrderStatusFakeBuilder<Object> builder = new OrderStatusFakeBuilder<>();
		builder.fromStatus(OrderStatusType.INCOMING).status(OrderStatusType.COMPLETED);

		OrderStatus status = builder.build();

		assertEquals(OrderStatusType.COMPLETED, status.getStatus());
		assertEquals(OrderStatusType.INCOMING, status.getFromStatus());
		assertNull(status.getId());
		assertEquals(5, new OrderStatusFakeBuilder<>().id(5).build().getId());
	}

	@Test
	void testShipmentStatus() {
		OrderShipmentStatusFakeBuilder<Object> builder = new OrderShipmentStatusFakeBuilder<>();
		builder.fromStatus(OrderShipmentStatusType.PROCESSING).id(7).status(OrderShipmentStatusType.SHIPPED).substatusId(3);

		OrderShipmentStatus status = builder.build();

		assertEquals(7, status.getId());
		assertEquals(OrderShipmentStatusType.SHIPPED, status.getStatus());
		assertEquals(OrderShipmentStatusType.PROCESSING, status.getFromStatus());
		assertEquals(3, status.getSubstatusId());
		assertNull(new OrderShipmentStatusFakeBuilder<>().build().getFromStatus());
	}
}
