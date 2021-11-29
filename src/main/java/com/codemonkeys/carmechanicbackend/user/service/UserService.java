package com.codemonkeys.carmechanicbackend.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.exception.ResourceNotFoundException;
import com.codemonkeys.carmechanicbackend.security.service.PasswordService;
import com.codemonkeys.carmechanicbackend.user.dto.UserDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserListDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserMapper;
import com.codemonkeys.carmechanicbackend.user.dto.NewUserDto;
import com.codemonkeys.carmechanicbackend.user.model.User;
import com.codemonkeys.carmechanicbackend.user.repository.UserRepository;

@Service
public class UserService {
	

	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	private PasswordService passEncrypter;
	
	public UserService(UserRepository userRepository, UserMapper userMapper, PasswordService passEncrypter) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passEncrypter = passEncrypter;
	}

	public ResponseEntity<List<UserListDto>> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(userMapper.toDtoList(users));
	}

	public ResponseEntity<UserListDto> getUser(Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found!"));
		return ResponseEntity.ok(userMapper.toDto(user));
	}

	public ResponseEntity<Void> addUser(NewUserDto newUser) {
		
		User user = userMapper.toNewEntity(newUser);
		user.setPassword(passEncrypter.encryptPassword(user.getPassword()));
		userRepository.save(user);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editUser(Long id, UserDto userDto) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found!"));
		
		userMapper.updateEntity(userDto, user);
		userRepository.save(user);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
