package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
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

    // TODO: SEE ON TEIE KÕIGE TÄHTSAM TEENUS, MIS ON VAJA ASAP ära implementeerida
    public StopperDashboard getStopperDashboard(Integer eventId) {
        return null;
    }
}
