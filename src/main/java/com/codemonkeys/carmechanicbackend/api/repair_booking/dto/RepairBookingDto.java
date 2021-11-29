package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;


import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;

import lombok.Data;

@Data
public class RepairBookingDto {
	
	private Long id;
	private ClientDto clientDto;
	private String date;
	private String totalPrice;
	private String status;
	
}
