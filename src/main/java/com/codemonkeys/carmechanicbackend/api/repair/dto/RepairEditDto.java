package com.codemonkeys.carmechanicbackend.api.repair.dto;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RepairEditDto {
	
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	@ApiModelProperty(dataType = "java.lang.Integer")
	private RepairStatusEnum repairStatus;

}
