package com.auto_mechanic.auto_mechanic_api.api.dto.auto.new_auto;

import lombok.Data;

@Data
public class NewAutoDto {
	
	private String autoType;
	private String autoModel;
	private String year;
	private String color;
	private String autoDescription;
}
