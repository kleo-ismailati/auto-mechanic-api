package com.codemonkeys.car_mechanic.api.model.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RepairStatusEnum {

	@JsonProperty("0")
	toBeDone,

	@JsonProperty("1")
	inProgress,

	@JsonProperty("2")
	done

}
