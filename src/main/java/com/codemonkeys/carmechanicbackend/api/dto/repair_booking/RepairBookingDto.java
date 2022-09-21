package com.codemonkeys.carmechanicbackend.api.dto.repair_booking;

import java.time.LocalDateTime;
import java.util.List;


import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairBookingDto {

	private ClientRBDto client;
	private CarRBDto car;
	private List<RepairRBDto> repairs;
	private LocalDateTime date;
	private Long totalPrice;
	private RepairStatusEnum status;
	
}
