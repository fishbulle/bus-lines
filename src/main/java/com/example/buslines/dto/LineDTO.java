package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LineDTO {

    @JsonProperty
    private String lineNumber;

    @JsonProperty
    private String lineDesignation;
}
