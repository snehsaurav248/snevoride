package com.snevoride.snevoride.controller;

import com.snevoride.snevoride.entity.Ride;
import com.snevoride.snevoride.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // 1️⃣ Request Ride
    @PostMapping("/request")
    public ResponseEntity<?> requestRide(@RequestBody Ride ride) {
        return ResponseEntity.ok(rideService.requestRide(ride));
    }

    // 2️⃣ Update Ride Status (JSON + PUT)
    @PutMapping("/{rideId}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long rideId,
            @RequestBody Map<String, String> body) {

        String status = body.get("status");
        return ResponseEntity.ok(rideService.updateRideStatus(rideId, status));
    }


    // 3️⃣ Get Ride Details
    @GetMapping("/{rideId}")
    public ResponseEntity<?> getRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(rideService.getRide(rideId));
    }
}
