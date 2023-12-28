package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class ResponseDataDTO<T> {

    @JsonProperty
    private String version;

    @JsonProperty
    private String type;

    @JsonProperty
    private Collection<T> result;
}
