package com.codemonkeys.carmechanicbackend.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.repair_booking.model.Car;

import lombok.Data;

@Data
public class ClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private Car car;
	
	public ClientDto() {
		
	}
}
