package org.umutt.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "UMUTT_REGISTRATION")
public class Registrations {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="REG_ID" , updatable=false , nullable = false)
	private Long id;
	
	@Column(name="EVENT")
	private String event;
	
	@Column(name="FULL_NM")
	private String fullName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="LOCALITY")
	private String locality;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FAMILY_MEM_COUNT")
	private Integer familyMemCount;
	
	@Column(name="CRT_BY")
	private String createdBy;
	
	@Column(name="UPD_BY")
	private String updatedBy;

	@Column(name="CRT_DT")
	private Date createdDt;

	@Column(name="UPD_DT")
	private Date updatedDt;
	
	@Column(name="SUBSCRIBED")
	private boolean subscribed;
	
	
	public Registrations() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
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


	public Integer getFamilyMemCount() {
		return familyMemCount;
	}


	public void setFamilyMemCount(Integer familyMemCount) {
		this.familyMemCount = familyMemCount;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getCreatedDt() {
		return createdDt;
	}


	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}


	public Date getUpdatedDt() {
		return updatedDt;
	}


	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}
	
	public boolean isSubscribed() {
		return subscribed;
	}
	
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
	
	@PrePersist
	public void initialize() {
		createdDt = new Date();
		updatedDt = new Date();
	}
	
	@PreUpdate
	public void update() {
		updatedDt = new Date();
	}
}
