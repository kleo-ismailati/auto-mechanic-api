package com.codemonkeys.carmechanicbackend.api.dto.repair_booking.repair_booking_edit;

import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RepairBookingEditDto {

	@ApiModelProperty(dataType = "java.lang.Integer")
	private RepairStatusEnum status;
	
}
