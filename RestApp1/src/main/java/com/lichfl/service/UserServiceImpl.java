package com.lichfl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichfl.dto.UserDto;
import com.lichfl.entity.User;
import com.lichfl.exception.UserNotFoundException;
import com.lichfl.repo.UserRepository;
import com.lichfl.util.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		// User user = UserMapper.mapToUser(userDto);
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);

		UserDto savedUserDto = UserMapper.mapToUserDto(user);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {

		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User does not exists for the provided ID");
		}

		// UserDto userDto = UserMapper.mapToUserDto(optionalUser.get());
		UserDto userDto = modelMapper.map(optionalUser.get(), UserDto.class);

		return userDto;
	}

	public List<UserDto> getAllUsers() {

		List<User> users = userRepository.findAll();

//		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> (modelMapper.map(user, UserDto.class))).collect(Collectors.toList());

	}

}
