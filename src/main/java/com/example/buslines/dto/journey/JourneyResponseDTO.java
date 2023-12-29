package com.example.buslines.dto.journey;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JourneyResponseDTO {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Result")
    private JourneyResultDTO[] result;
}
