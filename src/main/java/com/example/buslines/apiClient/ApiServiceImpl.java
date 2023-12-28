package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;
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
    public BaseResponseDTO getJourneyPattern() {
        return getBaseResponseDTO(journeyPatternUrl);
    }

    @Override
    public BaseResponseDTO getStops() {
        return getBaseResponseDTO(stopPointUrl);
    }

    private BaseResponseDTO getBaseResponseDTO(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<BaseResponseDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
