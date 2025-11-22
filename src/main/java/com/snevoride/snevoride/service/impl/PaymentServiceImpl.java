package com.snevoride.snevoride.service.impl;

import com.snevoride.snevoride.dto.PaymentRequestDTO;
import com.snevoride.snevoride.dto.PaymentResponseDTO;
import com.snevoride.snevoride.entity.Ride;
import com.snevoride.snevoride.exception.PaymentFailedException;
import com.snevoride.snevoride.repository.RideRepository;
import com.snevoride.snevoride.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final RideRepository rideRepository;

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO req) {

        Ride ride = rideRepository.findById(req.getRideId())
                .orElseThrow(() -> new PaymentFailedException("Ride not found"));

        if (Double.compare(req.getAmount(), ride.getFare()) != 0) {
            throw new PaymentFailedException("Incorrect payment amount");
        }

        ride.setPaid(true);
        rideRepository.save(ride);

        return PaymentResponseDTO.builder()
                .paymentId(UUID.randomUUID().toString())
                .status("SUCCESS")
                .message("Paid via " + req.getMethod())
                .build();
    }
}
