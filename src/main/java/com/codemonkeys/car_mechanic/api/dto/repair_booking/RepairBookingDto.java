package com.codemonkeys.car_mechanic.api.dto.repair_booking;

import java.time.LocalDateTime;
import java.util.List;


import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairBookingDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String carType;
	private String carModel;
	private List<RepairForRepairBookingDto> repairs;
	private LocalDateTime date;
	private Long totalPrice;
	private RepairStatusEnum status;
	
}
