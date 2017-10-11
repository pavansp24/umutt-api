package org.umutt.dto;

import java.util.Date;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by Gokul Kulkarni on 10/10/17.
 */
@DataObject(generateConverter = true)
public class RegistrationDto extends Response {

	private Long donorID;
	private String name;
	private String address;
	private String area;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String email;
	private Integer noOfFamilyMembers;
	private Boolean subscribeForUpdates;
	private Long createdDt;
	private UserDto volunteer;

	public RegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationDto(JsonObject jsonObject) {
		RegistrationDtoConverter.fromJson(jsonObject, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		RegistrationDtoConverter.toJson(this, json);
		return json;
	}

	public Long getDonorID() {
		return donorID;
	}

	public void setDonorID(Long donorID) {
		this.donorID = donorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNoOfFamilyMembers() {
		return noOfFamilyMembers;
	}

	public void setNoOfFamilyMembers(Integer noOfFamilyMembers) {
		this.noOfFamilyMembers = noOfFamilyMembers;
	}

	public UserDto getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(UserDto volunteer) {
		this.volunteer = volunteer;
	}
	
	public Boolean getSubscribeForUpdates() {
		return subscribeForUpdates;
	}
	
	public void setSubscribeForUpdates(Boolean subscribeForUpdates) {
		this.subscribeForUpdates = subscribeForUpdates;
	}

	public void setCreatedDt(Long createdDt) {
		this.createdDt = createdDt;
	}
	
	public Long getCreatedDt() {
		return createdDt;
	}
}
