package com.codemonkeys.carmechanicbackend.repair_booking.dto.client;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.car.CarViewDto;

import lombok.Data;

@Data
public class ClientViewDto {
	
	private String firstName;
	private String lastName;
	private CarViewDto carViewDto;
	
}
