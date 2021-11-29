package com.codemonkeys.carmechanicbackend.api.client.dto;

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;

import lombok.Data;

@Data
public class NewClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private NewCarDto carDto;
	
}
