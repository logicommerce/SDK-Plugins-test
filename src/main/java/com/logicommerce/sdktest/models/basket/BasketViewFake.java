package com.logicommerce.sdktest.models.basket;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import com.logicommerce.sdk.models.basket.AppliedDiscountView;
import com.logicommerce.sdk.models.basket.BasketIssue;
import com.logicommerce.sdk.models.basket.BasketRowView;
import com.logicommerce.sdk.models.basket.BasketView;
import com.logicommerce.sdk.models.basket.ChangeRejection;
import com.logicommerce.sdk.models.basket.CustomerView;
import com.logicommerce.sdk.models.basket.TotalsView;
import com.logicommerce.sdk.models.basket.VoucherCodeResult;

public class BasketViewFake implements BasketView {

	private String token;

	private int id;

	private String currencyCode;

	private boolean taxesIncluded;

	private String countryCode;

	private String languageCode;

	private CustomerView customer;

	private List<BasketRowView> rows;

	private List<AppliedDiscountView> discounts;

	private List<VoucherCodeResult> voucherCodes;

	private TotalsView totals;

	private List<BasketIssue> issues;

	private List<ChangeRejection> rejections;

	private Integer documentId;

	private boolean loggedIn;

	private boolean pendingLogin;

	private Integer accountId;

	private Instant updatedAt;

	private Duration lifeTime;

	private String storeBaseUrl;

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	@Override
	public boolean isTaxesIncluded() {
		return taxesIncluded;
	}

	@Override
	public String getCountryCode() {
		return countryCode;
	}

	@Override
	public String getLanguageCode() {
		return languageCode;
	}

	@Override
	public CustomerView getCustomer() {
		return customer;
	}

	@Override
	public List<BasketRowView> getRows() {
		return rows;
	}

	@Override
	public List<AppliedDiscountView> getDiscounts() {
		return discounts;
	}

	@Override
	public List<VoucherCodeResult> getVoucherCodes() {
		return voucherCodes;
	}

	@Override
	public TotalsView getTotals() {
		return totals;
	}

	@Override
	public List<BasketIssue> getIssues() {
		return issues;
	}

	@Override
	public List<ChangeRejection> getRejections() {
		return rejections;
	}

	@Override
	public Integer getDocumentId() {
		return documentId;
	}

	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}

	@Override
	public boolean isPendingLogin() {
		return pendingLogin;
	}

	@Override
	public Integer getAccountId() {
		return accountId;
	}

	@Override
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public Duration getLifeTime() {
		return lifeTime;
	}

	@Override
	public String getStoreBaseUrl() {
		return storeBaseUrl;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setTaxesIncluded(boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setCustomer(CustomerView customer) {
		this.customer = customer;
	}

	public void setRows(List<BasketRowView> rows) {
		this.rows = rows;
	}

	public void setDiscounts(List<AppliedDiscountView> discounts) {
		this.discounts = discounts;
	}

	public void setVoucherCodes(List<VoucherCodeResult> voucherCodes) {
		this.voucherCodes = voucherCodes;
	}

	public void setTotals(TotalsView totals) {
		this.totals = totals;
	}

	public void setIssues(List<BasketIssue> issues) {
		this.issues = issues;
	}

	public void setRejections(List<ChangeRejection> rejections) {
		this.rejections = rejections;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setPendingLogin(boolean pendingLogin) {
		this.pendingLogin = pendingLogin;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setLifeTime(Duration lifeTime) {
		this.lifeTime = lifeTime;
	}

	public void setStoreBaseUrl(String storeBaseUrl) {
		this.storeBaseUrl = storeBaseUrl;
	}
}
