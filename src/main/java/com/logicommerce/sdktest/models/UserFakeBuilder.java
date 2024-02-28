package com.logicommerce.sdktest.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.logicommerce.sdk.models.User;

public class UserFakeBuilder {

	private CartFakeBuilder parentBuilder;

	private List<UserAddressFakeBuilder<UserFakeBuilder>> billingAddresses;

	private LocalDate birthday;

	private String company;

	private Map<String, String> customTags;

	private String email;

	private String gender;

	private Integer id;

	private String nick;

	private Integer salesAgentId;

	private List<UserAddressFakeBuilder<UserFakeBuilder>> shippingAddresses;

	private Boolean salesAgent;

	public UserFakeBuilder() {
		billingAddresses = new ArrayList<>();
		birthday = null;
		company = "company DEFAULT";
		customTags = new LinkedHashMap<>();
		email = "email DEFAULT";
		gender = "gender DEFAULT";
		id = 1;
		nick = "nick DEFAULT";
		salesAgentId = 1;
		shippingAddresses = new ArrayList<>();
		salesAgent = false;
	}

	public UserFakeBuilder(CartFakeBuilder parentBuilder) {
		this();
		this.parentBuilder = parentBuilder;
	}

	public UserFakeBuilder birthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public UserFakeBuilder company(String company) {
		this.company = company;
		return this;
	}

	public UserFakeBuilder customTag(String name, String value) {
		this.customTags.put(name, value);
		return this;
	}

	public UserFakeBuilder email(String email) {
		this.email = email;
		return this;
	}

	public UserFakeBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}

	public UserFakeBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public UserFakeBuilder nick(String nick) {
		this.nick = nick;
		return this;
	}

	public UserFakeBuilder salesAgentId(Integer salesAgentId) {
		this.salesAgentId = salesAgentId;
		return this;
	}

	public UserAddressFakeBuilder<UserFakeBuilder> billingAddress() {
		var builder = new UserAddressFakeBuilder<>(this);
		billingAddresses.add(builder);
		return builder;
	}

	public UserAddressFakeBuilder<UserFakeBuilder> shippingAddress() {
		var builder = new UserAddressFakeBuilder<>(this);
		shippingAddresses.add(builder);
		return builder;
	}

	public UserFakeBuilder salesAgent(Boolean salesAgent) {
		this.salesAgent = salesAgent;
		return this;
	}

	public User build() {
		UserFake user = new UserFake();
		user.setBirthday(birthday);
		user.setCompany(company);
		user.setEmail(email);
		user.setGender(gender);
		user.setId(id);
		user.setNick(nick);
		user.setSalesAgentId(salesAgentId);
		user.setSalesAgent(salesAgent);
		user.setCustomTags(customTags);
		user.setBillingAddresses(billingAddresses.stream()
			.map(UserAddressFakeBuilder::build)
			.collect(Collectors.toList()));
		user.setShippingAddresses(shippingAddresses.stream()
			.map(UserAddressFakeBuilder::build)
			.collect(Collectors.toList()));
		return user;
	}

	public CartFakeBuilder done() {
		return parentBuilder;
	}
}
