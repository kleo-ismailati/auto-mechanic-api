package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_list;

import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.RepairBookingBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepairBookingListItemDto extends RepairBookingBaseDto {

    private Long id;
    private List<RepairForRepairBookingListItemDto> repairs;

}
