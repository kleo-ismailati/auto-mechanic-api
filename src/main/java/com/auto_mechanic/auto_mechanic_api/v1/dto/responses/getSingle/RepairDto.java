package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairDto {

    private Long id;
    private String repairType;
    private String repairDetails;
    private Long repairCost;
    private RepairStatusEnum repairStatus;
}
