package com.codemonkeys.carmechanicbackend.client.dto;

import lombok.Data;

@Data
public class NewClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String car;
	private String carDescription;
	private String repairCost;
	private String repairDetails;
	private String repairStatus;
	
	public NewClientDto() {
		
	}
}
