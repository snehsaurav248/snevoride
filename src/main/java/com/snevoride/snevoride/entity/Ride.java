package com.snevoride.snevoride.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideId;

    private Long passengerId;
    private Long driverId;

    private Double sourceLat;
    private Double sourceLong;

    private Double destLat;
    private Double destLong;

    private Double distance;
    private Double fare;

    private String status; // REQUESTED, ACCEPTED, STARTED, COMPLETED
}
