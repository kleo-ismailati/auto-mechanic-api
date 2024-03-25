package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.UserLoginDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.LoggedUserDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication Controller")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate", tags = {
            "Auth"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User authenticated successfully")
    })
    public ResponseEntity<LoggedUserDto> authenticateUser(@RequestBody UserLoginDto userLogin) {

        LoggedUserDto loggedUserDto = authService.authenticateUser(userLogin.getUsername(), userLogin.getPassword());

        return ResponseEntity.ok(loggedUserDto);
    }

}
