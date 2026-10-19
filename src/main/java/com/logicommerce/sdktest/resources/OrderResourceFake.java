package com.logicommerce.sdktest.resources;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import com.logicommerce.sdk.models.order.Order;
import com.logicommerce.sdk.models.order.list.OrderList;
import com.logicommerce.sdk.models.order.list.OrderListParam;
import com.logicommerce.sdk.resources.OrderResource;
import com.logicommerce.sdk.resources.PluginResourceException;

/**
 * <p>In-memory {@link OrderResource} for plugin tests.</p>
 *
 * <p>As in production, {@link #getOrder(int)} and {@link #getOrder(String)} return a new {@link Order} on every call,
 * so adding a property to a returned order changes nothing the next call returns. {@link #addOrder(Order)} takes an
 * order built with the sdktest fakes (such as {@code OrderFakeBuilder}), keeps a deep copy of it and returns a new deep
 * copy on every read (objects that are not sdktest fakes, such as SDK {@code *Impl} instances, are shared between the
 * copies); any other {@link Order} implementation is registered with {@link #addOrder(Supplier)}, whose supplier must
 * return a new order on every call. An order without a positive id or a non-blank document number cannot be found
 * and is rejected with an {@link IllegalArgumentException}. Orders are found by id and by document number; a non-positive id or a null or
 * blank document number finds none, without reaching the store, as in production.</p>
 *
 * <p>The fake returns the orders as they were built. Fields that the SDK documents as only filled by
 * {@link OrderResource} ({@code Order.isTaxesIncluded()}, {@code getPurchaseCurrencyAmounts()}, {@code getRMAs()},
 * {@code getCreditNotes()} and {@code getPermalinkUrl()}, {@code OrderItem.getType()} and {@code getBundleItems()},
 * {@code OrderShipmentItem.getHash()}) keep the builders' defaults, which are null, unless the test sets them, whereas
 * production fills them; set every such field the plugin reads.</p>
 *
 * <p>{@link #getOrders(OrderListParam)} does not filter: it records the parameter (see {@link #getOrderListParams()})
 * and returns a new list with the entries given to {@link #addOrderList(OrderList)}, whatever the parameter.</p>
 *
 * <p>{@link #failWith(PluginResourceException)} makes every call throw the given {@link PluginResourceException},
 * {@link #failWith(String, PluginResourceException)} every call of one method (a method name covers its overloads),
 * and {@link #failWith(String, PluginResourceException, int)} only the next calls of that method, which then succeed
 * again (to test a requeue followed by a successful read); counted failures are thrown first, and the same exception
 * instance every time. {@link #clearFailures()} undoes them.</p>
 */
public class OrderResourceFake implements OrderResource {

	private final Map<Integer, Supplier<? extends Order>> ordersById = new LinkedHashMap<>();

	private final Map<String, Supplier<? extends Order>> ordersByDocumentNumber = new LinkedHashMap<>();

	private final List<OrderList> orderList = new ArrayList<>();

	private final List<OrderListParam> orderListParams = new ArrayList<>();

	private final ResourceFailures failures = new ResourceFailures(OrderResource.class);

	@Override
	public List<OrderList> getOrders(OrderListParam param) throws PluginResourceException {
		failures.check("getOrders");
		orderListParams.add(param);
		return new ArrayList<>(orderList);
	}

	@Override
	public Order getOrder(int orderId) throws PluginResourceException {
		if (orderId <= 0) {
			return null;
		}
		failures.check("getOrder");
		return read(ordersById.get(orderId));
	}

	@Override
	public Order getOrder(String documentNumber) throws PluginResourceException {
		if (documentNumber == null || documentNumber.isBlank()) {
			return null;
		}
		failures.check("getOrder");
		return read(ordersByDocumentNumber.get(documentNumber));
	}

	public void addOrder(Order order) {
		if (!FakeCopier.isFake(order)) {
			throw new IllegalArgumentException("addOrder(Order) copies orders built with the sdktest fakes; register "
				+ (order == null ? "null" : order.getClass().getName()) + " with addOrder(Supplier)");
		}
		Order snapshot = FakeCopier.copy(order);
		addOrder(() -> FakeCopier.copy(snapshot));
	}

	public void addOrder(Supplier<? extends Order> supplier) {
		Order order = supplier.get();
		if (order == null || order == supplier.get()) {
			throw new IllegalArgumentException("The supplier must return a new order on every call");
		}
		boolean findableById = order.getId() != null && order.getId() > 0;
		boolean findableByDocumentNumber = order.getDocumentNumber() != null && !order.getDocumentNumber().isBlank();
		if (!findableById && !findableByDocumentNumber) {
			throw new IllegalArgumentException("The order needs a positive id or a non-blank document number to be found");
		}
		if (findableById) {
			ordersById.put(order.getId(), supplier);
		}
		if (findableByDocumentNumber) {
			ordersByDocumentNumber.put(order.getDocumentNumber(), supplier);
		}
	}

	public void addOrderList(OrderList order) {
		orderList.add(order);
	}

	public List<OrderListParam> getOrderListParams() {
		return orderListParams;
	}

	public void failWith(PluginResourceException exception) {
		failures.failWith(exception);
	}

	public void failWith(String methodName, PluginResourceException exception) {
		failures.failWith(methodName, exception);
	}

	public void failWith(String methodName, PluginResourceException exception, int times) {
		failures.failWith(methodName, exception, times);
	}

	public void clearFailures() {
		failures.clear();
	}

	private static Order read(Supplier<? extends Order> supplier) {
		return supplier == null ? null : supplier.get();
	}

}
