package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.ClientListItemDto;
import lombok.Data;

import java.util.List;

@Data
public class ClientPageDto {

    private List<ClientListItemDto> result;
    private int pageNo;
    private int size;
    private int total;

}
