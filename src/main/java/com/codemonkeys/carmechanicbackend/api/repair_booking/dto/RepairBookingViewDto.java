package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;

import lombok.Data;

@Data
public class RepairBookingViewDto {
	
	private String date;
	private String status;
	private List<RepairViewDto> repairs;
	
}
