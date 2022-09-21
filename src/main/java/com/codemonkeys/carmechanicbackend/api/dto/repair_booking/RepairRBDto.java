package com.codemonkeys.carmechanicbackend.api.dto.repair_booking;

import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;

import lombok.Data;

@Data
public class RepairRBDto {
	
	private Long id;
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private RepairStatusEnum repairStatus;
}
