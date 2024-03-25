package com.auto_mechanic.auto_mechanic_api.v1.dto.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepairBookingDto extends RepairBookingBaseDto {

    private Long id;
    private List<RepairForRepairBookingDto> repairs;

}
