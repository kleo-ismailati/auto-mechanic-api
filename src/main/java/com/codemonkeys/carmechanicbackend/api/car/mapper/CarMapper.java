package com.codemonkeys.carmechanicbackend.api.car.mapper;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.CarViewDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.repair.mapper.RepairMapper;

@Service
public class CarMapper {
	
	private RepairMapper repairMapper;
	
	public CarMapper(RepairMapper repairMapper) {
		this.repairMapper = repairMapper;
	}



	public Car toNewEntity(NewCarDto carDto) {
		
		Car carEntity = new Car();
		
		carEntity.setCarType(carDto.getCarType());
		carEntity.setCarModel(carDto.getCarModel());
		carEntity.setYear(carDto.getYear());
		carEntity.setColor(carDto.getColor());
		carEntity.setCarDescription(carDto.getCarDescription());
		carEntity.setRepairs(
				repairMapper.toNewEntityList(carDto.getRepairDtoList(), carEntity)
				);
		
		return carEntity;
	}
	
	public Car toEntity(CarDto carDto) {
		
		Car carEntity = new Car();
		
		if(carDto.getCarType() != null) {
			carEntity.setCarType(carDto.getCarType());
		}
		
		if(carDto.getCarModel() != null) {
			carEntity.setCarModel(carDto.getCarModel());
		}
		
		if(carDto.getYear() != null) {
			carEntity.setYear(carDto.getYear());
		}
		
		if(carDto.getColor() != null) {
			carEntity.setColor(carDto.getColor());
		}
		
		if(carDto.getCarDescription() != null) {
			carEntity.setCarDescription(carDto.getCarDescription());
		}
		
		if(carDto.getRepairDtoList() != null) {
			carEntity.setRepairs(
					repairMapper.toEntityList(carEntity, carDto.getRepairDtoList())
					);
		}
		
		return carEntity;
	}



	public CarViewDto toViewDto(Car car) {
		
		CarViewDto carViewDto = new CarViewDto();
		
		if(car.getCarModel() != null) {
			carViewDto.setCarModel(car.getCarModel());
		}
		
		if(car.getCarType() != null) {
			carViewDto.setCarType(car.getCarType());
		}
		
		if(car.getRepairs() != null) {
			carViewDto.setRepairViewDtoList(
					repairMapper.toViewDtoList(car.getRepairs())
					);
		}
		
		return carViewDto;
	}



	public CarDto toDto(Car car) {
		
		CarDto carDto = new CarDto();
		
		if(car.getId() != null) {
			carDto.setId(car.getId());
		}
		
		if(car.getYear() != null) {
			carDto.setYear(car.getYear());
		}
		
		if(car.getCarDescription() != null) {
			carDto.setCarDescription(car.getCarDescription());
		}
		
		if(car.getColor() != null) {
			carDto.setColor(car.getColor());
		}
		
		if(car.getCarModel() != null) {
			carDto.setCarModel(car.getCarModel());
		}
		
		if(car.getCarType() != null) {
			carDto.setCarType(car.getCarType());
		}
		
		if(car.getRepairs() != null) {
			carDto.setRepairDtoList(
					repairMapper.toDtoList(car.getRepairs())
					);
		}
		
		return carDto;
	}



	public Car updateEntity(CarDto carDto, Car car) {
		
		if(carDto.getCarType() != null) {
			car.setCarType(carDto.getCarType());
		}
		
		if(carDto.getCarModel() != null) {
			car.setCarModel(carDto.getCarModel());
		}
		
		if(carDto.getYear() != null) {
			car.setYear(carDto.getYear());
		}
		
		if(carDto.getColor() != null) {
			car.setColor(carDto.getColor());
		}
		
		if(carDto.getCarDescription() != null) {
			car.setCarDescription(carDto.getCarDescription());
		}
		
		if(carDto.getRepairDtoList() != null) {
			car.setRepairs(
					repairMapper.updateEntityList(car, carDto.getRepairDtoList())
					);
		}
		
		return car;
	}

}
