package com.codemonkeys.carmechanicbackend.user.dto;

import lombok.Data;

@Data
public class UserLoginDto {

	private String username;
	private String password;
	
	public UserLoginDto() {}
}
