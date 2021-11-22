package com.codemonkeys.carmechanicbackend.repair_booking.dto.client;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.car.CarDto;

import lombok.Data;

@Data
public class ClientDto {
	

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private CarDto carDto;
	
}
