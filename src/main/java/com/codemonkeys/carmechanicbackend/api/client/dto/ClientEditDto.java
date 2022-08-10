package com.codemonkeys.carmechanicbackend.api.client.dto;

import lombok.Data;

@Data
public class ClientEditDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	
}
