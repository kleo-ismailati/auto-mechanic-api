package com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking;


import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.ClientDto;

import lombok.Data;

@Data
public class RepairBookingDto {
	
	private String id;
	private ClientDto clientDto;
	private String date;
	private String totalPrice;
	private String status;
	
}
