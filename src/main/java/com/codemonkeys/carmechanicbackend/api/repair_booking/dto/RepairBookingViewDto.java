package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.time.LocalDateTime;
import java.util.List;


import com.codemonkeys.carmechanicbackend.api.car.dto.CarRBViewDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientRBViewDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairBookingViewDto {

	private ClientRBViewDto client;
	private CarRBViewDto car;
	private List<RepairViewDto> repairs;
	private LocalDateTime date;
	private Long totalPrice;
	private RepairStatusEnum status;
	
}
