package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_guest;

import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.RepairBookingBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepairBookingGuestViewDto extends RepairBookingBaseDto {

    private List<RepairGuestViewDto> repairs;

}
