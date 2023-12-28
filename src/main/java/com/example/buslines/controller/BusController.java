package com.example.buslines.controller;

import com.example.buslines.apiClient.ApiService;
import com.example.buslines.model.BusEntity;
import com.example.buslines.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private BusService busService;

    @GetMapping("/top")
    public ResponseEntity<List<BusEntity>> getTopBusesWithMostStops(@RequestParam(defaultValue = "10") int limit) {
        List<BusEntity> topBuses = busService.getTopBusesWithMostStops(limit);
        return ResponseEntity.ok(topBuses);
    }
}
