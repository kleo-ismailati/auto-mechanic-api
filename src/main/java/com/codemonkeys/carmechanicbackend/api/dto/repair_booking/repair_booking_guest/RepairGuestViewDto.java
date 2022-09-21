package com.codemonkeys.carmechanicbackend.api.dto.repair_booking.repair_booking_guest;

import com.codemonkeys.carmechanicbackend.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairGuestViewDto {

    private String repairType;
    private String repairDetails;
    private Long repairCost;
    private RepairStatusEnum repairStatus;

}
