package com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.NewClientDto;

import lombok.Data;

@Data
public class NewRepairBookingDto {
	
	private NewClientDto clientDto;
	private String date;
	private String totalPrice;
	private String status;
	
}
