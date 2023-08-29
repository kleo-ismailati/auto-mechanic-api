package com.auto_mechanic.auto_mechanic_api.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
@Entity
public class RepairBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime date;

	@Enumerated(EnumType.ORDINAL)
	private RepairStatusEnum status;

	@Column(unique = true)
	private String refID;

	private LocalDate dueDate;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "auto_id")
	private Auto auto;

	@Valid
	@OneToMany(mappedBy = "repairBooking", cascade=CascadeType.ALL)
	private List<Repair> repairs;
	
	@Transient
	private Long totalPrice;
	
	
	public RepairBooking() {}

}
