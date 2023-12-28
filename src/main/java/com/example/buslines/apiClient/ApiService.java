package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;
import com.example.buslines.dto.JourneyPatternPointOnLineDTO;
import com.example.buslines.dto.StopPointDTO;
import reactor.core.publisher.Mono;

public interface ApiService {

    Mono<BaseResponseDTO<JourneyPatternPointOnLineDTO>> getJourneyPattern();
   // Mono<BaseResponseDTO<LineDTO>> getLines();
    Mono<BaseResponseDTO<StopPointDTO>> getStops();
}
