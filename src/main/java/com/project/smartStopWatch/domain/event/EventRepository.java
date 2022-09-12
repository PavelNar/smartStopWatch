package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {



}