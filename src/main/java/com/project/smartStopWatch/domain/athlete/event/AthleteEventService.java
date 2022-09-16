package com.project.smartStopWatch.domain.athlete.event;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AthleteEventService {

    @Resource
    private AthleteEventRepository athleteEventRepository;


    public void saveAllAthleteEvents(AthleteEvent athleteEvent) {
        athleteEventRepository.save(athleteEvent);
    }
}
