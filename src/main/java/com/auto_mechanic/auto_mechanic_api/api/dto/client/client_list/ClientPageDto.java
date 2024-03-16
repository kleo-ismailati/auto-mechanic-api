package com.auto_mechanic.auto_mechanic_api.api.dto.client.client_list;

import lombok.Data;

import java.util.List;

@Data
public class ClientPageDto {

    private List<ClientListItemDto> result;
    private int pageNo;
    private int size;
    private int total;

}
