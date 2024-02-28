package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.implementations.HeadquarterImpl;

public class HeadquarterFakeBuilder<T> extends AddressFakeBuilder<T> {

	private String email;

	private String vat;

	private String timezone;

	private String locale;

	public HeadquarterFakeBuilder() {
		super();
		defaultValues();
	}

	public HeadquarterFakeBuilder(T parentBuilder) {
		super(parentBuilder);
		defaultValues();
	}

	@Override
	protected void defaultValues() {
		super.defaultValues();
		email = "email DEFAULT";
		vat = "vat DEFAULT";
		timezone = "timezone DEFAULT";
		locale = "locale DEFAULT";
	}

	public HeadquarterFakeBuilder<T> email(String email) {
		this.email = email;
		return returnThis();
	}

	public HeadquarterFakeBuilder<T> vat(String vat) {
		this.vat = vat;
		return returnThis();
	}

	public HeadquarterFakeBuilder<T> timezone(String timezone) {
		this.timezone = timezone;
		return returnThis();
	}

	public HeadquarterFakeBuilder<T> locale(String locale) {
		this.locale = locale;
		return returnThis();
	}

	public HeadquarterImpl build() {
		HeadquarterImpl addressImpl = new HeadquarterImpl();
		setElements(addressImpl);
		addressImpl.setEmail(email);
		addressImpl.setVat(vat);
		addressImpl.setTimezone(timezone);
		addressImpl.setLocale(locale);
		return addressImpl;
	}

	protected HeadquarterFakeBuilder<T> returnThis() {
		return this;
	}
}
