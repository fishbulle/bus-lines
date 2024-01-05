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

        Map<String, String> stopList = createStopListMap(stopResponse);
        Map<Integer, List<String>> busList = createBusListMap(jourResponse, stopList);
        Map<Integer, List<String>> sortedBusList = sortAndLimitBusList(busList);

        return mapToBusListResponse(sortedBusList);
    }

    private Map<String, String> createStopListMap(StopBaseDTO stopResponse) {
        return Arrays.stream(stopResponse.getResponseData().getResult())
                .collect(Collectors.toMap(StopResultDTO::getStopPointNumber, StopResultDTO::getStopPointName));
    }

    private Map<Integer, List<String>> createBusListMap(JourneyBaseDTO jourResponse, Map<String, String> stopList) {
        return Arrays.stream(jourResponse.getResponseData().getResult())
                .parallel()
                .filter(p -> p.getDirectionCode() == 1)
                .collect(Collectors.groupingBy(
                        JourneyResultDTO::getLineNumber,
                        Collectors.mapping(jourResult -> nameConverter(
                                        jourResult.getJourneyPatternPointNumber(), stopList),
                                Collectors.toList())));
    }

    private Map<Integer, List<String>> sortAndLimitBusList(Map<Integer, List<String>> busList) {
        return busList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.<List<String>, Integer>comparing(List::size).reversed()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private List<BusListResponse> mapToBusListResponse(Map<Integer, List<String>> sortedBusList) {
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
