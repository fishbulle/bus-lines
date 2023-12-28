package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StopPointDTO implements ResultDTO {

    @JsonProperty
    private String stopPointNumber;

    @JsonProperty
    private String stopPointName;
}
