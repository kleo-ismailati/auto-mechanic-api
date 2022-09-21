package com.codemonkeys.car_mechanic.api.dto.client;

import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private List<CarClientListItemDto> cars;
	
}
