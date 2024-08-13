package com.logicommerce.sdktest.models.order;

import com.logicommerce.sdk.models.Location;
import com.logicommerce.sdk.models.order.ShipmentAddress;

/**
 * Fake implementation of ShipmentAddress
 * 
 * @deprecated since 1.3.3 use {@link com.logicommerce.sdk.models.order.implementations.ShipmentAddressImpl} instead
 * @see com.logicommerce.sdk.models.order.ShipmentAddress
 */
@Deprecated(forRemoval = true, since = "1.3.3")
public class ShipmentAddressFake implements ShipmentAddress {

	private String name;

	private String address;

	private String number;

	private String addressAdditionalInformation;

	private String city;

	private String state;

	private String postalCode;

	private Location location;

	private String mobile;

	private String phone;

	private String email;
	
	private String company;

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public String getAddressAdditionalInformation() {
		return addressAdditionalInformation;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
}
