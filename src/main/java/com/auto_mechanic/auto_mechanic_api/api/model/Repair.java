package com.auto_mechanic.auto_mechanic_api.api.model;

import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    public Repair() {
    }

    @Override
    public String toString() {
        return "Repair [id=" + id + ", repairType=" + repairType + ", repairDetails=" + repairDetails + ", repairCost="
                + repairCost + ", repairStatus=" + repairStatus + "]";
    }

}
