package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewUserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.UserEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.UserDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.UserListItemDto;
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
@RequestMapping("/user")
@Tag(name = "User", description = "User Controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all Users", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users List found"),
            @ApiResponse(responseCode = "404", description = "Users List not found")
    })
    public ResponseEntity<List<UserListItemDto>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get User by id", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    @Operation(summary = "Add new User", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User added successfully")
    })
    public ResponseEntity<Void> addUser(@Valid @RequestBody NewUserDto newUser) {
        return userService.addUser(newUser);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update User by id", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> editUser(@PathVariable("id") Long id, @Valid @RequestBody UserEditDto userEditDto) {
        return userService.editUser(id, userEditDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete User by id", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
}
