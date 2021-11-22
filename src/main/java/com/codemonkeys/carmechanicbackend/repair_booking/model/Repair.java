package com.codemonkeys.carmechanicbackend.repair_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Repair {
	
	@Id
	private String id;
	private String repairType;
	private String repairDetails;
	private String repairCost;
	private String repairStatus;
	
	public Repair() {
	}

	public Repair(String id, String repairName, String repairDetails, String repairCost, 
			String repairStatus) {
		this.id = id;
		this.repairType = repairName;
		this.repairDetails = repairDetails;
		this.repairCost = repairCost;
		this.repairStatus = repairStatus;
	}

}
