package com.example.buslines.service;

import com.example.buslines.apiClient.ApiService;
import com.example.buslines.dto.*;
import com.example.buslines.dto.journey.JourneyBaseDTO;
import com.example.buslines.dto.journey.JourneyResultDTO;
import com.example.buslines.dto.stop.StopBaseDTO;
import com.example.buslines.dto.stop.StopResultDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusService {

    private final ApiService apiService;

    public BusService(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<BusListResponse> getBusListResponse() {
        StopBaseDTO stopResponse = apiService.getStops();
        JourneyBaseDTO jourResponse = apiService.getJourneyPattern();

        Map<String, String> stopList = Arrays.stream(stopResponse.getResponseData().getResult())
                .collect(Collectors.toMap(StopResultDTO::getStopPointNumber, StopResultDTO::getStopPointName));

        Map<Integer, List<String>> busList = Arrays.stream(jourResponse.getResponseData().getResult())
                .parallel()
                .collect(Collectors.groupingBy(
                        JourneyResultDTO::getLineNumber,
                        Collectors.mapping(jourResult -> nameConverter(jourResult.getJourneyPatternPointNumber(), stopList), Collectors.toList())));

        Map<Integer, List<String>> sortedBusList = busList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.<List<String>, Integer>comparing(List::size).reversed()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        return sortedBusList.entrySet().stream()
                .map(entry -> new BusListResponse(
                        entry.getKey(),
                        entry.getValue()
                )).toList();
    }

    public String nameConverter(Integer bussStop, Map<String, String> stopList) {

        if (stopList.containsKey(String.valueOf(bussStop)))
            return stopList.get(String.valueOf(bussStop));
        return null;
    }
}
