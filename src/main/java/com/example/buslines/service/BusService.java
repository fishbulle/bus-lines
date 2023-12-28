package com.example.buslines.service;

import com.example.buslines.dto.StopPointDTO;
import com.example.buslines.model.BusEntity;
import com.example.buslines.model.StopEntity;
import com.example.buslines.repository.BusRepository;
import com.example.buslines.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private StopRepository stopRepository;

    public List<BusEntity> getTopBusesWithMostStops(int limit) {
        List<BusEntity> topBuses = busRepository.findAll();
        topBuses.sort(Comparator.comparingInt(bus -> bus.getStops().size()));
        Collections.reverse(topBuses);
        return topBuses.stream().limit(limit).collect(Collectors.toList());
    }
}
