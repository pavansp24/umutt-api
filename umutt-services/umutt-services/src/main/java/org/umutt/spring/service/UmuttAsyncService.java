package org.umutt.spring.service;

import java.util.List;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import org.umutt.dto.LoginRequest;
import org.umutt.dto.RegistrationDto;
import org.umutt.dto.UserDto;

@ProxyGen
public interface UmuttAsyncService {

	String ADDRESS = UmuttAsyncService.class.getName();
	
	public void addUser(UserDto user , Handler<AsyncResult<UserDto>> resHandler);
	
	public void getUser(LoginRequest loginRequest , Handler<AsyncResult<UserDto>> resultHandler);
	
	public void register(RegistrationDto dto , Handler<AsyncResult<RegistrationDto>> resHandler);
	
	public void list(String userId , Handler<AsyncResult<List<RegistrationDto>>> resHandler);
	


}
