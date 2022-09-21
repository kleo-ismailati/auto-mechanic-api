package com.codemonkeys.carmechanicbackend.api.dto.repair_booking.new_repair_booking;

import lombok.Data;

@Data
public class NewRepairDto {
	
	private String repairType;
	private String repairDetails;
	private Long repairCost;

}
