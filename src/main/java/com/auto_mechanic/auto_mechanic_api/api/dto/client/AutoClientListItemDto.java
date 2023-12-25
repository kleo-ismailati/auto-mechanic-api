package com.auto_mechanic.auto_mechanic_api.api.dto.client;

import lombok.Data;

@Data
public class AutoClientListItemDto {

	private long id;
	private String autoType;
	private String autoModel;
	private String year;
	private String color;

	private byte[] thumbnail;

}
