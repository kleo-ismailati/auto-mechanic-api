package com.codemonkeys.car_mechanic.api.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Please enter repair type")
	@Size(min = 3, max = 30)
	private String repairType;

	@NotEmpty(message = "Please enter repair details")
	@Size(min = 3, max = 200)
	private String repairDetails;

	@Min(0)
	@Max(99999)
	private Long repairCost;

	@Enumerated(EnumType.ORDINAL)
	private RepairStatusEnum repairStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "rb_id", nullable = false)
	private RepairBooking repairBooking;

	public Repair() {}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", repairType=" + repairType + ", repairDetails=" + repairDetails + ", repairCost="
				+ repairCost + ", repairStatus=" + repairStatus + "]";
	}

}
