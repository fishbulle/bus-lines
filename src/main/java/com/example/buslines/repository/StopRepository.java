package com.example.buslines.repository;

import com.example.buslines.model.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StopRepository extends JpaRepository<StopEntity, Long> {
    Optional<StopEntity> findByStopPointNumber(String stopPointNumber);

    Optional<StopEntity> findByStopPointName(String stopPointName);
}
