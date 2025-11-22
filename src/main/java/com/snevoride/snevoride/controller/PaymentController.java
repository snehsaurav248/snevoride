package com.snevoride.snevoride.controller;

import com.snevoride.snevoride.dto.PaymentRequestDTO;
import com.snevoride.snevoride.dto.PaymentResponseDTO;
import com.snevoride.snevoride.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> pay(@RequestBody PaymentRequestDTO request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }
}
