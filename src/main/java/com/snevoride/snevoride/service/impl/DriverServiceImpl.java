package com.snevoride.snevoride.service.impl;

import com.snevoride.snevoride.dto.DriverLocationDTO;
import com.snevoride.snevoride.entity.Driver;
import com.snevoride.snevoride.repository.DriverRepository;
import com.snevoride.snevoride.service.DriverService;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void updateDriverLocation(DriverLocationDTO dto) {
        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driver.setLatitude(dto.getLatitude());
        driver.setLongitude(dto.getLongitude());

        driverRepository.save(driver);
    }
}
