package com.codemonkeys.carmechanicbackend.api.dto.repair.repair_edit;

import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;
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
