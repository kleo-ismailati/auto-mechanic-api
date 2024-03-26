package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BookingUpdateDto {

    @ApiModelProperty(dataType = "java.lang.Integer")
    private RepairStatusEnum status;

}
