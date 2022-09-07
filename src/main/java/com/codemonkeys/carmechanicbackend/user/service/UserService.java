package com.codemonkeys.carmechanicbackend.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.user.dto.UserDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserListDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserMapper;
import com.codemonkeys.carmechanicbackend.user.dto.NewUserDto;
import com.codemonkeys.carmechanicbackend.user.model.User;
import com.codemonkeys.carmechanicbackend.user.repository.UserRepository;

@Service
public class UserService {
	

	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	private final PasswordEncoder passEncryptor;
	
	public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passEncryptor) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passEncryptor = passEncryptor;
	}

	public ResponseEntity<List<UserListDto>> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(userMapper.toDtoList(users));
	}

	public ResponseEntity<UserListDto> getUser(Long id) {
		
		User user = userRepository.findById(id).get();
		
		return ResponseEntity.ok(userMapper.toDto(user));
	}

	public ResponseEntity<Void> addUser(NewUserDto newUser) {
		
		User user = userMapper.toNewEntity(newUser);
		user.setPassword(passEncryptor.encode(user.getPassword()));
		userRepository.save(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editUser(Long id, UserDto userDto) {
		
		User user = userRepository.findById(id).get();
		
		userMapper.updateEntity(userDto, user);
		userRepository.save(user);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
