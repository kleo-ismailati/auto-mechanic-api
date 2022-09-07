package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RepairBookingEditDto {

	@ApiModelProperty(dataType = "java.lang.Integer")
	private RepairStatusEnum status;
	
}
