package com.codemonkeys.carmechanicbackend.api.dto.car.new_car;

import lombok.Data;

@Data
public class NewCarDto {
	
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
}
