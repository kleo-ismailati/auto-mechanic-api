package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.UserListItemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UserListItemDto>> getAllUsers();

    ResponseEntity<UserDto> getUser(Long id);

    ResponseEntity<Void> addUser(NewUserDto newUser);

    ResponseEntity<Void> deleteUser(Long id);

    ResponseEntity<Void> editUser(Long id, UserEditDto userEditDto);
}
