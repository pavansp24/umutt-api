package org.umutt.dto;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class UserDto {

	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	private Integer role;

	private String email;

	private String phone;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(JsonObject jsonObject) {
		UserDtoConverter.fromJson(jsonObject, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		UserDtoConverter.toJson(this, json);
		return json;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
