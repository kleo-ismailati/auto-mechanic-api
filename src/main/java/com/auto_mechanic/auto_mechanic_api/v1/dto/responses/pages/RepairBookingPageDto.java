package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.RepairBookingListItemDto;
import lombok.Data;

import java.util.List;

@Data
public class RepairBookingPageDto {

    private List<RepairBookingListItemDto> result;
    private int pageNo;
    private int size;
    private int total;

}
