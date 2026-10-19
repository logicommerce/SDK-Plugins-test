package com.logicommerce.sdktest.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Proxy;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdk.models.order.list.OrderList;
import com.logicommerce.sdk.models.order.list.OrderListBuilder;
import com.logicommerce.sdk.models.order.list.OrderListParam;
import com.logicommerce.sdk.models.order.list.OrderListParamBuilder;
import com.logicommerce.sdk.resources.PluginResourceException;
import com.logicommerce.sdktest.models.order.OrderFakeBuilder;

class OrderResourceFakeTest {

	private static final int ORDER_ID = 12;
	private static final String DOCUMENT_NUMBER = "ORD-12";

	private final OrderResourceFake orderResource = new OrderResourceFake();

	@Test
	void testFindsOrdersByIdAndDocumentNumber() throws PluginResourceException {
		orderResource.addOrder(order());

		assertEquals(DOCUMENT_NUMBER, orderResource.getOrder(ORDER_ID).getDocumentNumber());
		assertEquals(ORDER_ID, orderResource.getOrder(DOCUMENT_NUMBER).getId());
		assertEquals(1, orderResource.getOrder(ORDER_ID).getItems().size());
		assertNull(orderResource.getOrder(13));
		assertNull(orderResource.getOrder(0));
		assertNull(orderResource.getOrder("ORD-13"));
		assertNull(orderResource.getOrder(" "));
		assertNull(orderResource.getOrder((String) null));
	}

	@Test
	void testEveryReadReturnsANewOrder() throws PluginResourceException {
		Order original = order();
		orderResource.addOrder(original);

		Order first = orderResource.getOrder(ORDER_ID);
		first.addProperty("ucp.checkout_id", "chk_1");
		first.getItems().clear();
		original.addProperty("ucp.tag", "tag");

		Order second = orderResource.getOrder(ORDER_ID);
		assertNotSame(original, first);
		assertNotSame(first, second);
		assertNotSame(first.getItems(), second.getItems());
		assertNull(second.getProperties());
		assertEquals(1, second.getItems().size());
		assertNull(orderResource.getOrder(DOCUMENT_NUMBER).getProperties());
	}

	@Test
	void testOtherImplementationsNeedASupplier() throws PluginResourceException {
		Order proxy = (Order) Proxy.newProxyInstance(Order.class.getClassLoader(), new Class<?>[] { Order.class },
			(instance, method, arguments) -> "getId".equals(method.getName()) ? ORDER_ID : null);

		assertThrows(IllegalArgumentException.class, () -> orderResource.addOrder(proxy));
		assertThrows(IllegalArgumentException.class, () -> orderResource.addOrder(() -> proxy));
		orderResource.addOrder(OrderResourceFakeTest::order);

		assertNotSame(orderResource.getOrder(ORDER_ID), orderResource.getOrder(ORDER_ID));
	}

	@Test
	void testGetOrdersReturnsTheConfiguredListAndRecordsTheParameters() throws PluginResourceException {
		OrderList listed = new OrderListBuilder().id(ORDER_ID).build();
		orderResource.addOrderList(listed);
		OrderListParam param = new OrderListParamBuilder().page(2).build();

		List<OrderList> orders = orderResource.getOrders(param);
		orders.clear();

		assertEquals(List.of(listed), orderResource.getOrders(param));
		assertEquals(List.of(param, param), orderResource.getOrderListParams());
	}

	@Test
	void testFailures() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		orderResource.addOrder(order());
		orderResource.failWith("getOrder", failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> orderResource.getOrder(ORDER_ID)));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> orderResource.getOrder(DOCUMENT_NUMBER)));
		assertEquals(List.of(), orderResource.getOrders(null));
		orderResource.clearFailures();
		orderResource.failWith(failure);
		assertSame(failure, assertThrows(PluginResourceException.class, () -> orderResource.getOrders(null)));
		orderResource.clearFailures();
		assertEquals(ORDER_ID, orderResource.getOrder(ORDER_ID).getId());
	}

	@Test
	void testAnOrderThatCannotBeFoundIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> orderResource.addOrder(new OrderFakeBuilder().id(null).documentNumber(null).build()));
		assertThrows(IllegalArgumentException.class, () -> orderResource.addOrder(new OrderFakeBuilder().id(0).documentNumber(" ").build()));
		assertThrows(IllegalArgumentException.class, () -> orderResource.addOrder(() -> new OrderFakeBuilder().id(null).documentNumber(null).build()));
	}

	@Test
	void testCountedFailuresThenSucceedAndInvalidLookupsDoNotReachTheStore() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		orderResource.addOrder(order());
		orderResource.failWith("getOrder", failure, 1);

		assertNull(orderResource.getOrder(0));
		assertNull(orderResource.getOrder(" "));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> orderResource.getOrder(ORDER_ID)));
		assertEquals(ORDER_ID, orderResource.getOrder(ORDER_ID).getId());
	}

	private static Order order() {
		// @formatter:off
		return new OrderFakeBuilder()
			.id(ORDER_ID)
			.documentNumber(DOCUMENT_NUMBER)
			.item()
				.done()
			.build();
		// @formatter:on
	}
}
