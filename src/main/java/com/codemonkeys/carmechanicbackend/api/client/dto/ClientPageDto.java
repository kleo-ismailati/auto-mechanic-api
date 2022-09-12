package com.codemonkeys.carmechanicbackend.api.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientPageDto {

	private List<ClientListItemDto> result;
	private int pageNo;
	private int size;
	private int total;

}
