package com.snevoride.snevoride.dto;

import lombok.Data;

@Data
public class RideResponseDTO {

    private Long rideId;
    private Long driverId;
    private Double driverLat;
    private Double driverLong;
    private Double estimatedFare;
    private Double estimatedDistance;
    private String status;
}
