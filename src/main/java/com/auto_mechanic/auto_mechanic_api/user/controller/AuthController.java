package com.auto_mechanic.auto_mechanic_api.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.auto_mechanic.auto_mechanic_api.security.jwt.JwtUtils;
import com.auto_mechanic.auto_mechanic_api.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto_mechanic.auto_mechanic_api.user.dto.LoggedUserDto;
import com.auto_mechanic.auto_mechanic_api.user.dto.UserLoginDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication Controller")
public class AuthController {
	

	private AuthenticationManager authenticationManager;

	private JwtUtils jwtUtils;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
	}
	
	public AuthController() {
	}
	
	@PostMapping("/login")
	@Operation(summary = "Authenticate", tags = {
			"Auth" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "User authenticated successfully") 
	  })
	public ResponseEntity<LoggedUserDto> authenticateUser(@RequestBody UserLoginDto userLogin) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new LoggedUserDto(
						jwt, 
						userDetails.getId(), 
						userDetails.getUsername(), 
						userDetails.getEmail(), 
						roles
						)
				);
	}

}
