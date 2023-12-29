package com.example.buslines.dto.stop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StopResultDTO {

    @JsonProperty("StopPointNumber")
    private String stopPointNumber;

    @JsonProperty("StopPointName")
    private String stopPointName;
}
