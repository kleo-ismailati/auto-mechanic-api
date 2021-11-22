package com.codemonkeys.carmechanicbackend.repair_booking.dto.client;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.car.NewCarDto;

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
