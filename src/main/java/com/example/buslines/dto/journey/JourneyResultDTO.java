package com.example.buslines.dto.journey;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JourneyResultDTO {

    @JsonProperty("LineNumber")
    private int lineNumber;

    @JsonProperty("JourneyPatternPointNumber")
    private int journeyPatternPointNumber;

/*    @JsonProperty("DirectionCode")
    private int directionCode;*/
}
