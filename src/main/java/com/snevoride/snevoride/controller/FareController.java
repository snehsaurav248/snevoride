package com.snevoride.snevoride.controller;

import com.snevoride.snevoride.dto.FareRequestDTO;
import com.snevoride.snevoride.dto.FareResponseDTO;
import com.snevoride.snevoride.service.FareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fare")
public class FareController {

    private final FareService fareService;

    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<FareResponseDTO> calculateFare(@RequestBody FareRequestDTO request) {
        return ResponseEntity.ok(fareService.calculateFare(request));
    }
}
