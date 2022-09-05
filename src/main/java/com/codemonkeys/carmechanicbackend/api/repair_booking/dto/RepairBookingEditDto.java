package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RepairBookingEditDto {
	
	private LocalDateTime date;
	private Long totalPrice;
	private RepairStatusEnum status;
	
}
