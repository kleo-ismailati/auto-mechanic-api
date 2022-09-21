package com.codemonkeys.carmechanicbackend.api.model.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RepairStatusEnum {

	@JsonProperty("0")
	toBeDone,

	@JsonProperty("1")
	inProgress,

	@JsonProperty("2")
	done

}
