package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SplitRepository extends JpaRepository<Split, Integer> {

    @Query("select s from Split s where s.isActive = ?1 and s.athleteEvent = ?2 order by s.id")
    List<Split> findByIsActiveAthleteEvent(Boolean isActive, AthleteEvent athleteEvent);

}