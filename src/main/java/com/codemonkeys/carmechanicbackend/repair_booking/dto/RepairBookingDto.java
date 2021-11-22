package com.codemonkeys.carmechanicbackend.repair_booking.dto;


import com.codemonkeys.carmechanicbackend.repair_booking.model.Client;

import lombok.Data;

@Data
public class RepairBookingDto {
	
	private Client client;
	private String date;
	private String totalPrice;
	private String status;
	
	public RepairBookingDto() {
		
	}
}
