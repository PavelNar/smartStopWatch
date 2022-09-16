package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.domain.athlete.athleteevent.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.athleteevent.AthleteEventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class StopperService {

    @Resource
    private AthleteEventService athleteEventService;

    public void startHeat(Instant timestamp, HeatStartRequest startRequest) {
        List<AthleteEvent> athleteEvents = athleteEventService.findAthleteEventsByEventIdAndHeatNumber(startRequest.getEventId(), startRequest.getHeatNumber());
        athleteEventService.updateAthleteEventsWithTimeStamp(timestamp, athleteEvents);
    }

    public void splitClick(Instant timestamp, Integer athleteEventId) {

    }
}
