package com.codemonkeys.carmechanicbackend.api.client.dto;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarClientListItemDto;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private List<CarClientListItemDto> cars;
	
}
