package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SplitRepository extends JpaRepository<Split, Integer> {

    @Query("select s from Split s where s.isActive = ?1 and s.athleteEvent = ?2 order by s.id")
    List<Split> findByIsActiveAthleteEvent(Boolean isActive, AthleteEvent athleteEvent);

    @Query("select s from Split s where s.eventId = ?1 and s.heatNumber = ?2")
    List<Split> findSplitsBy(Integer eventId, Integer heatNumber);

    @Query("select s from Split s where s.isActive = ?1 and s.athleteEvent.id = ?2 order by s.id")
    List<Split> findAllSplitsByAthleteEventId(Boolean isActive, Integer id);


}