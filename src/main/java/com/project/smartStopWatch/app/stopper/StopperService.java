package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventMapper;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.event.Event;
import com.project.smartStopWatch.domain.event.EventService;
import com.project.smartStopWatch.domain.event.heat.Heat;
import com.project.smartStopWatch.domain.event.heat.HeatMapper;
import com.project.smartStopWatch.domain.event.heat.HeatService;
import com.project.smartStopWatch.domain.split.SplitService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopperService {

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private EventService eventService;

    @Resource
    private HeatService heatService;

    @Resource
    private SplitService splitService;


    @Resource
    private AthleteEventMapper athleteEventMapper;

    @Resource
    private HeatMapper heatMapper;

    @Transactional
    public void startHeat(Instant timestamp, HeatStartRequest startRequest) {
        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEventsBy(startRequest.getEventId(), startRequest.getHeatNumber());
        ValidationService.validateStartHeatIsAllowedWithAthleteEvents(athleteEvents);
        athleteEventService.updateAthleteEventsWithTimeStamp(timestamp, athleteEvents);
        splitService.createInitialSplits(timestamp, athleteEvents);
        heatService.startHeat(timestamp, startRequest.getEventId(), startRequest.getHeatNumber());
    }

    @Transactional
    public void processSplitClick(Instant timestamp, Integer athleteEventId) {
        AthleteEvent athleteEvent = athleteEventService.findAthleteEventBy(athleteEventId);
        ValidationService.validateSplitClickAllowed(athleteEvent);
        athleteEventService.increaseAthleteEventSplitCounter(athleteEvent);
        splitService.processSplits(timestamp, athleteEvent);
    }

    @Transactional
    public void processUndoClick(Integer athleteEventId) {
        AthleteEvent athleteEvent = athleteEventService.findAthleteEventBy(athleteEventId);
        ValidationService.validateUndoClickAllowed(athleteEvent);
        splitService.undoPreviousSplitProcess(athleteEvent);
    }

    public StopperDashboard getStopperDashboard(Integer eventId) {
        StopperDashboard stopperDashboard = new StopperDashboard();

        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEventsBy(eventId);
        List<Heat> heats = heatService.findActiveHeats(eventId);

        List<HeatRow> heatRows = createStopperDashboard(heats, athleteEvents);
        stopperDashboard.setHeatRows(heatRows);

        Event event = eventService.getEventById(eventId);
        stopperDashboard.setNumberOfLanes(event.getNumberOfLanes());
        return stopperDashboard;
    }

    private List<HeatRow> createStopperDashboard(List<Heat> heats, List<AthleteEvent> athleteEvents) {
        List<HeatRow> heatRows = createHeatRows(heats);
        List<AthleteEventDto> athleteEventDtos = createAthleteEventDtos(athleteEvents);
        for (HeatRow heatRow : heatRows) {
            for (AthleteEventDto athleteEventDto : athleteEventDtos) {
                if (heatRow.getHeatNumber() == athleteEventDto.getHeatNumber()) {
                    athleteEventDtos.add(athleteEventDto);
                }
            }
        }
        return heatRows;
    }

    private List<HeatRow> createHeatRows(List<Heat> heats) {
        return heatMapper.heatsToHeatRows(heats);
    }

    private List<AthleteEventDto> createAthleteEventDtos(List<AthleteEvent> athleteEvents) {
        return athleteEventMapper.athleteEventsToAthleteEventDtos(athleteEvents);
    }
}
