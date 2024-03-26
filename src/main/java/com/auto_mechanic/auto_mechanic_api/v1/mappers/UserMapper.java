package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.UserCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.UserUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.UserItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Role;
import com.auto_mechanic.auto_mechanic_api.v1.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserMapper {

    public User toNewEntity(UserCreateDto newUser, Role adminRole) {

        User userEntity = new User();
        HashSet<Role> roles = new HashSet<>();
        roles.add(adminRole);

        userEntity.setUsername(newUser.getUsername());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setRoles(roles);

        return userEntity;
    }

    public UserItemDto toUserItemDto(User user) {

        UserItemDto userDto = new UserItemDto();

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

    public List<UserItemDto> toUserDtoList(List<User> users) {

        List<UserItemDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            userDtoList.add(toUserItemDto(user));
        }

        return userDtoList;
    }

    public User updateEntity(UserUpdateDto userUpdateDto, User userEntity) {


        if (userUpdateDto.getUsername() != null) {
            userEntity.setUsername(userUpdateDto.getUsername());
        }

        if (userUpdateDto.getEmail() != null) {
            userEntity.setEmail(userUpdateDto.getEmail());
        }

        return userEntity;
    }

}
