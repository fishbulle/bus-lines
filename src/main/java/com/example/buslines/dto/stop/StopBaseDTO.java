package com.example.buslines.dto.stop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StopBaseDTO {

    @JsonProperty("StatusCode")
    private int statusCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("ExecutionTime")
    private int executionTime;

    @JsonProperty("ResponseData")
    private StopResponseDTO responseData;
}
