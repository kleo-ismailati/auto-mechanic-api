package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_guest;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairGuestViewDto {

    private String repairType;
    private String repairDetails;
    private Long repairCost;
    private RepairStatusEnum repairStatus;

}
