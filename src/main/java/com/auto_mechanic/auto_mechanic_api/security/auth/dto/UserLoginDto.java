package com.auto_mechanic.auto_mechanic_api.security.auth.dto;

import lombok.Data;

@Data
public class UserLoginDto {

	private String username;
	private String password;
	
}
