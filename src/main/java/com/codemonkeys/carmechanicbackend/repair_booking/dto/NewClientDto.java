package com.codemonkeys.carmechanicbackend.repair_booking.dto;

import lombok.Data;

@Data
public class NewClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private NewCarDto car;
	
	public NewClientDto() {
	}
}
