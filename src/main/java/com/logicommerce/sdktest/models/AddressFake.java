package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.models.UserAddress;

public class AddressFake implements UserAddress {

	private String alias;

	private String firstName;

	private String lastName;

	private String company;

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

	private Location location;

	private String name;

	private boolean defaultAddress;

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
	public String getAddress() {
		return address;
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
	public String getCity() {
		return city;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
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
	@Deprecated(since = "1.1.17", forRemoval = true)
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
	@Deprecated(since = "1.1.17", forRemoval = true)
	public boolean isReverseChargeVat() {
		return reverseChargeVat;
	}

	@Override
	public Location getLocation() {
		return location;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressAdditionalInformation(String addressAdditionalInformation) {
		this.addressAdditionalInformation = addressAdditionalInformation;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	@Deprecated(since = "1.1.17", forRemoval = true)
	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public void setRe(boolean re) {
		this.re = re;
	}

	@Deprecated(since = "1.1.17", forRemoval = true)
	public void setReverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
}
