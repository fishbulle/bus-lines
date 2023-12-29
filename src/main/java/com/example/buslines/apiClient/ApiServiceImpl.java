package com.example.buslines.apiClient;

import com.example.buslines.dto.journey.JourneyBaseDTO;
import com.example.buslines.dto.stop.StopBaseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    @Value("${application.stopPointUrl}")
    private String stopPointUrl;

    @Value("${application.journeyPatternUrl}")
    private String journeyPatternUrl;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public JourneyBaseDTO getJourneyPattern() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<JourneyBaseDTO> response = restTemplate.exchange(
                journeyPatternUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }

    @Override
    public StopBaseDTO getStops() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<StopBaseDTO> response = restTemplate.exchange(
                stopPointUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
