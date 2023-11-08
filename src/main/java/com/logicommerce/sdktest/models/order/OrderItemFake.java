package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.BackorderMode;
import com.logicommerce.sdk.models.CustomTag;
import com.logicommerce.sdk.models.RowCodes;
import com.logicommerce.sdk.models.order.OrderDiscount;
import com.logicommerce.sdk.models.order.OrderItem;
import com.logicommerce.sdk.models.order.OrderItemOption;
import com.logicommerce.sdk.models.order.OrderItemPrices;
import com.logicommerce.sdk.models.order.OrderItemStock;
import com.logicommerce.sdk.models.order.OrderItemTax;

public class OrderItemFake implements OrderItem {

	private Integer id;
	private String pId;
	private String hash;
	private String name;
	private Integer productId;
	private int quantity;
	private double weight;
	private OrderItemPrices prices;
	private Integer vinculatedTo;
	private String image;
	private boolean sale;
	private boolean stockManagement;
	private boolean reverseChargeVat;
	private RowCodes codes;
	private boolean noReturn;
	private BackorderMode backOrder;
	private boolean onRequest;
	private int onRequestDays;
	private String link;
	private Integer combinationId;
	private String supplierReference;
	private List<OrderItemOption> options;
	private List<OrderItemStock> stocks;
	private List<OrderItemTax> taxes;
	private List<CustomTag> customTags;
	private List<OrderDiscount> discounts;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	@Override
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public OrderItemPrices getPrices() {
		return prices;
	}

	public void setPrices(OrderItemPrices prices) {
		this.prices = prices;
	}

	@Override
	public Integer getVinculatedTo() {
		return vinculatedTo;
	}

	public void setVinculatedTo(Integer vinculatedTo) {
		this.vinculatedTo = vinculatedTo;
	}

	@Override
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public boolean isSale() {
		return sale;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	@Override
	public boolean isStockManagement() {
		return stockManagement;
	}

	public void setStockManagement(boolean stockManagement) {
		this.stockManagement = stockManagement;
	}

	@Override
	public boolean isReverseChargeVat() {
		return reverseChargeVat;
	}

	public void setReverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
	}

	@Override
	public RowCodes getCodes() {
		return codes;
	}

	public void setCodes(RowCodes codes) {
		this.codes = codes;
	}

	@Override
	public boolean isNoReturn() {
		return noReturn;
	}

	public void setNoReturn(boolean noReturn) {
		this.noReturn = noReturn;
	}

	@Override
	public BackorderMode getBackOrder() {
		return backOrder;
	}

	public void setBackOrder(BackorderMode backOrder) {
		this.backOrder = backOrder;
	}

	@Override
	public boolean isOnRequest() {
		return onRequest;
	}

	public void setOnRequest(boolean onRequest) {
		this.onRequest = onRequest;
	}

	@Override
	public int getOnRequestDays() {
		return onRequestDays;
	}

	public void setOnRequestDays(int onRequestDays) {
		this.onRequestDays = onRequestDays;
	}

	@Override
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public Integer getCombinationId() {
		return combinationId;
	}

	public void setCombinationId(Integer combinationId) {
		this.combinationId = combinationId;
	}

	@Override
	public String getSupplierReference() {
		return supplierReference;
	}

	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}

	@Override
	public List<OrderItemOption> getOptions() {
		return options;
	}

	public void setOptions(List<OrderItemOption> options) {
		this.options = options;
	}

	@Override
	public List<OrderItemStock> getStocks() {
		return stocks;
	}

	public void setStocks(List<OrderItemStock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public List<OrderItemTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<OrderItemTax> taxes) {
		this.taxes = taxes;
	}

	@Override
	public List<CustomTag> getCustomTags() {
		return customTags;
	}

	public void setCustomTags(List<CustomTag> customTags) {
		this.customTags = customTags;
	}

	@Override
	public List<OrderDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<OrderDiscount> discounts) {
		this.discounts = discounts;
	}

}
