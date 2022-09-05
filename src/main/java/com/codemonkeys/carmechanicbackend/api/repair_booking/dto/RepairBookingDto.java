package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairBookingDto {
	
	private Long id;
	private Long clientId;
	private Long carId;
	private List<RepairDto> repairs;
	private LocalDateTime date;
	private Long totalPrice;
	private RepairStatusEnum status;
	
}
