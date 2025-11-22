package com.snevoride.snevoride.service.impl;

import com.snevoride.snevoride.dto.FareRequestDTO;
import com.snevoride.snevoride.dto.FareResponseDTO;
import com.snevoride.snevoride.exception.FareCalculationException;
import com.snevoride.snevoride.service.FareService;
import com.snevoride.snevoride.util.FareUtil;
import org.springframework.stereotype.Service;

@Service
public class FareServiceImpl implements FareService {

    @Override
    public FareResponseDTO calculateFare(FareRequestDTO req) {

        // 1️⃣ Validate coordinates
        if (req.getPickupLat() == null || req.getPickupLng() == null ||
                req.getDropLat() == null || req.getDropLng() == null) {
            throw new FareCalculationException("Pickup/Drop coordinates cannot be null");
        }

        // 2️⃣ Calculate distance
        double distance = FareUtil.distance(
                req.getPickupLat(), req.getPickupLng(),
                req.getDropLat(), req.getDropLng()
        );

        if (distance <= 0) {
            throw new FareCalculationException("Invalid distance calculated");
        }

        // 3️⃣ Prepare response
        FareResponseDTO response = new FareResponseDTO();
        response.setDistanceKm(distance);
        response.setEstimatedFare(FareUtil.calculateFare(distance));

        return response;
    }
}
