package com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairGuestViewDto {

    private String repairType;
    private String repairDetails;
    private Long repairCost;
    private RepairStatusEnum repairStatus;

}
