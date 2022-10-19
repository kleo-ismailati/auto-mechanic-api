package com.codemonkeys.car_mechanic.api.dto.client.client_list;

import lombok.Data;


@Data
public class ClientListItemDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
}