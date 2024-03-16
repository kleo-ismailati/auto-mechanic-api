package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.new_repair_booking;

import lombok.Data;

import java.util.List;

@Data
public class NewRepairBookingDto {

    private Long clientId;
    private Long autoId;
    private List<NewRepairDto> repairs;
    private Long totalPrice;

}
