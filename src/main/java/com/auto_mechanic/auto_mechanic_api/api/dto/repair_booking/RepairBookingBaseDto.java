package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RepairBookingBaseDto {
    private LocalDateTime date;
    private RepairStatusEnum status;
    private String firstName;
    private String lastName;
    private String autoType;
    private String autoModel;
    private Long totalPrice;
}
