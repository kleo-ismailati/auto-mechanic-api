package com.codemonkeys.carmechanicbackend.repair_booking.dto;

import java.util.List;

import lombok.Data;

@Data
public class NewCarDto {
	
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	private List<NewRepairDto> repairs;
	
	public NewCarDto() {
	}

}
