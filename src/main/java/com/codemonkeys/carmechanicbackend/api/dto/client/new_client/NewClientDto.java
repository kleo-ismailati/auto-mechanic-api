package com.codemonkeys.carmechanicbackend.api.dto.client.new_client;

import lombok.Data;

@Data
public class NewClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	
}
