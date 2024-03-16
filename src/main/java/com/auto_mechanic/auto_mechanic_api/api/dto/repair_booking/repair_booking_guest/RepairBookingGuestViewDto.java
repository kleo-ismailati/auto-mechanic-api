package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_guest;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RepairBookingGuestViewDto {

    private LocalDateTime date;
    private RepairStatusEnum status;
    private String firstName;
    private String lastName;
    private String autoType;
    private String autoModel;
    private List<RepairGuestViewDto> repairs;
    private Long totalPrice;

}
