package com.codemonkeys.car_mechanic.api.dto.repair_booking;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairForRepairBookingDto {
	
	private Long id;
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private RepairStatusEnum repairStatus;
}
