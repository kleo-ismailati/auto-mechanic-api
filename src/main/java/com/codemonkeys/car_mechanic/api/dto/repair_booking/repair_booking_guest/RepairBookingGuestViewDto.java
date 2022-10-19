package com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
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