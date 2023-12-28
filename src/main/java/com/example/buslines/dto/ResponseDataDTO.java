package com.example.buslines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDataDTO {

    @JsonProperty
    private String version;

    @JsonProperty
    private String type;

    @JsonProperty
    private ResultDTO[] result;
}
