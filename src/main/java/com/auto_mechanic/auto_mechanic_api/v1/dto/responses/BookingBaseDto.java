package com.auto_mechanic.auto_mechanic_api.v1.dto.responses;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingBaseDto {
    private LocalDateTime date;
    private RepairStatusEnum status;
    private String firstName;
    private String lastName;
    private String autoType;
    private String autoModel;
    private Long totalPrice;
}
