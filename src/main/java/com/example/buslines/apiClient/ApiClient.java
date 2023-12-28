package com.example.buslines.apiClient;

import com.example.buslines.dto.JourneyPatternPointOnLineDTO;
import com.example.buslines.dto.StopPointDTO;
import com.example.buslines.model.BusEntity;
import com.example.buslines.model.StopEntity;
import com.example.buslines.repository.BusRepository;
import com.example.buslines.repository.StopRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApiClient /*implements ApplicationRunner*/ {

    private final StopRepository stopRepository;
    private final BusRepository busRepository;
    private final ApiServiceImpl apiService;

    public ApiClient(StopRepository stopRepository, BusRepository busRepository, ApiServiceImpl apiService) {
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
        this.apiService = apiService;
    }

/*    @Override
    public void run(ApplicationArguments args) {
        fetchData();
    }*/

    public void fetchData() {
        // grab the stopNumber and stopName
        apiService.getStops().getResponseData().getResult(); // something

        // grab the lineNumber and journeyPatternPointNumber
        // map the journeyPatternPointNumber to the stopNumber -> get the stopName
        apiService.getJourneyPattern().getResponseData().getResult();  // something
    }
}
