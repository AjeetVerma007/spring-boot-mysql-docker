package com.lichfl.service;

import java.util.List;

import com.lichfl.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();

}
