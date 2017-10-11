package org.umutt.spring.service;

import java.util.List;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.umutt.dto.LoginRequest;
import org.umutt.dto.RegistrationDto;
import org.umutt.dto.UserDto;

@Component
public class UmuttAsyncServiceImpl implements UmuttAsyncService {

	@Autowired
	private UmuttSpringService service; 
	
	@Override
	public void addUser(UserDto user, Handler<AsyncResult<UserDto>> resHandler) {
		UserDto dto = service.saveUser(user);
		Future.succeededFuture(dto).setHandler(resHandler);
	}

	@Override
	public void getUser(LoginRequest loginRequest,Handler<AsyncResult<UserDto>> resultHandler) {
		Future.succeededFuture(service.getUser(loginRequest)).setHandler(resultHandler);
	}

	@Override
	public void register(RegistrationDto dto,
			Handler<AsyncResult<RegistrationDto>> resHandler) {
		RegistrationDto registrationDto =  service.register(dto);
		Future.succeededFuture(registrationDto).setHandler(resHandler);
	}

	@Override
	public void list(String userId,
			Handler<AsyncResult<List<RegistrationDto>>> resHandler) {
		Future.succeededFuture(service.getRegistrationByVolunteer(userId)).setHandler(resHandler);

	}

}
