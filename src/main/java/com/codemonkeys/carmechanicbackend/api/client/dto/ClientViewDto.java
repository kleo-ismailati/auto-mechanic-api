package com.codemonkeys.carmechanicbackend.api.client.dto;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarViewDto;

import lombok.Data;

@Data
public class ClientViewDto {
	
	private String firstName;
	private String lastName;
	private CarViewDto carViewDto;
	
}
