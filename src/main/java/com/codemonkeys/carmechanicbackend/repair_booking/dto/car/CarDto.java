package com.codemonkeys.carmechanicbackend.repair_booking.dto.car;

import java.util.List;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.RepairDto;

import lombok.Data;

@Data
public class CarDto {
	
	private String id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	private List<RepairDto> repairDtoList;

}
