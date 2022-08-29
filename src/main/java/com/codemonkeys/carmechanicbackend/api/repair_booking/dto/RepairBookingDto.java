package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;

import lombok.Data;

@Data
public class RepairBookingDto {
	
	private Long id;
	private Long clientId;
	private Long carId;
	private List<RepairDto> repairs;
	private String date;
	private Long totalPrice;
	private String status;
	
}
