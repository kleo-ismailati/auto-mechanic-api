package com.codemonkeys.carmechanicbackend.api.repair.dto;

import lombok.Data;

@Data
public class RepairEditDto {
	
	private String repairType;
	private String repairDetails;
	private String repairCost;
	private String repairStatus;

}
