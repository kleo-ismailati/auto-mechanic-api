package com.auto_mechanic.auto_mechanic_api.api.dto.repair.repair_edit;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class RepairEditDto {

    @NotEmpty(message = "Please enter repair type")
    @Size(min = 3, max = 30)
    private String repairType;

    @NotEmpty(message = "Please enter repair details")
    @Size(min = 3, max = 200)
    private String repairDetails;

    @Min(0)
    @Max(99999)
    private Long repairCost;

    @ApiModelProperty(dataType = "java.lang.Integer")
    private RepairStatusEnum repairStatus;

    public RepairEditDto(
            String repairType,
            String repairDetails,
            Long repairCost,
            RepairStatusEnum repairStatus
    ) {
        this.repairType = repairType.trim();
        this.repairDetails = repairDetails.trim();
        this.repairCost = repairCost;
        this.repairStatus = repairStatus;
    }
}
