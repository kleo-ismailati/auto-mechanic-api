package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.NewRepairDto;

import lombok.Data;

@Data
public class NewRepairBookingDto {
	
	private Long clientId;
	private Long carId;
	private List<NewRepairDto> repairs;
	private Long totalPrice;
	
}
