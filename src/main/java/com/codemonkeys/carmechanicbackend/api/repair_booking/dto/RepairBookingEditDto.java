package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import lombok.Data;

@Data
public class RepairBookingEditDto {
	
	private String date;
	private Long totalPrice;
	private String status;
	
}
