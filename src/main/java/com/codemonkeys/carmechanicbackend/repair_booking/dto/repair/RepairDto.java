package com.codemonkeys.carmechanicbackend.repair_booking.dto.repair;

import lombok.Data;

@Data
public class RepairDto {
	
	private String id;
	private String repairType;
	private String repairDetails;
	private String repairCost;
	private String repairStatus;

}
