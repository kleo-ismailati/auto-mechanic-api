package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookingItemDto extends BookingBaseDto {

    private Long id;
    private List<BookingItemRepairDto> repairs;

}
