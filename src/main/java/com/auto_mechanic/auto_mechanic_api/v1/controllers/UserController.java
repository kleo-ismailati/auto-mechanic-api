package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.UserCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.UserUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.UserItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users Controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User list found"),
            @ApiResponse(responseCode = "404", description = "User list not found")
    })
    public ResponseEntity<List<UserItemDto>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get user by id", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    @Operation(summary = "Add new user", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User added successfully")
    })
    public ResponseEntity<Void> addUser(@Valid @RequestBody UserCreateDto newUser) {
        return userService.addUser(newUser);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update user by id", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> editUser(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        return userService.editUser(id, userUpdateDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete user by id", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
}
