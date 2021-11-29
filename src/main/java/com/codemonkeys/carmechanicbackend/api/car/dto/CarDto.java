package com.codemonkeys.carmechanicbackend.api.car.dto;

import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;

import lombok.Data;

@Data
public class CarDto {
	
	private Long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	private List<RepairDto> repairDtoList;

}
