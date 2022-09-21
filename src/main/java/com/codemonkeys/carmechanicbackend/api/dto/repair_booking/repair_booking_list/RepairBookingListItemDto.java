package com.codemonkeys.carmechanicbackend.api.dto.repair_booking.repair_booking_list;

import java.time.LocalDateTime;
import java.util.List;

import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;
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
