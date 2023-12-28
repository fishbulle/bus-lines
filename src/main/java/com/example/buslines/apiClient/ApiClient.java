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

import java.util.List;

@Component
public class ApiClient implements ApplicationRunner {

    private final StopRepository stopRepository;
    private final BusRepository busRepository;
    private final ApiServiceImpl apiService;

    public ApiClient(StopRepository stopRepository, BusRepository busRepository, ApiServiceImpl apiService) {
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
        this.apiService = apiService;
    }

    @Override
    public void run(ApplicationArguments args) {
        processAndStoreData();
    }

    public void processAndStoreData() {
        apiService.getStops().subscribe(stopPointsResponse -> {
            processAndStoreStopPoints(stopPointsResponse.getResponseData().getResult());
        });

        apiService.getJourneyPattern().subscribe(journeyPatternResponse -> {
            processAndStoreJourneyPatterns(journeyPatternResponse.getResponseData().getResult());
        });
    }

    public void processAndStoreStopPoints(List<StopPointDTO> stopPoints) {
        for (StopPointDTO stopPointDTO : stopPoints) {
            String stopPointNumber = stopPointDTO.getStopPointNumber();

            StopEntity stopEntity = stopRepository.findByStopPointNumber(stopPointNumber)
                    .orElseGet(() -> {
                        StopEntity newStop = new StopEntity();
                        newStop.setStopPointNumber(stopPointNumber);
                        return stopRepository.save(newStop);
                    });

            String stopPointName = stopPointDTO.getStopPointName();
            StopEntity stopEntity2 = stopRepository.findByStopPointName(stopPointName)
                    .orElseGet(() -> {
                        StopEntity newStop = new StopEntity();
                        newStop.setStopPointName(stopPointName);
                        return stopRepository.save(newStop);
                    });

            BusEntity defaultBus = busRepository.findById(1L)
                    .orElseGet(() -> {
                        BusEntity newBus = new BusEntity();
                        newBus.setLineNumber("Default Line");
                        return busRepository.save(newBus);
                    });

            stopEntity.setBus(defaultBus);
            stopRepository.save(stopEntity);
            stopRepository.save(stopEntity2);
        }
    }

    public void processAndStoreJourneyPatterns(List<JourneyPatternPointOnLineDTO> journeyPatterns) {
        for (JourneyPatternPointOnLineDTO journeyPatternDTO : journeyPatterns) {
            String lineNumber = journeyPatternDTO.getLineNumber();
            String stopPointNumber = journeyPatternDTO.getJourneyPatternPointNumber();

            BusEntity bus = busRepository.findByLineNumber(lineNumber)
                    .orElseGet(() -> {
                        BusEntity newBus = new BusEntity();
                        newBus.setLineNumber(lineNumber);
                        return busRepository.save(newBus);
                    });

            StopEntity stop = stopRepository.findByStopPointNumber(stopPointNumber)
                    .orElseGet(() -> {
                        StopEntity newStop = new StopEntity();
                        newStop.setStopPointNumber(stopPointNumber);
                        return stopRepository.save(newStop);
                    });

                stop.setBus(bus);
                stopRepository.save(stop);
            }
        }
    }
