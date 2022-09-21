package com.codemonkeys.car_mechanic.api.dto.client.client_list;

import lombok.Data;

import java.util.List;

@Data
public class ClientPageDto {

	private List<ClientListItemDto> result;
	private int pageNo;
	private int size;
	private int total;

}
