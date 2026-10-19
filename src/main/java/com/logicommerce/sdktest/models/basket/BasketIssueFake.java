package com.logicommerce.sdktest.models.basket;

import java.util.Map;
import com.logicommerce.sdk.enums.EndOrderField;
import com.logicommerce.sdk.enums.IssueSeverity;
import com.logicommerce.sdk.enums.IssueSource;
import com.logicommerce.sdk.models.basket.BasketIssue;

public class BasketIssueFake implements BasketIssue {

	private IssueSource source;

	private String code;

	private IssueSeverity severity;

	private String rowHash;

	private EndOrderField field;

	private Map<String, String> attributes;

	@Override
	public IssueSource getSource() {
		return source;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public IssueSeverity getSeverity() {
		return severity;
	}

	@Override
	public String getRowHash() {
		return rowHash;
	}

	@Override
	public EndOrderField getField() {
		return field;
	}

	@Override
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setSource(IssueSource source) {
		this.source = source;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setSeverity(IssueSeverity severity) {
		this.severity = severity;
	}

	public void setRowHash(String rowHash) {
		this.rowHash = rowHash;
	}

	public void setField(EndOrderField field) {
		this.field = field;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}
