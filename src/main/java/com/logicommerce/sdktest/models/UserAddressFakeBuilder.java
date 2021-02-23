package com.logicommerce.sdktest.models;

import com.logicommerce.sdk.models.UserAddress;

public class UserAddressFakeBuilder<T> extends AddressBuilder<T, UserAddressFake> {

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

	public UserAddressFakeBuilder(T userFakeBuilder) {
		super(userFakeBuilder);
		alias = "alias DEFAULT";
		firstName = "firstName DEFAULT";
		lastName = "lastName DEFAULT";
		company = "company DEFAULT";
		addressAdditionalInformation = "addressAdditionalInformation DEFAULT";
		number = "number DEFAULT";
		vat = "vat DEFAULT";
		nif = "nif DEFAULT";
		phone = "phone DEFAULT";
		mobile = "mobile DEFAULT";
		fax = "fax DEFAULT";
	}

	public UserAddressFakeBuilder<T> defaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
		return this;
	}


	public UserAddressFakeBuilder<T> alias(String alias) {
		this.alias = alias;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> firstName(String firstName) {
		this.firstName = firstName;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> lastName(String lastName) {
		this.lastName = lastName;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> company(String company) {
		this.company = company;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> addressAdditionalInformation(String addressAdditionalInformation) {
		this.addressAdditionalInformation = addressAdditionalInformation;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> number(String number) {
		this.number = number;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> vat(String vat) {
		this.vat = vat;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> nif(String nif) {
		this.nif = nif;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> phone(String phone) {
		this.phone = phone;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> mobile(String mobile) {
		this.mobile = mobile;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> fax(String fax) {
		this.fax = fax;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> tax(boolean tax) {
		this.tax = tax;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> re(boolean re) {
		this.re = re;
		return returnThis();
	}

	public UserAddressFakeBuilder<T> reverseChargeVat(boolean reverseChargeVat) {
		this.reverseChargeVat = reverseChargeVat;
		return returnThis();
	}

	@Override
	public UserAddress build() {
		UserAddressFake userAddress = new UserAddressFake();
		setElements(userAddress);
		userAddress.setDefaultAddress(defaultAddress);
		userAddress.setAlias(alias);
		userAddress.setFirstName(firstName);
		userAddress.setLastName(lastName);
		userAddress.setCompanyy(company);
		userAddress.setAddressAdditionalInformation(addressAdditionalInformation);
		userAddress.setNumber(number);
		userAddress.setVat(vat);
		userAddress.setNif(nif);
		userAddress.setPhone(phone);
		userAddress.setMobile(mobile);
		userAddress.setFax(fax);
		userAddress.setTax(tax);
		userAddress.setRe(re);
		userAddress.setReverseChargeVat(reverseChargeVat);
		return userAddress;
	}

	@Override
	public UserAddressFakeBuilder<T> returnThis() {
		return this;
	}

}
