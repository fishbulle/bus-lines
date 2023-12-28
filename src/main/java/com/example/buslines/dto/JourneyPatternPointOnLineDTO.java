package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JourneyPatternPointOnLineDTO {

    @JsonProperty
    private String lineNumber;

    @JsonProperty
    private String directionCode;

    @JsonProperty
    private String journeyPatternPointNumber;

}
