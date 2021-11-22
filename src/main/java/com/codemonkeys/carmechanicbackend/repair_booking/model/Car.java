package com.codemonkeys.carmechanicbackend.repair_booking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Car {
	
	@Id
	private String id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	private List<Repair> repairs;
	
	public Car() {}

	public Car(String id, String carType, String carModel, String year, 
			String color, String carDescription, List<Repair> repairs) {
		this.id = id;
		this.carType = carType;
		this.carModel = carModel;
		this.year = year;
		this.color = color;
		this.carDescription = carDescription;
		this.repairs = repairs;
	}

}
