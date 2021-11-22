package com.codemonkeys.carmechanicbackend.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.repair_booking.model.Car;

import lombok.Data;

@Data
public class ClientListDto {
	
	private String firstName;
	private String lastName;
	private Car car;
	
	public ClientListDto() {
		
	}
}
