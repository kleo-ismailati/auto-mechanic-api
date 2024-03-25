package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create;

import lombok.Data;

import java.util.List;

@Data
public class NewRepairBookingDto {

    private Long clientId;
    private Long autoId;
    private List<NewRepairDto> repairs;
    private Long totalPrice;

}
