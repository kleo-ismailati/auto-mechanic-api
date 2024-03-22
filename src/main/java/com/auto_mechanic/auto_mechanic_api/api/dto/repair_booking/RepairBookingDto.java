package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepairBookingDto extends RepairBookingBaseDto {

    private Long id;
    private List<RepairForRepairBookingDto> repairs;

}
