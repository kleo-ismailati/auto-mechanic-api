package com.codemonkeys.carmechanicbackend.repair_booking.dto.car;

import java.util.List;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.RepairViewDto;

import lombok.Data;

@Data
public class CarViewDto {
	
	private String carType;
	private String carModel;
	private List<RepairViewDto> repairViewDtoList;
	
}
