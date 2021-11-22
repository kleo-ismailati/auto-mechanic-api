package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.repair_booking.model.Car;

@Service
public class CarMapper {
	
	private RepairMapper repairMapper;
	
	public CarMapper(RepairMapper repairMapper) {
		this.repairMapper = repairMapper;
	}



	public Car toNewEntity(NewCarDto carDto) {
		
		Car carEntity = new Car();
		
		carEntity.setId(new ObjectId().toString());
		
		carEntity.setCarType(carDto.getCarType());
		carEntity.setCarModel(carDto.getCarModel());
		carEntity.setYear(carDto.getYear());
		carEntity.setColor(carDto.getColor());
		carEntity.setCarDescription(carDto.getCarDescription());
		carEntity.setRepairs(
				repairMapper.toNewEntityList(carDto.getRepairs())
				);
		
		return carEntity;
	}

}
