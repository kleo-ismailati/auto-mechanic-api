package com.codemonkeys.carmechanicbackend.api.car.dto;

import lombok.Data;

@Data
public class CarDto {
	
	private Long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;

}
