package com.example.buslines.model;

import lombok.Data;

import java.util.Collection;

@Data
public class StopPoint {

    private String stopPointNumber;
    private Collection<String> stopPointName;
}
