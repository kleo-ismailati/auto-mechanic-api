package com.codemonkeys.carmechanicbackend.client.dto;

import lombok.Data;

@Data
public class ClientDto {
	
	private String firstName;
	private String lastName;
	private String car;
	private String carDescription;
	private String repairCost;
	private String repairDetails;
	private String repairStatus;
	
	public ClientDto() {
		
	}
}
