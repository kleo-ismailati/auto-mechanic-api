package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create;

import lombok.Data;

import java.util.List;

@Data
public class BookingCreateDto {

    private Long clientId;
    private Long autoId;
    private List<RepairCreateDto> repairs;
    private Long totalPrice;

}
