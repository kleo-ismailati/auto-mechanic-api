package com.codemonkeys.car_mechanic.api.model;

import javax.persistence.*;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String repairType;
	private String repairDetails;
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
