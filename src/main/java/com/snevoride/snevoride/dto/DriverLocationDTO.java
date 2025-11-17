package com.snevoride.snevoride.dto;

import lombok.Data;

@Data
public class DriverLocationDTO {
    private Long driverId;
    private Double latitude;
    private Double longitude;

    public Long getDriverId() {
        return 0L;
    }
}
