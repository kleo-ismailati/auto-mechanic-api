package com.codemonkeys.carmechanicbackend.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.user.dto.UserDto;
import com.codemonkeys.carmechanicbackend.user.dto.UserListDto;
import com.codemonkeys.carmechanicbackend.user.dto.NewUserDto;
import com.codemonkeys.carmechanicbackend.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User Controller")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@Operation(summary = "Get all Users", tags = { "User" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Users List found"),
	  @ApiResponse(responseCode = "404", description = "Users List not found") 
	  })
	public ResponseEntity<List<UserListDto>> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get User by id", tags = { "User" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "User found"),
	  @ApiResponse(responseCode = "404", description = "User not found") 
	  })
	public ResponseEntity<UserListDto> getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	@PostMapping
	@Operation(summary = "Add new User", tags = { "User" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "User added successfully") 
	  })
	public ResponseEntity<Void> addUser(@RequestBody NewUserDto newUser) {
		return userService.addUser(newUser);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update User by id", tags = { "User" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "User updated successfully"),
	  @ApiResponse(responseCode = "404", description = "User not found") 
	  })
	public ResponseEntity<Void> editUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
		return userService.editUser(id, userDto);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete User by id", tags = { "User" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "204", description = "User deleted successfully"),
	  @ApiResponse(responseCode = "404", description = "User not found") 
	  })
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}
}
