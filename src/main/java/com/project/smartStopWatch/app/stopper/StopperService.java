package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.split.SplitService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class StopperService {

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private SplitService splitService;

    @Transactional
    public void startHeat(Instant timestamp, HeatStartRequest startRequest) {
        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEventsBy(startRequest.getEventId(), startRequest.getHeatNumber());
        ValidationService.validateStartHeatIsAllowedWithAthleteEvents(athleteEvents);
        athleteEventService.updateAthleteEventsWithTimeStamp(timestamp, athleteEvents);
        splitService.createInitialSplits(timestamp, athleteEvents);
    }

    @Transactional
    public void processSplitClick(Instant timestamp, Integer athleteEventId) {
        AthleteEvent athleteEvent = athleteEventService.updateAthleteEventSplitCounter(athleteEventId);
        splitService.processSplits(timestamp, athleteEvent);
    }

    // TODO: SEE ON TEIE KÕIGE TÄHTSAM TEENUS, MIS ON VAJA ASAP ära implementeerida
    public StopperDashboard getStopperDashboard(Integer eventId) {
        return null;
    }
}
