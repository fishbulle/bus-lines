package com.example.buslines.dto.journey;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JourneyBaseDTO {

    @JsonProperty("StatusCode")
    private int statusCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("ExecutionTime")
    private int executionTime;

    @JsonProperty("ResponseData")
    private JourneyResponseDTO responseData;
}
