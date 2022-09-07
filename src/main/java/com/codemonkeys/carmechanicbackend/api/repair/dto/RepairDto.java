package com.codemonkeys.carmechanicbackend.api.repair.dto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairDto {
	
	private Long id;
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private RepairStatusEnum repairStatus;
}
