package com.codemonkeys.car_mechanic.api.dto.repair.repair_edit;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
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
