package com.snevoride.snevoride.service;

import com.snevoride.snevoride.entity.Ride;

public interface RideService {
    Ride requestRide(Ride ride);
    Ride updateRideStatus(Long rideId, String status);
    Ride getRide(Long rideId);
}
