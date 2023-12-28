package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JourneyPatternPointOnLineDTO implements ResultDTO {

    @JsonProperty
    private int lineNumber;

    @JsonProperty
    private int directionCode;

    @JsonProperty
    private int journeyPatternPointNumber;

    @JsonProperty
    private String lastModifiedUtcDateTime;

    @JsonProperty
    private String existsFromDate;

}
