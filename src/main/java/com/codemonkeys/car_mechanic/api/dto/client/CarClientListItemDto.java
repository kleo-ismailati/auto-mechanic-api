package com.codemonkeys.car_mechanic.api.dto.client;

import lombok.Data;

@Data
public class CarClientListItemDto {

	private long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;

}