package com.codemonkeys.carmechanicbackend.api.dto.client;

import lombok.Data;

@Data
public class CarClientListItemDto {

	private long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;

}
