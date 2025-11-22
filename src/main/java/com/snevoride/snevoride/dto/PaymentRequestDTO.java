package com.snevoride.snevoride.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Long rideId;
    private double amount;
    private String method; // UPI, CARD, WALLET
}
