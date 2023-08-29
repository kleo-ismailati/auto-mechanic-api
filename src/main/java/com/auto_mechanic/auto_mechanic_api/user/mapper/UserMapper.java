package com.auto_mechanic.auto_mechanic_api.user.mapper;

import java.util.ArrayList;
import java.util.List;

import com.auto_mechanic.auto_mechanic_api.user.dto.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserListDto;
import org.springframework.stereotype.Service;

import com.auto_mechanic.auto_mechanic_api.user.model.User;

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
