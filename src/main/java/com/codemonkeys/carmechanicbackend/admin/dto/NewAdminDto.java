package com.codemonkeys.carmechanicbackend.admin.dto;

import lombok.Data;

@Data
public class NewAdminDto {
	
	private String username;
	private String email;
	private String password;

	public NewAdminDto() {}
}
