package com.logicommerce.sdktest.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import com.logicommerce.sdk.models.User;
import com.logicommerce.sdk.models.UserAddress;

public class UserFake implements User {

	private LocalDate birthday;

	private String company;

	private String email;

	private String gender;

	private Integer id;

	private String nick;

	private Integer salesAgentId;

	private Boolean salesAgent;

	private Map<String, String> customTags;

	private List<UserAddress> billingAddresses;

	private List<UserAddress> shippingAddresses;

	@Override
	public List<UserAddress> getBillingAddresses() {
		return billingAddresses;
	}

	@Override
	public LocalDate getBirthday() {
		return birthday;
	}

	@Override
	public String getCompany() {
		return company;
	}

	@Override
	public Map<String, String> getCustomTags() {
		return customTags;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getNick() {
		return nick;
	}

	@Override
	public Integer getSalesAgentId() {
		return salesAgentId;
	}

	@Override
	public List<UserAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	@Override
	public Boolean isSalesAgent() {
		return salesAgent;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setSalesAgentId(Integer salesAgentId) {
		this.salesAgentId = salesAgentId;
	}

	public void setSalesAgent(Boolean salesAgent) {
		this.salesAgent = salesAgent;
	}

	public void setCustomTags(Map<String, String> customTags) {
		this.customTags = customTags;
	}

	public void setBillingAddresses(List<UserAddress> billingAddresses) {
		this.billingAddresses = billingAddresses;
	}

	public void setShippingAddresses(List<UserAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

}
