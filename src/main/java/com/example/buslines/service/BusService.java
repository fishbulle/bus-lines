package com.example.buslines.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    @Value("${application.baseUrl}")
    private String baseUrl;

    @Value("${application.stopPointUrl}")
    private String stopPointUrl;

    @Value("${application.lineUrl}")
    private String lineUrl;

    @Value("${application.journeyPatternUrl}")
    private String journeyPatternUrl;

}
