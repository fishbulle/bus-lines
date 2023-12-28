package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StopPointDTO implements ResultDTO {

    @JsonProperty
    private int stopPointNumber;

    @JsonProperty
    private String stopPointName;

    @JsonProperty
    private int stopAreaNumber;

    @JsonProperty
    private double locationNorthingCoordinate;

    @JsonProperty
    private double locationEastingCoordinate;

    @JsonProperty
    private String zoneShortName;

    @JsonProperty
    private String stopAreaTypeCode;

    @JsonProperty
    private String lastModifiedUtcDateTime;

    @JsonProperty
    private String existsFromDate;
}
