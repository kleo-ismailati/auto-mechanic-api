package com.codemonkeys.carmechanicbackend.user.admin.dto;

import lombok.Data;

@Data
public class AdminLoginDto {

	private String username;
	private String password;
	
	public AdminLoginDto() {}
}
