package com.auto_mechanic.auto_mechanic_api.user.service;

import com.auto_mechanic.auto_mechanic_api.user.dto.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserListDto;
import com.auto_mechanic.auto_mechanic_api.user.mapper.UserMapper;
import com.auto_mechanic.auto_mechanic_api.user.model.Role;
import com.auto_mechanic.auto_mechanic_api.user.model.User;
import com.auto_mechanic.auto_mechanic_api.user.repository.RoleRepository;
import com.auto_mechanic.auto_mechanic_api.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;
	
	private final UserMapper userMapper;
	
	private final PasswordEncoder passEncryptor;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passEncryptor) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userMapper = userMapper;
		this.passEncryptor = passEncryptor;
	}

	public ResponseEntity<List<UserListDto>> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(userMapper.toDtoList(users));
	}

	public ResponseEntity<UserDto> getUser(Long id) {
		
		User user = userRepository.findById(id).get();
		
		return ResponseEntity.ok(userMapper.toDto(user));
	}

	public ResponseEntity<Void> addUser(NewUserDto newUser) {
		Role adminRole = roleRepository.findByName(RolesConstants.ADMIN).get();
		User user = userMapper.toNewEntity(newUser, adminRole);
		user.setPassword(passEncryptor.encode(user.getPassword()));
		userRepository.save(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editUser(Long id, UserEditDto userEditDto) {
		
		User user = userRepository.findById(id).get();

		if(userEditDto.getPassword() != null) {
			user.setPassword(passEncryptor.encode(userEditDto.getPassword()));
		}

		userMapper.updateEntity(userEditDto, user);
		userRepository.save(user);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
