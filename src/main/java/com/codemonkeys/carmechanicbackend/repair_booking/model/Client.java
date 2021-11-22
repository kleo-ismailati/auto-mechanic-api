package com.codemonkeys.carmechanicbackend.repair_booking.model;

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
	private Car car;
	
	public Client() {}

	public Client(String id, String firstName, String lastName, 
			String email, String phoneNumber, String address, Car car) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.car = car;
	}

}
