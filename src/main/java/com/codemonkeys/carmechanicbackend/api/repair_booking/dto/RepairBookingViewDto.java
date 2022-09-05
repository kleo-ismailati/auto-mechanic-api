package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarViewDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientViewDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairBookingViewDto {
	
	private Long id;
	private LocalDateTime date;
	private RepairStatusEnum status;
	private ClientViewDto client;
	private CarViewDto car;
	private List<RepairViewDto> repairs;
	private Long totalPrice;
	
}
