package com.logicommerce.sdktest.models.order;

import java.util.List;
import com.logicommerce.sdk.enums.BackorderMode;
import com.logicommerce.sdk.models.CustomTag;
import com.logicommerce.sdk.models.ProductCodes;
import com.logicommerce.sdk.models.order.OrderDiscount;
import com.logicommerce.sdk.models.order.OrderItem;
import com.logicommerce.sdk.models.order.OrderItemOption;
import com.logicommerce.sdk.models.order.OrderItemPrices;
import com.logicommerce.sdk.models.order.OrderItemStock;
import com.logicommerce.sdk.models.order.OrderItemTax;

public class OrderItemFake implements OrderItem {

	private Integer id;
	private String pId;
	private List<OrderItemTax> taxes;
	private List<OrderItemOption> options;
	private List<OrderItemStock> stocks;
	private List<CustomTag> customTags;
	private List<OrderDiscount> discounts;
	private String name;
	private int quantity;
	private Integer productId;
	private double weight;
	private OrderItemPrices prices;
	private Integer vinculatedTo;
	private String image;
	private boolean sale;
	private boolean stockManagement;
	private boolean reverseChargeVat;
	private ProductCodes codes;
	private boolean noReturn;
	private BackorderMode backOrder;
	private boolean onRequest;
	private int onRequestDays;
	private String link;	
	private Integer combinationId;	
	private String supplierReference;

	@Override
	public BackorderMode getBackOrder() {
		return backOrder;
	}

	@Override
	public ProductCodes getCodes() {
		return codes;
	}

	@Override
	public List<CustomTag> getCustomTags() {
		return customTags;
	}

	@Override
	public List<OrderDiscount> getDiscounts() {
		return discounts;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getOnRequestDays() {
		return onRequestDays;
	}

	@Override
	public List<OrderItemOption> getOptions() {
		return options;
	}

	@Override
	public String getPId() {
		return pId;
	}

	@Override
	public OrderItemPrices getPrices() {
		return prices;
	}

	@Override
	public Integer getProductId() {
		return productId;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public List<OrderItemStock> getStocks() {
		return stocks;
	}

	@Override
	public List<OrderItemTax> getTaxes() {
		return taxes;
	}

	@Override
	public Integer getVinculatedTo() {
		return vinculatedTo;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public boolean isNoReturn() {
		return noReturn;
	}

	@Override
	public boolean isOnRequest() {
		return onRequest;
	}

	@Override
	public boolean isReverseChargeVat() {
		return reverseChargeVat;
	}

	@Override
	public boolean isSale() {
		return sale;
	}

	@Override
	public boolean isStockManagement() {
		return stockManagement;
	}

	@Override
	public String getLink() {
		return link;
	}

	public void setBackOrder(BackorderMode backOrder) {
		this.backOrder = backOrder;
	}

	public void setCodes(ProductCodes codes) {
		this.codes = codes;
	}

	public void setCustomTags(List<CustomTag> customTags) {
		this.customTags = customTags;
	}

	public void setDiscounts(List<OrderDiscount> discounts) {
		this.discounts = discounts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOnRequestDays(int onRequestDays) {
		this.onRequestDays = onRequestDays;
	}

	public void setOptions(List<OrderItemOption> options) {
		this.options = options;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setPrices(OrderItemPrices prices) {
		this.prices = prices;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStocks(List<OrderItemStock> stocks) {
		this.stocks = stocks;
	}

	public void setTaxes(List<OrderItemTax> taxes) {
		this.taxes = taxes;
	}

	public void setVinculatedTo(Integer vinculatedTo) {
		this.vinculatedTo = vinculatedTo;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setNoReturn(boolean noReturn) {
		this.noReturn = noReturn;
	}

	public void setOnRequest(boolean onRequest) {
		this.onRequest = onRequest;
	}

	public void setReverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public void setStockManagement(boolean stockManagement) {
		this.stockManagement = stockManagement;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public Integer getCombinationId() {
		return combinationId;
	}

	@Override
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
}
