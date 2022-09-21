package com.codemonkeys.car_mechanic.api.dto.car.car_edit;

import lombok.Data;

@Data
public class CarEditDto {

	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;

}
