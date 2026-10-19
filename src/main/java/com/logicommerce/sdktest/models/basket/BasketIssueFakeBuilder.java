package com.logicommerce.sdktest.models.basket;

import java.util.LinkedHashMap;
import java.util.Map;
import com.logicommerce.sdk.enums.EndOrderField;
import com.logicommerce.sdk.enums.IssueSeverity;
import com.logicommerce.sdk.enums.IssueSource;
import com.logicommerce.sdk.models.basket.BasketIssue;

public class BasketIssueFakeBuilder<T> {

	private T parentBuilder;
	private IssueSource source;
	private String code;
	private IssueSeverity severity;
	private String rowHash;
	private EndOrderField field;
	private Map<String, String> attributes;

	public BasketIssueFakeBuilder() {
		source = IssueSource.WARNING;
		code = "code DEFAULT";
		severity = IssueSeverity.WARNING;
		rowHash = null;
		field = null;
		attributes = new LinkedHashMap<>();
	}

	public BasketIssueFakeBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public BasketIssueFakeBuilder<T> source(IssueSource source) {
		this.source = source;
		return this;
	}

	public BasketIssueFakeBuilder<T> code(String code) {
		this.code = code;
		return this;
	}

	public BasketIssueFakeBuilder<T> severity(IssueSeverity severity) {
		this.severity = severity;
		return this;
	}

	public BasketIssueFakeBuilder<T> rowHash(String rowHash) {
		this.rowHash = rowHash;
		return this;
	}

	public BasketIssueFakeBuilder<T> field(EndOrderField field) {
		this.field = field;
		return this;
	}

	public BasketIssueFakeBuilder<T> attributes(Map<String, String> attributes) {
		this.attributes = attributes;
		return this;
	}

	public BasketIssue build() {
		BasketIssueFake basketIssue = new BasketIssueFake();
		basketIssue.setSource(source);
		basketIssue.setCode(code);
		basketIssue.setSeverity(severity);
		basketIssue.setRowHash(rowHash);
		basketIssue.setField(field);
		basketIssue.setAttributes(attributes);
		return basketIssue;
	}

	public T done() {
		return parentBuilder;
	}
}
