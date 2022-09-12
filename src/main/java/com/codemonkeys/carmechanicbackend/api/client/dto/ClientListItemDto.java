package com.codemonkeys.carmechanicbackend.api.client.dto;

import lombok.Data;


@Data
public class ClientListItemDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
}
