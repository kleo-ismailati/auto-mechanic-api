package com.codemonkeys.carmechanicbackend.api.car.dto;

import java.util.List;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;

import lombok.Data;

@Data
public class CarViewDto {
	
	private String carType;
	private String carModel;
	private List<RepairViewDto> repairViewDtoList;
	
}
