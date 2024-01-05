package com.example.buslines.controller;

import com.example.buslines.dto.BusListResponse;
import com.example.buslines.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity<?> getTopBusLines() {
        try {
            List<BusListResponse> topBuses = busService.getBusListResponse();
            return ResponseEntity.ok(topBuses);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

}
