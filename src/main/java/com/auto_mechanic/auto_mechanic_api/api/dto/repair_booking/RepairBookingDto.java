package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RepairBookingDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String autoType;
    private String autoModel;
    private List<RepairForRepairBookingDto> repairs;
    private LocalDateTime date;
    private Long totalPrice;
    private RepairStatusEnum status;

}
