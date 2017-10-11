package org.umutt.dto;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by Gokul Kulkarni on 10/10/17.
 */

@DataObject(generateConverter = true)
public class LoginRequest {

	private String username;
	private String password;

	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(JsonObject jsonObject) {
		LoginRequestConverter.fromJson(jsonObject, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		LoginRequestConverter.toJson(this, json);
		return json;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
