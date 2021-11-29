package com.codemonkeys.carmechanicbackend.user.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.user.model.User;

@Service
public class UserMapper {

	public User toNewEntity(NewUserDto newUser) {
		
		User userEntity = new User();
		
		userEntity.setUsername(newUser.getUsername());
		userEntity.setEmail(newUser.getEmail());
		userEntity.setPassword(newUser.getPassword());
		userEntity.setRole("ADMIN");
		
		return userEntity;
	}
	
	public User toEntity(Long id, UserDto userDto) {
		
		User userEntity = new User();
		
		userEntity.setId(id);
		
		if(userDto.getUsername() != null) {
			userEntity.setUsername(userDto.getUsername());
		}
		
		if(userDto.getEmail() != null) {
			userEntity.setEmail(userDto.getEmail());
		}
		
		if(userDto.getPassword() != null) {
			userEntity.setPassword(userDto.getPassword());
		}
		
		return userEntity;
	}

	public UserListDto toDto(User user) {
		
		UserListDto userDto = new UserListDto();
		
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		
		return userDto;
	}
	
	public List<UserListDto> toDtoList(List<User> users) {
		
		List<UserListDto> userDtoList = new ArrayList<UserListDto> ();
		
		for(User user : users) {
			userDtoList.add(toDto(user));
		}
		
		return userDtoList;
	}
	
	public User updateEntity(UserDto userDto, User userEntity) {
		
		
		if(userDto.getUsername() != null) {
			userEntity.setUsername(userDto.getUsername());
		}
		
		if(userDto.getEmail() != null) {
			userEntity.setEmail(userDto.getEmail());
		}
		
		if(userDto.getPassword() != null) {
			userEntity.setPassword(userDto.getPassword());
		}
		
		return userEntity;
	}

}
