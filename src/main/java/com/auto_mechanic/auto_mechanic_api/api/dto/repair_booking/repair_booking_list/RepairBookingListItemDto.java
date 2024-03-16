package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_list;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RepairBookingListItemDto {

    private Long id;
    private LocalDateTime date;
    private RepairStatusEnum status;
    private String firstName;
    private String lastName;
    private String autoType;
    private String autoModel;
    private List<RepairForRepairBookingListItemDto> repairs;
    private Long totalPrice;

}
