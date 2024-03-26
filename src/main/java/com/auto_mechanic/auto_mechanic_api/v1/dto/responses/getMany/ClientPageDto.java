package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany;

import lombok.Data;

import java.util.List;

@Data
public class ClientPageDto {

    private List<ClientItemDto> result;
    private int pageNo;
    private int size;
    private int total;

}
