package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarRBListItemDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientRBListItemDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairRBListItemDto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairBookingListItemDto {
	
	private Long id;
	private LocalDateTime date;
	private RepairStatusEnum status;
	private ClientRBListItemDto client;
	private CarRBListItemDto car;
	private List<RepairRBListItemDto> repairs;
	private Long totalPrice;
	
}
