package com.codemonkeys.carmechanicbackend.api.repair.dto;

import lombok.Data;

@Data
public class RepairEditDto {
	
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private String repairStatus;

}
