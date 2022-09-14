package com.project.smartStopWatch.domain.athlete.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteEventRepository extends JpaRepository<AthleteEvent, Integer> {
}
