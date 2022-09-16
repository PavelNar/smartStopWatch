package com.project.smartStopWatch.domain.athlete.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AthleteEventRepository extends JpaRepository<AthleteEvent, Integer> {
    @Query("select a from AthleteEvent a where a.heatNumber = ?1 and a.laneNumber = ?2")
    Optional<AthleteEvent> findByHeatNumberAndLaneNumber(Integer heatNumber, Integer laneNumber);

    @Query("select a from AthleteEvent a where a.event.id = ?1 and a.heatNumber = ?2")
    List<AthleteEvent> findByEventIdAndHeatNumber(Integer eventId, Integer heatNumber);


}
