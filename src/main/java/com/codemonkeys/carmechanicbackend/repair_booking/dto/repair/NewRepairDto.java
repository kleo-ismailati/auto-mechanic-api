package com.codemonkeys.carmechanicbackend.repair_booking.dto.repair;

import lombok.Data;

@Data
public class NewRepairDto {
	
	private String repairType;
	private String repairDetails;
	private String repairCost;

}
