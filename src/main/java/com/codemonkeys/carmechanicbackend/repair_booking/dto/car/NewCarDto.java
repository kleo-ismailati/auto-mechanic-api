package com.codemonkeys.carmechanicbackend.repair_booking.dto.car;

import java.util.List;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.NewRepairDto;

import lombok.Data;

@Data
public class NewCarDto {
	
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	private List<NewRepairDto> repairDtoList;

}
