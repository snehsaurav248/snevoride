package com.snevoride.snevoride.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    private Boolean available = true;

    private Double latitude;
    private Double longitude;

    private String vehicleNumber;
    private String vehicleType;
}
