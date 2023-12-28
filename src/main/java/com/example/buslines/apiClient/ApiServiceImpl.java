package com.example.buslines.apiClient;

import com.example.buslines.dto.BaseResponseDTO;
import com.example.buslines.dto.JourneyPatternPointOnLineDTO;
import com.example.buslines.dto.StopPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${application.stopPointUrl}")
    private String stopPointUrl;

    @Value("${application.lineUrl}")
    private String lineUrl;

    @Value("${application.journeyPatternUrl}")
    private String journeyPatternUrl;

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ApiServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<BaseResponseDTO<JourneyPatternPointOnLineDTO>> getJourneyPattern() {
        return webClientBuilder.build()
                .get()
                .uri(journeyPatternUrl)
                .header("Accept-Encoding", "gzip, deflate")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> handleResponse(response, new ParameterizedTypeReference<>() {
                }));
    }

    @Override
    public Mono<BaseResponseDTO<StopPointDTO>> getStops() {
        return webClientBuilder.build()
                .get()
                .uri(stopPointUrl)
                .header("Accept-Encoding", "gzip, deflate")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> handleResponse(response, new ParameterizedTypeReference<>() {
                }));
    }

    private <T> Mono<T> handleResponse(ClientResponse response, ParameterizedTypeReference<T> typeReference) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(typeReference);
        } else {
            return Mono.error(new RuntimeException("Failed to retrieve data"));
        }
    }
}
