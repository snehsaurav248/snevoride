package com.snevoride.snevoride.service.impl;

import com.snevoride.snevoride.entity.*;
import com.snevoride.snevoride.exception.NoDriverAvailableException;
import com.snevoride.snevoride.exception.RideNotFoundException;
import com.snevoride.snevoride.repository.DriverRepository;
import com.snevoride.snevoride.repository.RideRepository;
import com.snevoride.snevoride.service.RideService;
import com.snevoride.snevoride.util.FareUtil;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    public RideServiceImpl(RideRepository rideRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    // ---------------------------------------------------------
    // 1️⃣ REQUEST RIDE
    // ---------------------------------------------------------
    @Override
    public Ride requestRide(Ride ride) {

        // Find nearest available driver
        Driver nearestDriver = driverRepository.findAll().stream()
                .filter(Driver::getAvailable)
                .min((d1, d2) -> {
                    double dist1 = FareUtil.distance(
                            ride.getPickupLat(), ride.getPickupLng(),
                            d1.getLatitude(), d1.getLongitude());

                    double dist2 = FareUtil.distance(
                            ride.getPickupLat(), ride.getPickupLng(),
                            d2.getLatitude(), d2.getLongitude());

                    return Double.compare(dist1, dist2);
                })
                .orElseThrow(() -> new NoDriverAvailableException("No available drivers nearby"));

        // Assign driver
        ride.setDriverId(nearestDriver.getId());

        // Calculate fare
        double distance = FareUtil.distance(
                ride.getPickupLat(), ride.getPickupLng(),
                ride.getDropLat(), ride.getDropLng());

        ride.setFare(FareUtil.calculateFare(distance));

        // Initial status
        ride.setStatus(RideStatus.REQUESTED);

        return rideRepository.save(ride);
    }

    // ---------------------------------------------------------
    // 2️⃣ UPDATE RIDE STATUS
    // ---------------------------------------------------------
    @Override
    public Ride updateRideStatus(Long rideId, String status) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideNotFoundException("Ride with id " + rideId + " not found"));

        // Validate status
        RideStatus newStatus;
        try {
            newStatus = RideStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid ride status: " + status);
        }

        ride.setStatus(newStatus);
        return rideRepository.save(ride);
    }

    // ---------------------------------------------------------
    // 3️⃣ GET RIDE DETAILS
    // ---------------------------------------------------------
    @Override
    public Ride getRide(Long rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() -> new RideNotFoundException("Ride with id " + rideId + " not found"));
    }
}
