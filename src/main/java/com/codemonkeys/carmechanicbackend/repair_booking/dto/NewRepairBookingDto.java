package com.codemonkeys.carmechanicbackend.repair_booking.dto;

import lombok.Data;

@Data
public class NewRepairBookingDto {
	
	private NewClientDto client;
	private String date;
	private String totalPrice;
	private String status;
	
	public NewRepairBookingDto() {
		
	}
}
