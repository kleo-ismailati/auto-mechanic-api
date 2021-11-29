package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;


import com.codemonkeys.carmechanicbackend.api.client.dto.ClientViewDto;

import lombok.Data;

@Data
public class RepairBookingViewDto {
	
	private Long id;
	private ClientViewDto clientViewDto;
	private String date;
	private String status;
	
}
