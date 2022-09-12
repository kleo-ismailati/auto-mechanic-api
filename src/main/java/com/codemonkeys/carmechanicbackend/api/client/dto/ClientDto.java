package com.codemonkeys.carmechanicbackend.api.client.dto;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {
	

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private List<CarDto> carDtoList;
	
}
