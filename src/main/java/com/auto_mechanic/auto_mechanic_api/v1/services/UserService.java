package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.UserCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.UserUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.UserItemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UserItemDto>> getAllUsers();

    ResponseEntity<UserDto> getUser(Long id);

    ResponseEntity<Void> addUser(UserCreateDto newUser);

    ResponseEntity<Void> deleteUser(Long id);

    ResponseEntity<Void> editUser(Long id, UserUpdateDto userUpdateDto);
}
