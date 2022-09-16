package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventDto1;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteEventService {

    @Resource
    private AthleteEventRepository athleteEventRepository;

    @Resource
    private AthleteService athleteService;


    public void saveAllAthleteEvents(AthleteEvent athleteEvent) {
        athleteEventRepository.save(athleteEvent);
    }

    public void updateAthleteEventSettings(AthleteEventDto1 request) {
        Optional<AthleteEvent> athleteEvent = athleteEventRepository.findByHeatNumberAndLaneNumber(request.getHeatNumber(), request.getLaneNumber());
        athleteEvent.get().setEventLength(request.getEventLength());



    }
}
