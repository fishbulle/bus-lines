package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseResponseDTO<T> {

    @JsonProperty
    private int statusCode;

    @JsonProperty
    private String message;

    @JsonProperty
    private int ExecutionTime;

    @JsonProperty
    private ResponseDataDTO<T> responseData;
}
