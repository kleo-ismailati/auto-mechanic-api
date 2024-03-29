package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RepairCreateDto {

    @NotEmpty(message = "Please enter repair type")
    @Size(min = 3, max = 30)
    private String repairType;

    @NotEmpty(message = "Please enter repair details")
    @Size(min = 3, max = 200)
    private String repairDetails;

    @Min(0)
    @Max(99999)
    private Long repairCost;

    public RepairCreateDto(String repairType, String repairDetails, Long repairCost) {
        this.repairType = repairType.trim();
        this.repairDetails = repairDetails.trim();
        this.repairCost = repairCost;
    }

}
