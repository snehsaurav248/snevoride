package com.snevoride.snevoride.dto;

import lombok.Data;

@Data
public class RideRequestDTO {

    private Long passengerId;

    private Double sourceLat;
    private Double sourceLong;

    private Double destLat;
    private Double destLong;
}
