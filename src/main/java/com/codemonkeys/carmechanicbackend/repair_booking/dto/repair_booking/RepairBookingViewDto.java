package com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking;


import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.ClientViewDto;

import lombok.Data;

@Data
public class RepairBookingViewDto {
	
	private String id;
	private ClientViewDto clientViewDto;
	private String date;
	private String status;
	
}
