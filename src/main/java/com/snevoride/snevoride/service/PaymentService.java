package com.snevoride.snevoride.service;

import com.snevoride.snevoride.dto.PaymentRequestDTO;
import com.snevoride.snevoride.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO processPayment(PaymentRequestDTO request);
}
