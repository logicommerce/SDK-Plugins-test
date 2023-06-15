package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.UserAddress;

public class AddressBuilder<T, S> {

	private T parentBuilder;

	private String alias;

	private String firstName;

	private String lastName;

	private String companyy;

	private String address;

	private String addressAdditionalInformation;

	private String number;

	private String city;

	private String state;

	private String postalCode;

	private String vat;

	private String nif;

	private String phone;

	private String mobile;

	private String fax;

	private boolean tax;

	private boolean re;

	private boolean reverseChargeVat;

	private LocationFakeBuilder<AddressBuilder<T, S>> location;

	private String name;

	public AddressBuilder() {
		alias = "alias DEFAULT";
		firstName = "firstName DEFAULT";
		lastName = "lastName DEFAULT";
		companyy = "companyy DEFAULT";
		address = "address DEFAULT";
		addressAdditionalInformation = "addressAdditionalInformation DEFAULT";
		number = "number DEFAULT";
		city = "city DEFAULT";
		state = "state DEFAULT";
		postalCode = "postalCode DEFAULT";
		vat = "vat DEFAULT";
		nif = "nif DEFAULT";
		phone = "phone DEFAULT";
		mobile = "mobile DEFAULT";
		fax = "fax DEFAULT";
		location = new LocationFakeBuilder<>(returnThis());
		name = "name DEFAULT";

	}

	public AddressBuilder(T parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public AddressBuilder<T, S> alias(String alias) {
		this.alias = alias;
		return returnThis();
	}

	public AddressBuilder<T, S> firstName(String firstName) {
		this.firstName = firstName;
		return returnThis();
	}

	public AddressBuilder<T, S> lastName(String lastName) {
		this.lastName = lastName;
		return returnThis();
	}

	public AddressBuilder<T, S> companyy(String companyy) {
		this.companyy = companyy;
		return returnThis();
	}

	public AddressBuilder<T, S> address(String address) {
		this.address = address;
		return returnThis();
	}

	public AddressBuilder<T, S> addressAdditionalInformation(String addressAdditionalInformation) {
		this.addressAdditionalInformation = addressAdditionalInformation;
		return returnThis();
	}

	public AddressBuilder<T, S> number(String number) {
		this.number = number;
		return returnThis();
	}

	public AddressBuilder<T, S> city(String city) {
		this.city = city;
		return returnThis();
	}

	public AddressBuilder<T, S> state(String state) {
		this.state = state;
		return returnThis();
	}

	public AddressBuilder<T, S> postalCode(String postalCode) {
		this.postalCode = postalCode;
		return returnThis();
	}

	public AddressBuilder<T, S> vat(String vat) {
		this.vat = vat;
		return returnThis();
	}

	public AddressBuilder<T, S> nif(String nif) {
		this.nif = nif;
		return returnThis();
	}

	public AddressBuilder<T, S> phone(String phone) {
		this.phone = phone;
		return returnThis();
	}

	public AddressBuilder<T, S> mobile(String mobile) {
		this.mobile = mobile;
		return returnThis();
	}

	public AddressBuilder<T, S> fax(String fax) {
		this.fax = fax;
		return returnThis();
	}

	public AddressBuilder<T, S> tax(boolean tax) {
		this.tax = tax;
		return returnThis();
	}

	public AddressBuilder<T, S> re(boolean re) {
		this.re = re;
		return returnThis();
	}

	public AddressBuilder<T, S> reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return returnThis();
	}

	public LocationFakeBuilder<AddressBuilder<T, S>> location() {
		return location;
	}

	public AddressBuilder<T, S> name(String name) {
		this.name = name;
		return returnThis();
	}

	public UserAddress build() {
		AddressFake addressFake = new AddressFake();
		setElements(addressFake);
		return addressFake;
	}

	protected void setElements(AddressFake addressFake) {
		addressFake.setAlias(alias);
		addressFake.setFirstName(firstName);
		addressFake.setLastName(lastName);
		addressFake.setCompanyy(companyy);
		addressFake.setAddress(address);
		addressFake.setAddressAdditionalInformation(addressAdditionalInformation);
		addressFake.setNumber(number);
		addressFake.setCity(city);
		addressFake.setState(state);
		addressFake.setPostalCode(postalCode);
		addressFake.setVat(vat);
		addressFake.setNif(nif);
		addressFake.setPhone(phone);
		addressFake.setMobile(mobile);
		addressFake.setFax(fax);
		addressFake.setTax(tax);
		addressFake.setRe(re);
		addressFake.setReverseChargeVat(reverseChargeVat);
		addressFake.setLocation(location.build());
		addressFake.setName(name);
	}

	public T done() {
		return parentBuilder;
	}

	protected AddressBuilder<T, S> returnThis() {
		return this;
	}
}
