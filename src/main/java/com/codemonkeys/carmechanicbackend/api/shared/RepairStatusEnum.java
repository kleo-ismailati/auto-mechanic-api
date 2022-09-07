package com.codemonkeys.carmechanicbackend.api.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RepairStatusEnum {

	@JsonProperty("0")
	toBeDone,

	@JsonProperty("1")
	inProgress,

	@JsonProperty("2")
	done

}
