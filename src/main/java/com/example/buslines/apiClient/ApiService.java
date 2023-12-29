package com.example.buslines.apiClient;

import com.example.buslines.dto.journey.JourneyBaseDTO;
import com.example.buslines.dto.stop.StopBaseDTO;

public interface ApiService {

    JourneyBaseDTO getJourneyPattern();
    StopBaseDTO getStops();
}
