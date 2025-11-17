package com.snevoride.snevoride.controller;

import com.snevoride.snevoride.dto.DriverLocationDTO;
import com.snevoride.snevoride.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/update-location")
    public ResponseEntity<String> updateLocation(@RequestBody DriverLocationDTO dto) {
        driverService.updateDriverLocation(dto);
        return ResponseEntity.ok("Location updated successfully");
    }
}
