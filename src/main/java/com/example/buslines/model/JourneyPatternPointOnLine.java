package com.example.buslines.model;

import lombok.Data;

@Data
public class JourneyPatternPointOnLine {
    private String lineNumber;
    private String directionCode;
    private String journeyPatternPointNumber;
}
