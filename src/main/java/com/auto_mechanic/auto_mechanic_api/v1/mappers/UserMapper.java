package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.UserListItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Role;
import com.auto_mechanic.auto_mechanic_api.v1.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserMapper {

    public User toNewEntity(NewUserDto newUser, Role adminRole) {

        User userEntity = new User();
        HashSet<Role> roles = new HashSet<>();
        roles.add(adminRole);

        userEntity.setUsername(newUser.getUsername());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setRoles(roles);

        return userEntity;
    }

    public UserListItemDto toListItemDto(User user) {

        UserListItemDto userDto = new UserListItemDto();

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

    public List<UserListItemDto> toDtoList(List<User> users) {

        List<UserListItemDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            userDtoList.add(toListItemDto(user));
        }

        return userDtoList;
    }

    public User updateEntity(UserEditDto userEditDto, User userEntity) {


        if (userEditDto.getUsername() != null) {
            userEntity.setUsername(userEditDto.getUsername());
        }

        if (userEditDto.getEmail() != null) {
            userEntity.setEmail(userEditDto.getEmail());
        }

        return userEntity;
    }

}
