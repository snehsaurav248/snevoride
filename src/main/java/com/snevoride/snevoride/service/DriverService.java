package com.snevoride.snevoride.service;

import com.snevoride.snevoride.dto.DriverLocationDTO;
import com.snevoride.snevoride.entity.Driver;

public interface DriverService {
    void updateDriverLocation(DriverLocationDTO dto);

    void registerDriver(Driver driver);
}
