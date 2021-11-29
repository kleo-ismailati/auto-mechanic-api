package com.codemonkeys.carmechanicbackend.user.dto;

import lombok.Data;

@Data
public class NewUserDto {
	
	private String username;
	private String email;
	private String password;

	public NewUserDto() {}
}
