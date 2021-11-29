package com.codemonkeys.carmechanicbackend.user.admin.dto;

import lombok.Data;

@Data
public class AdminDto {
	
	private String username;
	private String email;
	private String password;

	public AdminDto() {}
}
