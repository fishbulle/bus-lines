package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;

public interface ApiService {

    BaseResponseDTO getJourneyPattern();
    BaseResponseDTO getStops();
}
