package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;
import com.example.buslines.dto.JourneyPatternPointOnLineDTO;
import com.example.buslines.dto.LineDTO;
import com.example.buslines.dto.StopPointDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${application.stopPointUrl}")
    private String stopPointUrl;

    @Value("${application.lineUrl}")
    private String lineUrl;

    @Value("${application.journeyPatternUrl}")
    private String journeyPatternUrl;

    @Override
    public BaseResponseDTO<JourneyPatternPointOnLineDTO> getJourneyPattern() {
        return null;
    }

    @Override
    public BaseResponseDTO<LineDTO> getLines() {
        return null;
    }

    @Override
    public BaseResponseDTO<StopPointDTO> getStops() {
        return null;
    }
}
