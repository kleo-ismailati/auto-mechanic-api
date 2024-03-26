package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookingDto extends BookingBaseDto {

    private Long id;
    private List<BookingRepairDto> repairs;

}
