package com.auto_mechanic.auto_mechanic_api.user.mapper;

import com.auto_mechanic.auto_mechanic_api.user.dto.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserListDto;
import com.auto_mechanic.auto_mechanic_api.user.model.Role;
import com.auto_mechanic.auto_mechanic_api.user.model.User;
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

        List<UserListDto> userDtoList = new ArrayList<>();

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
