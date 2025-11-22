package com.snevoride.snevoride.service;

import com.snevoride.snevoride.dto.FareRequestDTO;
import com.snevoride.snevoride.dto.FareResponseDTO;

public interface FareService {
    FareResponseDTO calculateFare(FareRequestDTO request);
}
