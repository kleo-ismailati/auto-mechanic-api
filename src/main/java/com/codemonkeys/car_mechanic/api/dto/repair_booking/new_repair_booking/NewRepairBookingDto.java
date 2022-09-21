package com.codemonkeys.car_mechanic.api.dto.repair_booking.new_repair_booking;

import java.util.List;

import lombok.Data;

@Data
public class NewRepairBookingDto {
	
	private Long clientId;
	private Long carId;
	private List<NewRepairDto> repairs;
	private Long totalPrice;
	
}
