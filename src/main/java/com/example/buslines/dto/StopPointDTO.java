package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class StopPointDTO {

    @JsonProperty
    private String stopPointNumber;

    @JsonProperty
    private Collection<String> stopPointName;
}
