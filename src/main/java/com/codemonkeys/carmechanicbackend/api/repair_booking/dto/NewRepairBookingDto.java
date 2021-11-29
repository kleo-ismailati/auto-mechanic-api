package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;

import lombok.Data;

@Data
public class NewRepairBookingDto {
	
	private NewClientDto clientDto;
	private String date;
	private String totalPrice;
	private String status;
	
}
