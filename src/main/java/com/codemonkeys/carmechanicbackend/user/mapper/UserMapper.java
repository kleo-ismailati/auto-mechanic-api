package com.codemonkeys.carmechanicbackend.user.mapper;

import java.util.ArrayList;
import java.util.List;

import com.codemonkeys.carmechanicbackend.user.dto.NewUserDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserEditDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserListDto;
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

	public UserListDto toListItemDto(User user) {
		
		UserListDto userDto = new UserListDto();

		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		
		return userDto;
	}

	public UserDto toDto(User user) {

		UserDto userDto = new UserDto();

		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());

		return userDto;
	}
	
	public List<UserListDto> toDtoList(List<User> users) {
		
		List<UserListDto> userDtoList = new ArrayList<> ();
		
		for(User user : users) {
			userDtoList.add(toListItemDto(user));
		}
		
		return userDtoList;
	}
	
	public User updateEntity(UserEditDto userEditDto, User userEntity) {
		
		
		if(userEditDto.getUsername() != null) {
			userEntity.setUsername(userEditDto.getUsername());
		}
		
		if(userEditDto.getEmail() != null) {
			userEntity.setEmail(userEditDto.getEmail());
		}
		
		return userEntity;
	}

}
