package org.umutt.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UMUTT_USER")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FNAME")
	private String firstName;

	@Column(name="LNAME")
	private String lastName;
	
	@Column(name="ROLE")
	private Integer role;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	
	public User() {
		// TODO Auto-generated constructor stub
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
