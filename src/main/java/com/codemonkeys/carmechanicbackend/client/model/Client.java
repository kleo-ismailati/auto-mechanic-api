package com.codemonkeys.carmechanicbackend.client.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Client {
	
	@Id
	private String id;
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
	
	public Client() {}

	public Client(String id, String firstName, String lastName, String email, String phoneNumber, String address, String car,
			String carDescription, String repairCost, String repairDetails, String repairStatus) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.car = car;
		this.carDescription = carDescription;
		this.repairCost = repairCost;
		this.repairDetails = repairDetails;
		this.repairStatus = repairStatus;
	}

}
