package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.split.SplitLength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.stroke.id = ?1")
    Stroke findStrokeByStrokeId(Integer id);

    @Query("select e from Event e where e.splitLength.id = ?1")
    SplitLength findSplitLengthBySplitLengthId(Integer id);




}