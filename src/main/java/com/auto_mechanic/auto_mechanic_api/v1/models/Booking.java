package com.auto_mechanic.auto_mechanic_api.v1.models;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "booking")
public class Booking {

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
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @Transient
    private Long totalPrice;


    public Booking() {
    }

}
