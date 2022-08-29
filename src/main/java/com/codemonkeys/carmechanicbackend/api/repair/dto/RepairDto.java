package com.codemonkeys.carmechanicbackend.api.repair.dto;

import lombok.Data;

@Data
public class RepairDto {
	
	private Long id;
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private String repairStatus;
	private Long rb_id;

}
