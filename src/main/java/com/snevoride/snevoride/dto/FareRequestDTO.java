package com.snevoride.snevoride.dto;

import lombok.Data;

@Data
public class FareRequestDTO {
    private Double pickupLat;
    private Double pickupLng;
    private Double dropLat;
    private Double dropLng;
}

