package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepairBookingListItemDto extends RepairBookingBaseDto {

    private Long id;
    private List<RepairForRepairBookingListItemDto> repairs;

}
