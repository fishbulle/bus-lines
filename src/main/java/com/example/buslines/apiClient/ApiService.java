package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;
import com.example.buslines.dto.JourneyPatternPointOnLineDTO;
import com.example.buslines.dto.LineDTO;
import com.example.buslines.dto.StopPointDTO;

public interface ApiService {

    BaseResponseDTO<JourneyPatternPointOnLineDTO> getJourneyPattern();
    BaseResponseDTO<LineDTO> getLines();
    BaseResponseDTO<StopPointDTO> getStops();
}
