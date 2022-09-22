package com.project.smartStopWatch.domain.athlete.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AthleteEventRepository extends JpaRepository<AthleteEvent, Integer> {

    @Query("select a from AthleteEvent a where a.isActive = ?1 and a.event.id = ?2 and a.heatNumber = ?3 order by a.id")
    List<AthleteEvent> findEventsBy(Boolean isActive, Integer id, Integer heatNumber);

    @Query("select a from AthleteEvent a where a.isActive = ?1 and a.event.id = ?2 order by a.heatNumber, a.id")
    List<AthleteEvent> findAthleteEventsBy(Boolean isActive, Integer eventId);

    @Query("select a from AthleteEvent a where a.isActive = ?1 and a.event.id = ?2 and a.heatNumber = ?3")
    List<AthleteEvent> findActiveAthleteEventsByx(Boolean isActive, Integer id, Integer heatNumber);

    @Query("select a from AthleteEvent a where a.isActive = ?1 and a.athlete.id = ?2")
    List<AthleteEvent> findAthleteEventsByAthleteId(Boolean isActive, Integer id);


}