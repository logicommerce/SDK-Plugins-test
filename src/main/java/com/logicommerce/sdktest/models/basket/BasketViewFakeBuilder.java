package com.logicommerce.sdktest.models.basket;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.basket.BasketView;

public class BasketViewFakeBuilder<T> {

	private T parentBuilder;
	private String token;
	private int id;
	private String currencyCode;
	private boolean taxesIncluded;
	private String countryCode;
	private String languageCode;
	private CustomerViewFakeBuilder<BasketViewFakeBuilder<T>> customer;
	private List<BasketRowViewFakeBuilder<BasketViewFakeBuilder<T>>> rows;
	private List<AppliedDiscountViewFakeBuilder<BasketViewFakeBuilder<T>>> discounts;
	private List<VoucherCodeResultFakeBuilder<BasketViewFakeBuilder<T>>> voucherCodes;
	private TotalsViewFakeBuilder<BasketViewFakeBuilder<T>> totals;
	private List<BasketIssueFakeBuilder<BasketViewFakeBuilder<T>>> issues;
	private List<ChangeRejectionFakeBuilder<BasketViewFakeBuilder<T>>> rejections;
	private Integer documentId;
	private boolean loggedIn;
	private boolean pendingLogin;
	private Integer accountId;
	private Instant updatedAt;
	private Duration lifeTime;
	private String storeBaseUrl;

	public BasketViewFakeBuilder() {
		token = "token DEFAULT";
		id = 0;
		currencyCode = "EUR";
		taxesIncluded = true;
		countryCode = "ES";
		languageCode = "es";
		customer = new CustomerViewFakeBuilder<>(this);
		rows = new ArrayList<>();
		discounts = new ArrayList<>();
		voucherCodes = new ArrayList<>();
		totals = new TotalsViewFakeBuilder<>(this);
		issues = new ArrayList<>();
		rejections = new ArrayList<>();
		documentId = null;
		loggedIn = false;
		pendingLogin = false;
		accountId = null;
		updatedAt = Instant.now();
		lifeTime = Duration.ofDays(30);
		storeBaseUrl = "https://test.com/storeUrl";
	}

	public BasketViewFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public BasketViewFakeBuilder<T> token(String token) {
		this.token = token;
		return this;
	}

	public BasketViewFakeBuilder<T> id(int id) {
		this.id = id;
		return this;
	}

	public BasketViewFakeBuilder<T> currencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public BasketViewFakeBuilder<T> taxesIncluded(boolean taxesIncluded) {
		this.taxesIncluded = taxesIncluded;
		return this;
	}

	public BasketViewFakeBuilder<T> countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public BasketViewFakeBuilder<T> languageCode(String languageCode) {
		this.languageCode = languageCode;
		return this;
	}

	public CustomerViewFakeBuilder<BasketViewFakeBuilder<T>> customer() {
		return customer;
	}

	public BasketRowViewFakeBuilder<BasketViewFakeBuilder<T>> row() {
		BasketRowViewFakeBuilder<BasketViewFakeBuilder<T>> row = new BasketRowViewFakeBuilder<>(this);
		rows.add(row);
		return row;
	}

	public AppliedDiscountViewFakeBuilder<BasketViewFakeBuilder<T>> discount() {
		AppliedDiscountViewFakeBuilder<BasketViewFakeBuilder<T>> discount = new AppliedDiscountViewFakeBuilder<>(this);
		discounts.add(discount);
		return discount;
	}

	public VoucherCodeResultFakeBuilder<BasketViewFakeBuilder<T>> voucherCode() {
		VoucherCodeResultFakeBuilder<BasketViewFakeBuilder<T>> voucherCode = new VoucherCodeResultFakeBuilder<>(this);
		voucherCodes.add(voucherCode);
		return voucherCode;
	}

	public TotalsViewFakeBuilder<BasketViewFakeBuilder<T>> totals() {
		return totals;
	}

	public BasketIssueFakeBuilder<BasketViewFakeBuilder<T>> issue() {
		BasketIssueFakeBuilder<BasketViewFakeBuilder<T>> issue = new BasketIssueFakeBuilder<>(this);
		issues.add(issue);
		return issue;
	}

	public ChangeRejectionFakeBuilder<BasketViewFakeBuilder<T>> rejection() {
		ChangeRejectionFakeBuilder<BasketViewFakeBuilder<T>> rejection = new ChangeRejectionFakeBuilder<>(this);
		rejections.add(rejection);
		return rejection;
	}

	public BasketViewFakeBuilder<T> documentId(Integer documentId) {
		this.documentId = documentId;
		return this;
	}

	public BasketViewFakeBuilder<T> loggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		return this;
	}

	public BasketViewFakeBuilder<T> pendingLogin(boolean pendingLogin) {
		this.pendingLogin = pendingLogin;
		return this;
	}

	public BasketViewFakeBuilder<T> accountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}

	public BasketViewFakeBuilder<T> updatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public BasketViewFakeBuilder<T> lifeTime(Duration lifeTime) {
		this.lifeTime = lifeTime;
		return this;
	}

	public BasketViewFakeBuilder<T> storeBaseUrl(String storeBaseUrl) {
		this.storeBaseUrl = storeBaseUrl;
		return this;
	}

	public BasketView build() {
		BasketViewFake basketView = new BasketViewFake();
		basketView.setToken(token);
		basketView.setId(id);
		basketView.setCurrencyCode(currencyCode);
		basketView.setTaxesIncluded(taxesIncluded);
		basketView.setCountryCode(countryCode);
		basketView.setLanguageCode(languageCode);
		basketView.setCustomer(customer.build());
		basketView.setRows(rows.stream().map(BasketRowViewFakeBuilder::build).collect(Collectors.toList()));
		basketView.setDiscounts(discounts.stream().map(AppliedDiscountViewFakeBuilder::build).collect(Collectors.toList()));
		basketView.setVoucherCodes(voucherCodes.stream().map(VoucherCodeResultFakeBuilder::build).collect(Collectors.toList()));
		basketView.setTotals(totals.build());
		basketView.setIssues(issues.stream().map(BasketIssueFakeBuilder::build).collect(Collectors.toList()));
		basketView.setRejections(rejections.stream().map(ChangeRejectionFakeBuilder::build).collect(Collectors.toList()));
		basketView.setDocumentId(documentId);
		basketView.setLoggedIn(loggedIn);
		basketView.setPendingLogin(pendingLogin);
		basketView.setAccountId(accountId);
		basketView.setUpdatedAt(updatedAt);
		basketView.setLifeTime(lifeTime);
		basketView.setStoreBaseUrl(storeBaseUrl);
		return basketView;
	}

	public T done() {
		return parentBuilder;
	}
}
