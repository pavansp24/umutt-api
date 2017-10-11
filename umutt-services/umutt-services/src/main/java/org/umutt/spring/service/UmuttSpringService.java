package org.umutt.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.umutt.dto.LoginRequest;
import org.umutt.dto.RegistrationDto;
import org.umutt.dto.UserDto;
import org.umutt.jpa.model.Registrations;
import org.umutt.jpa.model.User;
import org.umutt.jpa.repo.RegistrationsRepo;
import org.umutt.jpa.repo.UserRepo;

@Component
public class UmuttSpringService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RegistrationsRepo regRepo;
	
	@Transactional
	public UserDto saveUser(UserDto dto) {
		return dto;
	}
	
	public UserDto getUser(LoginRequest loginRequest) {
		User user = repo.getUser(loginRequest.getUsername(), loginRequest.getPassword());
		if (null ==  user) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setUserId(user.getUserId());
		dto.setRole(user.getRole());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		return dto;
	}
	
	@Transactional
	public RegistrationDto register(RegistrationDto dto) {
		Registrations model = new Registrations();
		convertDto2Model(dto , model);
		regRepo.save(model);
		return dto;
	}
	
	@Transactional
	public List<RegistrationDto> getRegistrationByVolunteer(String userId) {
		
		List<RegistrationDto> list = new ArrayList<>();
		List<Registrations> registrations = regRepo.findByVolunteer(userId);
		for (Registrations reg : registrations) {
			list.add(convertModel2Dto(new RegistrationDto(), reg));
		}
		return list;
	}

	private void convertDto2Model(RegistrationDto dto, Registrations model) {
		model.setFullName(dto.getName());
		model.setAddress(dto.getAddress());
		model.setLocality(dto.getArea());
		model.setCity(dto.getCity());
		model.setState(dto.getState());
		model.setPhone(dto.getPhone());
		model.setEmail(dto.getEmail());
		model.setSubscribed(null!=dto.getSubscribeForUpdates() ? dto.getSubscribeForUpdates().booleanValue() : false);
		model.setCreatedBy(dto.getVolunteer().getUserId());
	}
	
	private RegistrationDto convertModel2Dto(RegistrationDto dto, Registrations model) {
		dto.setName(model.getFullName());
		dto.setAddress(model.getAddress());
		dto.setArea(model.getLocality());
		dto.setCity(model.getCity());
		dto.setState(model.getState());
		dto.setPhone(model.getPhone());
		dto.setEmail(model.getEmail());
		UserDto volunteer = new UserDto();
		volunteer.setFirstName(model.getCreatedBy());
		dto.setVolunteer(volunteer);
		dto.setSubscribeForUpdates(model.isSubscribed());
		return dto;
	}
	
}
