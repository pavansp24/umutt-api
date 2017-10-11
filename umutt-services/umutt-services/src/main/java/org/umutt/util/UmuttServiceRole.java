package org.umutt.util;

public enum UmuttServiceRole {
	
	ADMIN(99,"Admin"),
	VOLUNTEER (100,"Volunteer");
	
	Integer role;
	String description;
	
	private UmuttServiceRole(Integer role , String description) {
		this.role = role;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Integer getRole() {
		return role;
	}
}
