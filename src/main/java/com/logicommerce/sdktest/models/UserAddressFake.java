package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.UserAddress;

public class UserAddressFake extends AddressFake implements UserAddress {

	private boolean defaultAddress;

	private String alias;

	private String firstName;

	private String lastName;

	private String company;

	private String addressAdditionalInformation;

	private String number;

	private String vat;

	private String nif;

	private String phone;

	private String mobile;

	private String fax;

	private boolean tax;

	private boolean re;

	private boolean reverseChargeVat;

	@Override
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	@Override
	public String getAlias() {
		return alias;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getCompany() {
		return company;
	}

	@Override
	public String getAddressAdditionalInformation() {
		return addressAdditionalInformation;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public String getVat() {
		return vat;
	}

	@Override
	public String getNif() {
		return nif;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public String getFax() {
		return fax;
	}

	@Override
	public boolean isTax() {
		return tax;
	}

	@Override
	public boolean isRe() {
		return re;
	}

	@Override
	public boolean isReverseChargeVat() {
		return reverseChargeVat;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCompanyy(String companyy) {
		this.company = companyy;
	}

	public void setAddressAdditionalInformation(String addressAdditionalInformation) {
		this.addressAdditionalInformation = addressAdditionalInformation;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public void setRe(boolean re) {
		this.re = re;
	}

	public void setReverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
	}
}
