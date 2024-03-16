package com.auto_mechanic.auto_mechanic_api.api.dto.repair;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairDto {

    private Long id;
    private String repairType;
    private String repairDetails;
    private Long repairCost;
    private RepairStatusEnum repairStatus;
}
