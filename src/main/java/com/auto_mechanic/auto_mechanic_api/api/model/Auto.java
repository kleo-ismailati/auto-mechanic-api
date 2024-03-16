package com.auto_mechanic.auto_mechanic_api.api.model;

import com.auto_mechanic.auto_mechanic_api.image.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please enter auto type")
    @Size(min = 3, max = 15)
    private String autoType;

    @NotEmpty(message = "Please enter auto model")
    @Size(min = 3, max = 15)
    private String autoModel;

    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Please enter valid year")
    private String year;

    @NotEmpty(message = "Please enter auto color")
    @Size(min = 3, max = 15)
    private String color;
    private String autoDescription;

    @Column(unique = true)
    private String licensePlate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Auto() {
    }

    public Auto(Long id, String autoType, String autoModel, String year, String color, String autoDescription,
                Client client) {
        this.id = id;
        this.autoType = autoType;
        this.autoModel = autoModel;
        this.year = year;
        this.color = color;
        this.autoDescription = autoDescription;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Auto [id=" + id + ", autoType=" + autoType + ", autoModel=" + autoModel + ", year=" + year + ", color="
                + color + ", autoDescription=" + autoDescription + "]";
    }

}
