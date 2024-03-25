package com.auto_mechanic.auto_mechanic_api.v1.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RepairStatusEnum {

    @JsonProperty("0")
    toBeDone,

    @JsonProperty("1")
    inProgress,

    @JsonProperty("2")
    done

}
