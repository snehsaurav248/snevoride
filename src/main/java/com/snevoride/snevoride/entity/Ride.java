package com.snevoride.snevoride.entity;

import com.snevoride.snevoride.entity.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long driverId;

    private Double pickupLat;
    private Double pickupLng;

    private Double dropLat;
    private Double dropLng;

    private Double fare;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    public void setPaid(boolean b) {
    }
}
