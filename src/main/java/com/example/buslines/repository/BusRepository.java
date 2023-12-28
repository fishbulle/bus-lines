package com.example.buslines.repository;

import com.example.buslines.model.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Long> {

    Optional<BusEntity> findByLineNumber(String lineNumber);

    interface TopBusResult {
        String getBusNumber();
        Integer getStopCounts();
    }
}
