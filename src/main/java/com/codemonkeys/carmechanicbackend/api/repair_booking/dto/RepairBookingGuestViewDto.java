package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarGuestViewDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientGuestViewDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairGuestViewDto;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RepairBookingGuestViewDto {

	private LocalDateTime date;
	private RepairStatusEnum status;
	private ClientGuestViewDto client;
	private CarGuestViewDto car;
	private List<RepairGuestViewDto> repairs;
	private Long totalPrice;
	
}
