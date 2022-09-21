package com.codemonkeys.carmechanicbackend.api.dto.car;

import lombok.Data;

@Data
public class CarDto {

	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;

}
